package vip.openpark.jdk;

import vip.openpark.jdk.common.Human;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author anthony
 * @version 2024/2/23 15:34
 */
public class FieldApplication {
	public static void main(String[] args) throws IllegalAccessException {
		Human human = new Human();
		human.setName("anthony");
		human.setAge(18);
		
		Field[] fields = Human.class.getDeclaredFields();
		for (Field field : fields) {
			// 设置可访问
			field.setAccessible(true);
			
			// 获取名称
			String name = field.getName();
			System.out.println("获取名称：" + name);
			// 获取类型
			Class<?> type = field.getType();
			System.out.println("获取类型：" + type);
			// 获取修饰符 {@code Modifier}
			int modifiers = field.getModifiers();
			System.out.println("获取修饰符：" + Modifier.toString(modifiers));
			
			// 获取值
			System.out.println("获取值：" + field.get(human));
			// 设置值
			if (field.getType().equals(String.class)) {
				field.set(human, "open park");
			}
		}
	}
}