/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.designPattern.singleton;

/**
 * 单例类--饿汉式，线程安全，效率比较低
 * http://www.cnblogs.com/yinxiaoqiexuxing/p/5605338.html
 * @author wangmingfeng
 *
 */
public class SingletonDemo1{
	/**
	 * 介绍：
	 *    优点是：写起来比较简单，而且不存在多线程同步问题，避免了synchronized所造成的性能问题；
		    缺点是：当类SingletonTest被加载的时候，会初始化static的instance，静态变量被创建并分配内存空间，
				  从这以后，这个static的instance对象便一直占着这段内存（即便你还没有用到这个实例），当类被卸载时，
				  静态变量被摧毁，并释放所占有的内存，因此在某些特定条件下会耗费内存。
	 */
	private SingletonDemo1(){
		
	}
	
	private static final SingletonDemo1 instance=new SingletonDemo1();//使用final关键字
	
	public static SingletonDemo1 getInstance(){
		return instance;
	}
	
}