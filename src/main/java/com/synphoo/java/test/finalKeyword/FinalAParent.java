package com.synphoo.java.test.finalKeyword;
/**
 * final修饰方法
 * @author wangmingfeng
 *
 */
public class FinalAParent {

	public void f1(){
		System.out.println("parent f1");
	}
	
	public final void f2(){
		System.out.println("parent f2");
	}
	
	public void f3(){
		System.out.println("parent f3");
	}
	
	private void f4(){
		System.out.println("parent f4");
	}
}
