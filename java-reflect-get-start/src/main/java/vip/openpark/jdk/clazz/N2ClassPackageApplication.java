package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;

/**
 * 获取 Class 类所在包信息
 *
 * @author anthony
 * @version 2024/1/17 14:49
 */
public class N2ClassPackageApplication {
	public static void main(String[] args) {
		getClassPackageInfo(Human.class);
	}
	
	/**
	 * <div>
	 *     <title>获取 Class 对象的包信息</title>
	 *     <li>获取 Class 所在包名：Class.getPackage().getName() </li>
	 *     <li>获取 Class 所在包对象：Class.getPackage() </li>
	 * </div>
	 */
	public static void getClassPackageInfo(Class<?> clazz) {
		// 获取 Class 的包名
		String packageName = clazz.getPackageName();
		System.out.println(packageName); // vip.openpark.jdk.common
		
		// 获取 Class 所在包对象
		Package aPackage = clazz.getPackage();
		System.out.println(aPackage); // package vip.openpark.jdk.common
	}
}