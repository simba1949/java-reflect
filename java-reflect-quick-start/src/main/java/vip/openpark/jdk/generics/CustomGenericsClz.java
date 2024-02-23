package vip.openpark.jdk.generics;

import java.util.List;

/**
 * @author anthony
 * @version 2024/2/23 16:12
 */
public class CustomGenericsClz<T> {
	private T t;
	private List<T> list;
	
	public CustomGenericsClz() {
	}
	
	public CustomGenericsClz(T t, List<T> list) {
		this.t = t;
		this.list = list;
	}
	
	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "CustomGenericsClz{" +
			       "t=" + t +
			       ", list=" + list +
			       '}';
	}
}