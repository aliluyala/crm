package com.synphoo.java.test.designPattern.singleton;
/**
 * 单例类--静态内部类方式
 * @author wangmingfeng
 *
 */
public class SingletonDemo5 {
/**
 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程
 * 
 * 
 */
	
	private SingletonDemo5(){
		
	}
	
	/**
	 * 静态内部类
	 */
	private static class InnerFactory{
		private static final SingletonDemo5 obj = new SingletonDemo5();
	}
	
	public static SingletonDemo5 getInstance(){
		return InnerFactory.obj;
	}
}
