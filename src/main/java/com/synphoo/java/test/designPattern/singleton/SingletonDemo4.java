package com.synphoo.java.test.designPattern.singleton;
/**
 * 单例类--双重校验锁方式，线程安全，效率高
 * @author wangmingfeng
 *
 */
public class SingletonDemo4 {
	
	private SingletonDemo4(){
		
	}
	
	//定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，
	//避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile SingletonDemo4 instance;
	
	public static SingletonDemo4 getInstance(){
		//instance不等于null时，不使用同步代码块，直接返回对象，提高运行效率
		if(null==instance){
			//对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建
			synchronized (SingletonDemo4.class) {
				if (null==instance) {//同步代码块里再次判断是否为null
					instance=new SingletonDemo4();
				}
			}
		}
		return instance;
	}
	
	//test
	public static void main(String[] args) {
		/**
		 * 通过Java反射机制来实例化private类型的构造方法，
		 * 此时基本上会使所有的Java单例实现失效
		 */
		try {
			SingletonDemo4 instance1=SingletonDemo4.getInstance();
			SingletonDemo4 instance2=SingletonDemo4.class.newInstance();//java反射
			System.out.println("打印instance1="+instance1);
			System.out.println("打印instance2="+instance2);
			System.out.println(instance1==instance2);//注意输出的是false
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
