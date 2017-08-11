package com.synphoo.java.test.staticKeyword;

public class StaticH {
	
	public void add(){
		ClassLoader loader=StaticH.class.getClassLoader();
		//加载方式：sun.misc.Launcher$AppClassLoader@14dad5dc ;
		//如果返回的是null，证明加载他的ClassLoader是根加载器bootstrap ;
		System.out.println("加载方式："+loader);
	}
	
	public static void main(String[] args) {
		StaticH obj=new StaticH();
		obj.add();
	}
}
