package vip.openpark.annotation;

/**
 * @author anthony
 * @version 2025/7/4
 * @since 2025/7/4 7:36
 */
public class HumanApplication {
	public static void main(String[] args) {
		Human human = new Human();
		human.setName("anthony");
		System.out.println(human.getName());
	}
}
