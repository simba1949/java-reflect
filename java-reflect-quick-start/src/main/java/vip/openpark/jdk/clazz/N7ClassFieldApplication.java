package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.Field;

/**
 * @author anthony
 * @version 2024/1/18 14:25
 */
public class N7ClassFieldApplication {
	public static void main(String[] args) throws NoSuchFieldException {
		getField(Human.class);
	}
	
	public static void getField(Class<?> clazz) throws NoSuchFieldException {
		// 获取 class 中的声明的字段
		Field[] declaredFields = clazz.getDeclaredFields();
		// 获取 class 中的声明的指定字段
		Field declaredField = clazz.getDeclaredField("age");
		
		// 获取 class 中的所有 public 修饰的字段，包含父类、接口中的字段
		Field[] fields = clazz.getFields();
		// 获取 class 中的所有 public 修饰的指定字段，包含父类、接口中的字段
		Field field = clazz.getField("PEN_NAME");
	}
}