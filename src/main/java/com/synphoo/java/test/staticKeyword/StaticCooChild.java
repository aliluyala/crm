package com.synphoo.java.test.staticKeyword;

class StaticCooChild extends StaticCooParent {

	static String childName="子级姓名";
	//非静态代码块
	{
		System.out.println("child block");
	}
	//静态代码块
	static {
		System.out.println("child static block");
	}
	public StaticCooChild() {
		System.out.println("child contructor");
	}
	
	//test main
	public static void main(String[] args) {
		StaticCooChild child=new StaticCooChild();
		/**
		 * 输出顺序
		parent static block
		child static block
		parent block
		parent constructor
		child block
		child contructor

		 */
	}
}
