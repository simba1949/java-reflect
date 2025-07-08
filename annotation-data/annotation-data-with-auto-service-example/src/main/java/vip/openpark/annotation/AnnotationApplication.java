package vip.openpark.annotation;

/**
 * @author anthony
 * @version 2025/7/8
 * @since 2025/7/8 23:00
 */
public class AnnotationApplication {
	/**
	 * 导入代码时，ide 会报错的，但是编译完成之后 ide 会找到对应的 class 文件，可以正常运行
	 */
	public static void main(String[] args) {
		HumanDataGen humanDataGen = new HumanDataGen();
		humanDataGen.setName("anthony");
		System.out.println(humanDataGen.getName());
	}
}