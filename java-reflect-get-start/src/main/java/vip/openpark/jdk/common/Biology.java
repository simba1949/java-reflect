package vip.openpark.jdk.common;

import vip.openpark.jdk.common.annotation.BiologyAnnotation;

/**
 * 生物类
 *
 * @author anthony
 * @version 2024/1/17 17:25
 */
@BiologyAnnotation
public abstract class Biology implements IBreathe {
	
	/**
	 * 吸收能量
	 */
	public abstract void absorbedEnergy();
	
	/**
	 * 繁殖
	 */
	public abstract void reproduction();
	
	private void biologyPrivateMethod() {
	
	}
}