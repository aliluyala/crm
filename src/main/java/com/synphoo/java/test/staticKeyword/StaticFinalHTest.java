package com.synphoo.java.test.staticKeyword;

public class StaticFinalHTest {
	
	public static void main(String[] args) {
		//System.out.println("打印num="+StaticFinalH.num);//这个时候类StaticFinalH并没有完成初始化
		
		System.out.println("打印num="+StaticFinalH.random);//这个时候类StaticFinalH完成了初始化
	}
}
