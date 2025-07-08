package vip.openpark.annotation;

import com.google.auto.service.AutoService;
import com.palantir.javapoet.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@AutoService(Processor.class)
@SupportedAnnotationTypes("vip.openpark.annotation.DataAnnotation")
public class DataAnnotationProcessor extends AbstractProcessor {

	private Messager messager;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		messager = processingEnv.getMessager();
		messager.printMessage(Diagnostic.Kind.NOTE, "初始化 DataAnnotationProcessor");
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		messager.printMessage(Diagnostic.Kind.NOTE, "开始处理注解...");

		for (TypeElement annotation : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
			messager.printMessage(Diagnostic.Kind.NOTE, "找到 " + elements.size() + " 个使用 @" + annotation.getSimpleName() + " 的元素");

			for (Element element : elements) {
				if (element.getKind() == ElementKind.CLASS) {
					processClass((TypeElement) element);
				}
			}
		}
		return true;
	}

	private void processClass(TypeElement classElement) {
		try {
			messager.printMessage(Diagnostic.Kind.NOTE, "处理类: " + classElement.getQualifiedName());
			generateCode(classElement);
		} catch (Exception e) {
			messager.printMessage(Diagnostic.Kind.ERROR, "生成代码失败: " + e.getMessage(), classElement);
		}
	}

	private void generateCode(TypeElement classElement) throws IOException {
		PackageElement packageElement = processingEnv.getElementUtils().getPackageOf(classElement);
		String packageName = packageElement.getQualifiedName().toString();
		String className = classElement.getSimpleName().toString() + "DataGen";
		List<VariableElement> fields = getFields(classElement);

		// 创建包含字段的类
		TypeSpec.Builder classBuilder = TypeSpec.classBuilder(className)
			.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
			.addJavadoc("由 @DataAnnotation 注解自动生成的数据类\n\n@since " + new Date() + "\n");

		// 添加字段
		for (VariableElement field : fields) {
			TypeName fieldType = TypeName.get(field.asType());
			String fieldName = field.getSimpleName().toString();
			classBuilder.addField(fieldType, fieldName, Modifier.PRIVATE);
		}

		// 添加无参构造方法
		classBuilder.addMethod(MethodSpec.constructorBuilder()
			.addModifiers(Modifier.PUBLIC)
			.build());

		// 添加全参构造方法
		MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
			.addModifiers(Modifier.PUBLIC);

		for (VariableElement field : fields) {
			String fieldName = field.getSimpleName().toString();
			TypeName fieldType = TypeName.get(field.asType());
			constructorBuilder.addParameter(fieldType, fieldName)
				.addStatement("this.$N = $N", fieldName, fieldName);
		}
		classBuilder.addMethod(constructorBuilder.build());

		// 添加其他方法
		classBuilder.addMethod(generateToStringMethod(className, fields));
		classBuilder.addMethod(generateEqualsMethod(className, fields));
		classBuilder.addMethod(generateHashCodeMethod(fields));

		for (VariableElement field : fields) {
			classBuilder.addMethod(generateGetter(field));
			classBuilder.addMethod(generateSetter(field));
		}

		// 写入文件
		JavaFile javaFile = JavaFile.builder(packageName, classBuilder.build())
			.indent("    ")
			.build();

		messager.printMessage(Diagnostic.Kind.NOTE, "生成: " + javaFile.packageName() + "." + className);
		javaFile.writeTo(processingEnv.getFiler());
	}

	private List<VariableElement> getFields(TypeElement classElement) {
		return classElement.getEnclosedElements().stream()
			.filter(element -> element.getKind() == ElementKind.FIELD)
			.filter(element -> !element.getModifiers().contains(Modifier.STATIC))
			.map(element -> (VariableElement) element)
			.collect(Collectors.toList());
	}

	private MethodSpec generateToStringMethod(String className, List<VariableElement> fields) {
		// 使用StringBuilder安全生成toString
		MethodSpec.Builder builder = MethodSpec.methodBuilder("toString")
			.addAnnotation(Override.class)
			.addModifiers(Modifier.PUBLIC)
			.returns(String.class);

		builder.addStatement("$T sb = new $T()", StringBuilder.class, StringBuilder.class);
		builder.addStatement("sb.append(\"$L[\")", className);

		for (int i = 0; i < fields.size(); i++) {
			String fieldName = fields.get(i).getSimpleName().toString();
			if (i == 0) {
				builder.addStatement("sb.append(\"$L='\").append(this.$L).append('\\'')", fieldName, fieldName);
			} else {
				builder.addStatement("sb.append(\", $L='\").append(this.$L).append('\\'')", fieldName, fieldName);
			}
		}

		builder.addStatement("sb.append(']')");
		builder.addStatement("return sb.toString()");

		return builder.build();
	}

	private MethodSpec generateEqualsMethod(String className, List<VariableElement> fields) {
		ParameterSpec other = ParameterSpec.builder(Object.class, "o").build();
		MethodSpec.Builder builder = MethodSpec.methodBuilder("equals")
			.addAnnotation(Override.class)
			.addModifiers(Modifier.PUBLIC)
			.returns(boolean.class)
			.addParameter(other);

		builder.addStatement("if (this == o) return true");
		builder.addStatement("if (o == null || getClass() != o.getClass()) return false");
		builder.addStatement("$L that = ($L) o", className, className);

		for (VariableElement field : fields) {
			String fieldName = field.getSimpleName().toString();
			TypeName fieldType = TypeName.get(field.asType());

			if (fieldType.isPrimitive()) {
				builder.addStatement("if ($L != that.$L) return false", fieldName, fieldName);
			} else {
				builder.addStatement("if ($L != null ? !$L.equals(that.$L) : that.$L != null) return false",
					fieldName, fieldName, fieldName, fieldName);
			}
		}

		builder.addStatement("return true");
		return builder.build();
	}

	private MethodSpec generateHashCodeMethod(List<VariableElement> fields) {
		MethodSpec.Builder builder = MethodSpec.methodBuilder("hashCode")
			.addAnnotation(Override.class)
			.addModifiers(Modifier.PUBLIC)
			.returns(int.class);

		if (fields.isEmpty()) {
			builder.addStatement("return 0");
		} else {
			builder.addStatement("$T result = $T.hash(this.getClass())", int.class, Objects.class);
			for (VariableElement field : fields) {
				String fieldName = field.getSimpleName().toString();
				builder.addStatement("result = $T.hash(result, this.$L)", Objects.class, fieldName);
			}
			builder.addStatement("return result");
		}

		return builder.build();
	}

	private MethodSpec generateGetter(VariableElement field) {
		String fieldName = field.getSimpleName().toString();
		String methodName = "get" + capitalize(fieldName);
		TypeMirror fieldType = field.asType();

		return MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.returns(TypeName.get(fieldType))
			.addStatement("return this.$L", fieldName)
			.build();
	}

	private MethodSpec generateSetter(VariableElement field) {
		String fieldName = field.getSimpleName().toString();
		String methodName = "set" + capitalize(fieldName);
		TypeMirror fieldType = field.asType();

		return MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.returns(void.class)
			.addParameter(TypeName.get(fieldType), fieldName)
			.addStatement("this.$L = $L", fieldName, fieldName)
			.build();
	}

	private String capitalize(String str) {
		if (str == null || str.isEmpty()) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}