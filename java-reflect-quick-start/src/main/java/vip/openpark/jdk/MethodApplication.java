package vip.openpark.jdk;

import vip.openpark.jdk.common.Human;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author anthony
 * @version 2024/2/23 15:56
 */
public class MethodApplication {
	public static void main(String[] args) throws Exception {
		Human human = new Human();
		human.setName("anthony");
		human.setAge(18);
		
		Method[] methods = Human.class.getDeclaredMethods();
		for (Method method : methods) {
			// 设置为可访问
			method.setAccessible(true);
			
			// 获取方法名
			String methodName = method.getName();
			System.out.println("方法名称：" + methodName);
			// 获取注解
			Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
			if (declaredAnnotations.length > 0) {
				System.out.println("方法注解：" + declaredAnnotations[0]);
			}
			
			// 获取参数个数
			int parameterCount = method.getParameterCount();
			System.out.println("参数个数：" + parameterCount);
			
			// 获取参数
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				// 获取参数名
				String name = parameter.getName();
				// 获取参数类型
				Class<?> type = parameter.getType();
				System.out.println("参数名：" + name + " 参数类型：" + type);
				
				Annotation[] parameterAnnotations = parameter.getAnnotations();
				if (parameterAnnotations.length > 0) {
					System.out.println("参数注解：" + parameterAnnotations[0]);
				}
			}
			
			// 获取返回类型
			Class<?> returnType = method.getReturnType();
			System.out.println("返回类型：" + returnType);
			
			if ("getName".equals(methodName)) {
				System.out.println("Method 执行 getName 方法：" + method.invoke(human));
			}
		}
	}
}