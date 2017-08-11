package com.synphoo.java.test.finalKeyword;

public class FinalC {

	public void fun(final int x){
//		x++;//x是final类型的,值不允许改变的
		System.out.println("x="+x);
	}
	
	public static void main(String[] args) {
		FinalC obj=new FinalC();
		obj.fun(100);
	}
}
