package com.synphoo.java.test.designPattern.singleton;

public class Test1 {
/**
 * @param args
 */
	public static void main(String[] args) {
		SingletonDemo6 instance1=SingletonDemo6.singletonInstance;
		//SingletonDemo6 instance2=SingletonDemo6.class.newInstance();
		SingletonDemo6 instance2=SingletonDemo6.singletonInstance;
		System.out.println("打印instance1="+instance1);
		System.out.println("打印instance2="+instance2);
		System.out.println(instance1==instance2);
	}
	
}
