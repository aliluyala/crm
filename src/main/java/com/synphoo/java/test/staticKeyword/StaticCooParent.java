package com.synphoo.java.test.staticKeyword;

class StaticCooParent {

	static String pName="父级姓名";
	//非静态代码块
	{
		System.out.println("parent block");
	}
	//静态代码块
	static {
		System.out.println("parent static block");
	}
	
	public StaticCooParent() {
		System.out.println("parent constructor");
	}
}
