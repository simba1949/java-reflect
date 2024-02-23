package vip.openpark.jdk.common;

import vip.openpark.jdk.common.annotation.SportsAnnotation;

/**
 * 运动
 *
 * @author anthony
 * @version 2024/1/17 11:19
 */
@SportsAnnotation
public interface ISports {
	String SPORTS_NAME = "";
	
	void sports();
}