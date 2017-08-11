package com.synphoo.java.test.finalKeyword;

public class FinalAChild extends FinalAParent{

	@Override
	public void f1() {
		System.out.println("child f1");
	}
	
	public static void main(String[] args) {
		FinalAChild obj=new FinalAChild();
		obj.f1();
		obj.f2();//调用从父类继承过来的final方法
		obj.f3();//调用从父类继承过来的方法
		//obj.f4();//调用失败，无法从父类继承获得 
	}

	
}
