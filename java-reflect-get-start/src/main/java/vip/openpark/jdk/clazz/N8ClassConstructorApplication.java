package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.Constructor;

/**
 * @author anthony
 * @version 2024/1/18 14:23
 */
public class N8ClassConstructorApplication {
	public static void main(String[] args) throws NoSuchMethodException {
		getConstructor(Human.class);
	}
	
	public static void getConstructor(Class<?> clazz) throws NoSuchMethodException {
		// 获取 Class 的所有构造方法
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		// 获取 Class 的所有构造方法中指定的构造方法
		Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
		
		// 获取 Class 的所有 public 修饰的构造方法
		Constructor<?>[] constructors = clazz.getConstructors();
		// 获取 Class 的所有 public 修饰的构造方法中指定的构造方法
		Constructor<?> constructor = clazz.getConstructor();
		
		// 用于获取指定类的封闭构造函数。封闭构造函数是指在匿名内部类或局部内部类中引用的外部类的构造函数。
		// 通过调用getEnclosingConstructor()方法，可以获取到封闭构造函数的引用。
		Constructor<?> enclosingConstructor = clazz.getEnclosingConstructor();
	}
}