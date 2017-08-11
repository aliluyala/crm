package com.synphoo.java.test.staticKeyword;

public class StaticF {
	
	static int i=0;
	
	/**
	 * 无参构造函数
	 */
	StaticF() {
		//System.out.println("do StaticF constructor");
		i=10;
	}
	
	/**
	 * 带参构造函数
	 * @param j
	 */
	StaticF(int j) {
		//System.out.println("do StaticF constructor with params");
		i=j;
	}
	
	//静态方法
	static void doAdd(){
		i++;
	}
	
	

}
