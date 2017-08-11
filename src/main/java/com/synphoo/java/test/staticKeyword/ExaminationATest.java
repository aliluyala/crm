package com.synphoo.java.test.staticKeyword;

public class ExaminationATest {
	/*public static int flag;
	public static char chStr;
	public static double dou;
	public static boolean bool;
	public static float ft;*/
	public static void main(String[] args) {
		ExaminationA obj=ExaminationA.getInstance();
		System.out.println("打印obj.a="+obj.a);
		System.out.println("打印obj.b="+obj.b);
		//系统默认初始化值
		/*
		System.out.println("打印flag="+flag);//0
		System.out.println("打印chStr="+chStr);//空
		System.out.println("打印dou="+dou);//0.0
		System.out.println("打印bool="+bool);//false
		System.out.println("打印ft="+ft);//0.0
		 */	
		}

}
