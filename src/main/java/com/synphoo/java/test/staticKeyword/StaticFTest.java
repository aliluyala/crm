package com.synphoo.java.test.staticKeyword;

public class StaticFTest {
	public static void doPrint(String str){
		System.out.println("打印="+str);
		System.out.println();
	}
	
	StaticF sf=new StaticF();//调构造函数
	
	static StaticF sf2,sf3;
	
	/**
	 * 静态代码块，类加载后，首先执行
	 */
	static{
		doPrint("static第1处：sf2.i="+sf2.i+", sf3.i="+sf3.i);
		sf2=new StaticF(27);
		doPrint("static第2处：sf2.i="+sf2.i+", sf3.i="+sf3.i);
		sf3=new StaticF(15);
		doPrint("static第3处：sf2.i="+sf2.i+", sf3.i="+sf3.i);
	}
	
	/**
	 * 静态方法和静态变量在
	 * static定义的变量会优先于任何其它非static变量，不论其出现的顺序如何。
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Java初始化，加载顺序：
		 * 
		 * 父类 静态成员变量，	static int parentAge=0;
		 * 父类 静态代码块， 	static{ ...parent static block... }
		 * 子类 静态成员变量，	static int childAge=0;
		 * 子类 静态代码块，	static{ ...child static block... }
		 * 父类 非静态成员变量，int parentAge=1;
		 * 父类 非静态代码块，	{...parent block...}
		 * 父类 构造函数，		parent(){...}
		 * 子类 非静态成员变量，int childAge=1;
		 * 子类 非静态代码块，	 {...child block...}
		 * 子类 构造函数 		 child(){ ... }
		 * 
		 */
		StaticFTest obj=new StaticFTest();
		doPrint("main第1处：obj.sf.i="+obj.sf.i);
		doPrint("main第2处：sf2.i="+sf2.i+", sf3.i="+sf3.i);
		sf2.doAdd();
		doPrint("main第3处：sf2.i="+sf2.i+", sf3.i="+sf3.i);
		doPrint("main第4处：obj.sf.i="+obj.sf.i);
		/**
		  结果为：v1.c=0  v2.c=0
				v1.c=27  v2.c=27
				v1.c=15  v2.c=15
				ct.c=10
				v1.c=10  v2.c=10
				v1.c=11  v2.c=11
				ct.c=11
		 */
	}
}
