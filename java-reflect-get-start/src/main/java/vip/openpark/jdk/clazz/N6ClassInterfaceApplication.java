package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;

/**
 * @author anthony
 * @version 2024/1/17 17:46
 */
public class N6ClassInterfaceApplication {
	public static void main(String[] args) {
		getInterfaceInfo(Human.class);
	}
	
	private static void getInterfaceInfo(Class<?> clazz) {
		// 获取 Class 的接口数组，不包含父类实现的接口
		Class<?>[] interfaces = clazz.getInterfaces();
		
		// 获取 Class 是否为接口
		boolean anInterface = clazz.isInterface();
		
		AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();
		Type[] genericInterfaces = clazz.getGenericInterfaces();
	}
}
