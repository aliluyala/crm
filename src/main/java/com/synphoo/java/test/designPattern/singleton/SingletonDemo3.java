package com.synphoo.java.test.designPattern.singleton;

/**
 * 单例类--饱汉式，线程安全的简单实现
 * @author wangmingfeng
 *
 */
public class SingletonDemo3 {
/**
 * 优点是：使用synchronized关键字避免多线程访问时，出现多个SingletonTest实例。
      缺点是：同步方法频繁调用时，效率略低。
 */
	private SingletonDemo3(){
		
	}
	
	private static SingletonDemo3 instance;//没有使用final关键字
	
	//使用synchronized 避免多线程访问时，可能造成的重复初始化问题
	public static synchronized SingletonDemo3 getInstance(){
		if(null==instance){
			instance=new SingletonDemo3();
		}
		return instance;
	}
}
