package com.synphoo.java.test.staticKeyword;

public class TestStaticCooChild {
	//test main
		public static void main(String[] args) {
			StaticCooChild child=new StaticCooChild();
		}
		
		/**
		 * 输出顺序：
parent static block
child static block
parent block
parent constructor
child block
child contructor
-------------------------------
【java初始化，类加载顺序】
父类静态成员变量；
父类静态成员方法；
子类静态成员变量；
子类静态成员方法；
父类非静态成员变量；
父类非静态成员方法；
父类构造函数；
子类非静态成员变量；
子类非静态成员方法；
子类构造函数；
------------------------------
		 * 
		 */
}
