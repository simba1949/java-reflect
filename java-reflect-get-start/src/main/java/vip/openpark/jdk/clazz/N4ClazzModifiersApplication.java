package vip.openpark.jdk.clazz;

import java.lang.reflect.Modifier;

/**
 * 获取修饰语
 *
 * @author anthony
 * @version 2024/1/17 11:21
 */
public class N4ClazzModifiersApplication {
	
	public static void main(String[] args) throws Exception {
		// interface 修饰的类
		getClazzModifiersInfo(Interface.class.getModifiers());
		
		// 是否抽象
		// 第一种是：使用 abstract 修饰的类/方法
		// 第二种是：使用 interface 修饰的接口
		getClazzModifiersInfo(AbstractClass.class.getModifiers());
		getClazzModifiersInfo(AbstractClass.class.getDeclaredMethod("abstractMethod").getModifiers());
		
		// native 修饰的方法 【注意】：native 用于修饰方法，不能修饰类
		getClazzModifiersInfo(NativeClass.class.getDeclaredMethod("nativeMethod").getModifiers());
		
		// final 修饰的类/方法/字段
		getClazzModifiersInfo(FinalClass.class.getModifiers());
		getClazzModifiersInfo(FinalClass.class.getDeclaredField("FINAL_FIELD").getModifiers());
		getClazzModifiersInfo(FinalClass.class.getDeclaredMethod("finalMethod").getModifiers());
		
		// static 修饰的类/方法/字段
		getClazzModifiersInfo(StaticClass.class.getModifiers());
		getClazzModifiersInfo(StaticClass.class.getDeclaredField("STATIC_FIELD").getModifiers());
		getClazzModifiersInfo(StaticClass.class.getDeclaredMethod("staticMethod").getModifiers());
		
		// private 修饰的类/方法/字段
		getClazzModifiersInfo(PrivateClass.class.getModifiers());
		getClazzModifiersInfo(PrivateClass.class.getDeclaredField("PRIVATE_FIELD").getModifiers());
		getClazzModifiersInfo(PrivateClass.class.getDeclaredMethod("privateMethod").getModifiers());
		
		// protected 修饰的类/方法/字段
		getClazzModifiersInfo(ProtectedClass.class.getModifiers());
		getClazzModifiersInfo(ProtectedClass.class.getDeclaredField("PROTECTED_FIELD").getModifiers());
		getClazzModifiersInfo(ProtectedClass.class.getDeclaredMethod("protectedMethod").getModifiers());
		
		// public 修饰的类/方法/字段
		getClazzModifiersInfo(PublicClass.class.getModifiers());
		getClazzModifiersInfo(PublicClass.class.getDeclaredField("PUBLIC_FIELD").getModifiers());
		getClazzModifiersInfo(PublicClass.class.getDeclaredMethod("publicMethod").getModifiers());
		
		// synchronized 修饰的方法【注意】：synchronized 用于修饰方法，不能修饰类
		getClazzModifiersInfo(SynchronizedClass.class.getDeclaredMethod("synchronizedMethod").getModifiers());
		
		// transient 修饰的字段， 【注意】：transient 用于修饰字段，不能修饰方法或者类
		getClazzModifiersInfo(TransientClass.class.getDeclaredField("transientField").getModifiers());
		
		// volatile 修饰的字段，【注意】：volatile 用于修饰字段，不能修饰方法或者类
		getClazzModifiersInfo(VolatileClass.class.getDeclaredField("volatileField").getModifiers());
	}
	
	/**
	 * 获取修饰语
	 */
	public static void getClazzModifiersInfo(int modifiers) {
		boolean anInterface = Modifier.isInterface(modifiers);
		
		boolean anAbstract = Modifier.isAbstract(modifiers);
		
		boolean aNative = Modifier.isNative(modifiers);
		
		boolean aFinal = Modifier.isFinal(modifiers);
		
		// 示例：{@link java.util.AbstractMap.SimpleEntry}
		boolean aStatic = Modifier.isStatic(modifiers);
		
		boolean aPrivate = Modifier.isPrivate(modifiers);
		boolean aProtected = Modifier.isProtected(modifiers);
		boolean aPublic = Modifier.isPublic(modifiers);
		
		boolean strict = Modifier.isStrict(modifiers);
		
		boolean aSynchronized = Modifier.isSynchronized(modifiers);
		
		boolean aTransient = Modifier.isTransient(modifiers);
		
		boolean aVolatile = Modifier.isVolatile(modifiers);
	}
	
	interface Interface {
		void interfaceMethod();
	}
	
	abstract static class AbstractClass {
		abstract void abstractMethod();
	}
	
	private static class PrivateClass {
		private Integer PRIVATE_FIELD;
		
		private void privateMethod() {
		
		}
	}
	
	protected static class ProtectedClass {
		protected int PROTECTED_FIELD = 3;
		
		protected void protectedMethod() {
		
		}
	}
	
	final static class FinalClass {
		final int FINAL_FIELD = 1;
		
		final void finalMethod() {
		
		}
	}
	
	static class NativeClass {
		native void nativeMethod();
	}
	
	static class StaticClass {
		static Integer STATIC_FIELD;
		
		static void staticMethod() {
		
		}
	}
	
	public static class PublicClass {
		public Integer PUBLIC_FIELD;
		
		public void publicMethod() {
		
		}
	}
	
	static class SynchronizedClass {
		synchronized void synchronizedMethod() {
		
		}
	}
	
	static class TransientClass {
		transient int transientField;
	}
	
	static class VolatileClass {
		volatile int volatileField;
	}
}