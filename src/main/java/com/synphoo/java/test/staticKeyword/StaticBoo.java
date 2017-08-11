package com.synphoo.java.test.staticKeyword;

import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class StaticBoo {

	/**
	 * 声明一个类的静态区域，静态区域的代码执行完毕，方完成类的初始化
	 */
	static{
		System.out.println("打印静态区域内容");
		System.out.println("打印age="+StaticBoo.age);
		StaticBoo a=new StaticBoo();
		System.out.println("打印age 2="+a.age);
		System.out.println("打印count="+a.count);
	}
	static void add(){
		/*static{
			System.out.println("输出");
		} 非法 */
		System.out.println("输出add方法");
		//在静态方法里只能直接调用同类中其他的静态成员（包括变量和方法），而不能直接访问类中的非静态成员
		int c=1;
		int result=c+age;
//		int result2=c+count;
//		this.
//		super.
	}
	final String country="china";//常量
	static int age=0;//属于类的变量
	int count=1;//属于类的实例对象
	void minus(){
		//static int good;//非法    不能把任何方法体内的变量声明为静态
		System.out.println("输出minus方法");
	}
	public static void main(String[] args) {
		StaticBoo boo=new StaticBoo();
		
	}
}
