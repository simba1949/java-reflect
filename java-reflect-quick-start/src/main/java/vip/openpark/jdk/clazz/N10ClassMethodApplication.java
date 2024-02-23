package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @version 2024/1/18 14:26
 */
public class N10ClassMethodApplication {
	public static void main(String[] args) throws NoSuchMethodException {
		getMethod(Human.class);
	}
	
	public static void getMethod(Class<?> clazz) throws NoSuchMethodException {
		// 获取 Class 中所有声明的方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		// 获取 Class 中所有声明的方法中的指定方法
		Method declaredMethod = clazz.getDeclaredMethod("humanPrivateMethod");
		
		// 获取 public 修饰的所有方法，包括父类中的方法
		Method[] methods = clazz.getMethods();
		// 获取 public 修饰的所有方法中指定方法，包括父类中的方法
		Method method = clazz.getMethod("notify");
		
		Method enclosingMethod = clazz.getEnclosingMethod();
	}
}
