package com.synphoo.java.test.staticKeyword;

import java.util.Random;

public class StaticFinalH {

	public static final int num=4+4;//静态final变量在编译时是确定的
	
	public static final int random=4+new Random().nextInt();//静态final变量在编译时不是确定的
	
	static{
		System.out.println("如果static代码块执行了，证明类初始化了。");
	}
	
}
