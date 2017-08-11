package com.synphoo.java.test.finalKeyword;

/**
 * final变量定义的时候，可以先声明，而不给初值，这中变量也称为final空白，
 * 无论什么情况，编译器都确保空白final在使用之前必须被初始化。
 * 但是，final空白在final关键字final的使用上提供了更大的灵活性，
 * 为此，一个类中的final数据成员就可以实现依对象而有所不同，
 * 却有保持其恒定不变的特征。
 * @author wangmingfeng
 *
 */
public class FinalBParent {
	//final修饰的变量有三种：静态变量、实例变量和局部变量
	private final String s="final修饰的变量s";//实例变量
	private final int a=100;
	public  final int b=90;
	
	public static final int c=80;//静态变量
	private static final int d=70;
	
	public final int e;//final空白,必须在初始化对象的时候赋初值 
	
	public FinalBParent(int x) {
		e=x;
	}
	
	public void test1(){
		System.out.println(new FinalBParent(50).a);
		System.out.println(FinalBParent.c);
		System.out.println(FinalBParent.d);
	}
	
	public void test2(){
		//局部变量
		final int a;//final空白,在需要的时候才赋值
		final int b=2;
		final int c;
		a=3;
//		a=4;//出错,已经给赋过值了. 
//		b=5;//出错,已经给赋过值了. 
		c=6;
	}
	
	public static void main(String[] args) {
		FinalBParent obj=new FinalBParent(88);
		System.out.println(obj.a);
		System.out.println(obj.b);
		System.out.println(obj.c);
		System.out.println(obj.e);
		System.out.println(obj.s);
		
	}
	

}
