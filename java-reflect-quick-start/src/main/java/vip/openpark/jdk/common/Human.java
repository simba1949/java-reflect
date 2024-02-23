package vip.openpark.jdk.common;

import vip.openpark.jdk.common.annotation.HumanAnnotation;

/**
 * 人类 可以读写
 *
 * @author anthony
 * @version 2024/1/16 10:25
 */
@HumanAnnotation
public class Human extends Animalia implements IRead, IWrite {
	public String name;
	private int age;
	
	public Human() {
	}
	
	private Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Human{" +
			       "name='" + name + '\'' +
			       ", age=" + age +
			       "} " + super.toString();
	}
	
	private void humanPrivateMethod() {
	
	}
	
	@Override
	public void eat() {
	
	}
	
	@Override
	public void sleep() {
	
	}
	
	@Override
	public void absorbedEnergy() {
	
	}
	
	@Override
	public void reproduction() {
	
	}
	
	@Override
	public void breath() {
	
	}
	
	@Override
	public void read() {
	
	}
	
	@Override
	public void sports() {
	
	}
	
	@Override
	public void write() {
	
	}
}