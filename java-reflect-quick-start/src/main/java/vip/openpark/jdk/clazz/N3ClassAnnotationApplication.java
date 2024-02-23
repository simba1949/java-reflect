package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.annotation.AnimaliaAnnotation;
import vip.openpark.jdk.common.annotation.BiologyAnnotation;
import vip.openpark.jdk.common.annotation.HumanAnnotation;
import vip.openpark.jdk.common.Human;

import java.lang.annotation.Annotation;

/**
 * <div>
 *     获取注解信息
 * </div>
 *
 * @author anthony
 * @version 2024/1/17 14:51
 */
public class N3ClassAnnotationApplication {
	public static void main(String[] args) {
		getAnnotationInfo(Human.class);
	}
	
	/**
	 * <div>
	 *     <title>获取注解信息</title>
	 * </div>
	 *
	 * @param clazz Class
	 */
	public static void getAnnotationInfo(Class<?> clazz) {
		// 获取声明在当前Class上的注解数组
		Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
		
		// 获取指定声明在当前Class上的注解
		HumanAnnotation declaredAnnotation4Human = clazz.getDeclaredAnnotation(HumanAnnotation.class);
		AnimaliaAnnotation declaredAnnotation4Animalia = clazz.getDeclaredAnnotation(AnimaliaAnnotation.class);
		BiologyAnnotation declaredAnnotation4Biology = clazz.getDeclaredAnnotation(BiologyAnnotation.class);
		
		Annotation[] declaredAnnotationsByType4Human = clazz.getDeclaredAnnotationsByType(HumanAnnotation.class);
		Annotation[] declaredAnnotationsByType4Animalia = clazz.getDeclaredAnnotationsByType(AnimaliaAnnotation.class);
		Annotation[] declaredAnnotationsByType4Biology = clazz.getDeclaredAnnotationsByType(BiologyAnnotation.class);
		
		
		// 获取注解数组，包含父类上的注解（父类注解需要@Inherited修饰，否则也获取不到），不包含接口上的注解
		Annotation[] annotations = clazz.getAnnotations();
		
		// 获取注解数组，包含父类上的注解（父类注解需要@Inherited修饰，否则也获取不到），不包含接口上的注解
		HumanAnnotation annotation4Human = clazz.getAnnotation(HumanAnnotation.class);
		AnimaliaAnnotation annotation46Human = clazz.getAnnotation(AnimaliaAnnotation.class);
		BiologyAnnotation annotation47Human = clazz.getAnnotation(BiologyAnnotation.class);
		
		HumanAnnotation[] annotationsByType4Human = clazz.getAnnotationsByType(HumanAnnotation.class);
		AnimaliaAnnotation[] annotationsByType4Animalia = clazz.getAnnotationsByType(AnimaliaAnnotation.class);
		BiologyAnnotation[] annotationsByType4Biology = clazz.getAnnotationsByType(BiologyAnnotation.class);
	}
}