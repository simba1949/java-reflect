package vip.openpark.jdk.common;

import vip.openpark.jdk.common.annotation.AnimaliaAnnotation;

/**
 * 动物类
 *
 * @author anthony
 * @version 2024/1/17 11:19
 */
@AnimaliaAnnotation
public abstract class Animalia extends Biology implements ISports {
	
	/**
	 * 外形
	 */
	public String shape;
	/**
	 * 细胞
	 */
	private String cell;
	
	/**
	 * 觅食
	 */
	public abstract void eat();
	
	private void animatePrivateMethod() {
	
	}
	
	/**
	 * 休息
	 */
	public abstract void sleep();
	
	public String getShape() {
		return shape;
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String getCell() {
		return cell;
	}
	
	public void setCell(String cell) {
		this.cell = cell;
	}
}