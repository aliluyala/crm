package com.synphoo.java.test.staticKeyword;
/**
 * static 静态内部类
 * @author wangmingfeng
 *
 */
public class StaticG {
	
	public StaticG() {
		System.out.println("outer class constructor");
	}
	/**
	 * static不能用来修饰普通的类，但可以用来修饰内部类
	 */
	public static class InnerG{
		public InnerG() {
			System.out.println("inner class constructor");
		}
	}
	
}
