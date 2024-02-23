package vip.openpark.jdk.common;

import vip.openpark.jdk.common.annotation.WriteAnnotation;

/**
 * 写作
 *
 * @author anthony
 * @version 2024/1/18 14:55
 */
@WriteAnnotation
public interface IWrite {
	String PEN_NAME = "毛笔";
	
	void write();
}