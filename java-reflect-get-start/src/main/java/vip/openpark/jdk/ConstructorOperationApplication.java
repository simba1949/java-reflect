package vip.openpark.jdk;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.Constructor;

/**
 * @author anthony
 * @version 2024/1/18 17:18
 */
public class ConstructorOperationApplication {
	public static void main(String[] args) throws Exception {
		// createInstance(Human.class);
		
		getConstructorParameters(Human.class);
	}
	
	/**
	 * 创建实例
	 *
	 * @param clazz Class
	 * @throws Exception 异常
	 */
	public static void createInstance(Class<?> clazz) throws Exception {
		// 第一种方式：clazz.newInstance();【备注：从 Jdk9 开始，该方法已废弃】
		Human newInstance0 = (Human) clazz.newInstance();
		System.out.println(newInstance0.toString());
		
		// 第二种方式：通过构造器创建实例
		// 获取无参构造器
		Constructor<?> constructor1 = clazz.getConstructor();
		constructor1.setAccessible(true);
		Human newInstance1 = (Human) constructor1.newInstance();
		System.out.println(newInstance1.toString());
		// 获取有参构造器
		Constructor<?> constructor2 = clazz.getDeclaredConstructor(String.class, int.class);
		constructor2.setAccessible(true);
		Human newInstance2 = (Human) constructor2.newInstance("name", 18);
		System.out.println(newInstance2.toString());
	}
	
	/**
	 * 获取构造器参数
	 *
	 * @param clazz Class
	 */
	public static void getConstructorParameters(Class<?> clazz) {
		System.out.println("======== 所有声明的构造方法 ===========");
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			declaredConstructor.setAccessible(true);
			Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
			if (parameterTypes.length == 0) {
				System.out.println("无参数构造器");
			} else {
				for (int i = 0; i < parameterTypes.length; i++) {
					System.out.println(parameterTypes[i].getName());
				}
			}
		}
		
		System.out.println("======== public修饰的构造方法 ===========");
		
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			if (parameterTypes.length == 0) {
				System.out.println("无参数构造器");
			} else {
				for (int i = 0; i < parameterTypes.length; i++) {
					System.out.println(parameterTypes[i].getName());
				}
			}
		}
	}
}