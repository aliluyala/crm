package com.synphoo.java.test.longKeyword;
public class LongA{
	
	public static void main(String[] args) {
		long uid=100090959L;
		System.out.println(""+113 / 10);// 11
		System.out.println(""+(113 / 10) % 8);// 3
		//根据uid计算库编号
		Long dbNum=(uid / 10) % 8 + 1;
		System.out.println("库编号="+dbNum);// 8 8 8 8
		//根据uid计算表编号
		Long tbNum=uid%10;
		System.out.println("表编号="+tbNum);// 6 7 8 9
	}
}