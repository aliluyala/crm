package com.synphoo.java.test.staticKeyword;

public class StaticE {

	/**
	 * 当声明一个对象时，并不产生static变量的拷贝，而是该类所有的实例变量共用同一个static变量。
	 * 所有此类实例共享此静态变量，也就是说在类装载时，只分配一块存储空间，所有此类的对象都可以操控此块存储空间。
	 */
	static int i=0;//所有类的实例 共享一块存储区
	
	static void add(){
		i++;
	}
}
