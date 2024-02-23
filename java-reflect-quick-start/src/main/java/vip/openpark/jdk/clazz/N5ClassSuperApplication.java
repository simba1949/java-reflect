package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;

/**
 * 获取 Class 父类信息
 *
 * @author anthony
 * @version 2024/1/17 17:45
 */
public class N5ClassSuperApplication {
	public static void main(String[] args) {
		getSuperClassInfo(Human.class);
	}
	
	public static void getSuperClassInfo(Class<?> clazz) {
		// 获取 Class 的父类，如果 Class 无父类，返回 java.lang.Object
		Class<?> superclass = clazz.getSuperclass();
		
		AnnotatedType annotatedSuperclass = clazz.getAnnotatedSuperclass();
		Type genericSuperclass = clazz.getGenericSuperclass();
	}
}