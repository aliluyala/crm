package com.synphoo.java.test.staticKeyword;

public class StaticGTest {

	public static void main(String[] args) {
		//声明为静态的内部类可以直接作为一个普通类来使用，而不需实例一个外部类
		StaticG.InnerG obj=new StaticG.InnerG();
	}
	/**
	 输出结果：
	 inner class constructor
	 */
}
