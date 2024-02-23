package vip.openpark.jdk;

import vip.openpark.jdk.generics.CustomGenericsClz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anthony
 * @version 2024/2/23 16:11
 */
public class GenericsApplication {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		Class<?> clzClass = CustomGenericsClz.class;
		Field[] declaredFields = clzClass.getDeclaredFields();
		for (Field field : declaredFields) {
			Type genericType = field.getGenericType();
			System.out.println(genericType);
		}
		
		Method[] declaredMethods = clzClass.getDeclaredMethods();
		for (Method method : declaredMethods) {
			Type genericType = method.getGenericReturnType();
			System.out.println(genericType);
		}
	}
}
