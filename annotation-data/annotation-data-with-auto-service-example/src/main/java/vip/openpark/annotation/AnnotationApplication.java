package vip.openpark.annotation;

/**
 * @author anthony
 * @version 2025/7/8
 * @since 2025/7/8 23:00
 */
public class AnnotationApplication {
	public static void main(String[] args) {
		HumanDataGen humanDataGen = new HumanDataGen();
		humanDataGen.setName("anthony");
		System.out.println(humanDataGen.getName());
	}
}