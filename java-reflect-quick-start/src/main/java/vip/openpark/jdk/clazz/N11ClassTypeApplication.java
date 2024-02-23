package vip.openpark.jdk.clazz;

import vip.openpark.jdk.common.Human;
import vip.openpark.jdk.common.annotation.HumanAnnotation;

/**
 * @author anthony
 * @version 2024/2/23 16:47
 */
public class N11ClassTypeApplication {
	public static void main(String[] args) {
		Human human = new Human();
		
		Class<?> aClass = Human.class;
		// 判断 class 是否是接口
		System.out.println(aClass.isInterface());
		// 判断 class 是否是枚举
		System.out.println(aClass.isEnum());
		// 判断 class 是否是注解
		System.out.println(aClass.isAnnotation());
		// 判断 class 是否存在指定注解
		System.out.println(aClass.isAnnotationPresent(HumanAnnotation.class));
		// 判断 class 是否是匿名类
		System.out.println(aClass.isAnonymousClass());
		// 判断 class 是否是数组
		System.out.println(aClass.isArray());
		// 确定此Class对象表示的类或接口是否与指定Class参数表示的类或接口相同，或者是其超类或超接口。
		System.out.println(aClass.isAssignableFrom(Human.class));
		// System.out.println(aClass.isHidden());
		// 判断 class 是否是其实例，等价于 instanceof
		System.out.println(aClass.isInstance(human));
		// System.out.println(aClass.isLocalClass());
		// System.out.println(aClass.isMemberClass());
		// System.out.println(aClass.isNestmateOf());
		// 判断 class 是否是基本类型
		System.out.println(aClass.isPrimitive());
		// 判断 class 是否是记录类
		System.out.println(aClass.isRecord());
		// 当且仅当此Class对象表示密封类或接口时返回true。
		System.out.println(aClass.isSealed());
		// System.out.println(aClass.isSynthetic());
		// System.out.println(aClass.isUnnamedClass());
	}
}