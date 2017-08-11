/**
 * static关键字
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.staticKeyword;

public class StaticDemo{
	static String name="默认文字";
	static final String gender="男";
	
	public static void main(String[] args) {
		//类调用
		System.out.println("类调用name="+StaticDemo.name+",gender="+StaticDemo.gender);
		//类的对象调用
		StaticDemo obj=new StaticDemo();
		System.out.println("类的对象1调用name="+obj.name+",gender="+obj.gender);
		//
		obj.name="对象改变文字";
//		obj.gender="女";//使用final关键字修饰的变量无法修改
		System.out.println("改变后："+StaticDemo.name);
		
		//
		StaticDemo obj2=new StaticDemo();
		System.out.println("类的对象2调用="+obj2.name);
	}
	
}