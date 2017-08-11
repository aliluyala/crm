package com.synphoo.java.test.staticKeyword;

public class StaticETest {

	public static void doPrint(String str){
		System.out.println("打印="+str);
	}
	
	public static void main(String[] args) {
		StaticE obj1,obj2;
		obj1=new StaticE();
		obj2=new StaticE();
		doPrint("obj1.i="+obj1.i+", obj2.i="+obj2.i);
		obj1.add();
		doPrint("obj1.i="+obj1.i+", obj2.i="+obj2.i);
		/**
		 --> 类装载时，只分配一块存储空间，所有此类的对象都可以操控此块存储空间
		 打印=obj1.i=0, obj2.i=0
		 打印=obj1.i=1, obj2.i=1
		 */
	}
	
}
