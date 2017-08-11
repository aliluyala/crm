package com.synphoo.java.test.staticKeyword;

public class ExaminationA {
	//成员变量
	public static ExaminationA instance=new ExaminationA();//成员变量顺序不一致，结果可能不一致。
	public static int a;
	public static int b=0;
	//构造函数
	private ExaminationA(){
		super();
		a++;
		b++;
		
	}
	//成员方法
	public static ExaminationA getInstance(){
		return instance;
	}
}
