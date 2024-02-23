package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

/**
 * 1.获取 Class 方法
 * 2.获取 Class 信息
 *
 * @author anthony
 * @version 2024/1/16 10:16
 */
public class N1ClassApplication {
	public static void main(String[] args) throws ClassNotFoundException {
		getClazz();
		
		getClazzInfo(Human.class);
	}
	
	/**
	 * <div>
	 *     <title>获取 Class 对象的多种方式</title>
	 *     <1>Class.forName(String className)</1>
	 *     <2>通过对象名.class 获取</2>
	 *     <3>通过实例对象.getClass() 获取</3>
	 * </div>
	 */
	public static void getClazz() throws ClassNotFoundException {
		// Class.forName("类的全限定名")
		// Class.forName(String className)
		Class<?> clazz1 = Class.forName("vip.openpark.jdk.common.Human");
		
		// 通过类名.class 获取
		Class<Human> clazz2 = Human.class;
		// 基本类型获取 Class
		Class<Integer> integerClass = int.class;
		
		// 通过实例对象.getClass() 获取
		Human human = new Human();
		Class<?> clazz3 = human.getClass();
		
		System.out.println(clazz1 == clazz2); // true
		System.out.println(clazz2 == clazz3); // true
	}
	
	/**
	 * <div>
	 *     <title>获取 Class 对象的属性信息</title>
	 *     <li>获取 Class 全限定名：Class.getName() </li>
	 *     <li>获取 Class 简称：Class.getSimpleName() </li>
	 * </div>
	 */
	public static void getClazzInfo(Class<?> clazz) {
		// 获取 Class 全限定名
		String name = clazz.getName();
		System.out.println(name); // vip.openpark.jdk.common.Human
		// 获取 Class 简称
		String simpleName = clazz.getSimpleName();
		System.out.println(simpleName); // Human
	}
}