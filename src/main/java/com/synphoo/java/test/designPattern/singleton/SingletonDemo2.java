package com.synphoo.java.test.designPattern.singleton;
/**
 * 单例类--饱汉模式,非线程安全
 * @author wangmingfeng
 *
 */
public class SingletonDemo2 {
/**
优点是：写起来比较简单，当类SingletonTest被加载的时候，静态变量static的instance未被创建并分配内存空间，
	      当getInstance方法第一次被调用时，初始化instance变量，并分配内存，因此在某些特定条件下会节约了内存；
缺点是：并发环境下很可能出现多个SingletonTest实例。	
 */
	private SingletonDemo2(){
		
	}
	
	private static SingletonDemo2 instance;//没有使用final关键字
	
	public static SingletonDemo2 getInstance(){
		if(null==instance){
			//多线程访问时，可能造成重复初始化问题
			instance=new SingletonDemo2();
		}
		return instance;
	}

}
