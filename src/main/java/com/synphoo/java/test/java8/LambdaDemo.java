/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.java8;

import java.awt.Button;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo{
	
	public static void main(String[] args) {
		LambdaDemo obj=new LambdaDemo();
//		obj.funAge();
		obj.funColumn();
	}
	
	
	/**
	 * 使用lambda表达式遍历集合
	 */
	public void funAge(){
		java.util.List<String> list=new java.util.ArrayList<String>();
		list.add("V111");
		list.add("V222");
		list.add("X111");
		list.add("X122");
		list.add("Y111");
		list.add("V133");
		list.add("Y122");
		list.add("V144");
		list.add("V155");
		//使用lambda表达式遍历集合
		list.forEach(obj->System.out.println("输出obj="+obj.toString()));
	}
	
	
	
	/**
	 * 使用Lambda语法来代替匿名的内部类
	 */
	public void funBrother(){
		
		/*Button button=new Button("点击查看");
		button.addActionListener(()-> {
			System.out.println("");
		});*/
		
		
		Runnable runnable=()->{
			System.out.println("Running from lambda");
		};
	}
	
	
	public void funColumn(){
		java.util.List<String> list=new java.util.ArrayList<String>();
		list.add("中国V111");
		list.add("美国V222");
		list.add("英国X333");
		list.add("德国X444");
		list.add("法国Y555");
		list.add("俄罗斯V666");
		list.add("澳大利亚Y777");
		list.add("加拿大V122");
		list.add("以色列V125");
		list.forEach(x->System.out.println("原始集合="+x));
		System.out.println();
		//结合Predicate使用和过滤
		Predicate<String> condition1=n->n.contains("1");
		Predicate<String> condition2=n->n.contains("2");
		//
		list.stream().filter(condition1).forEach(x->System.out.println("满足条件1的="+x));
		System.out.println();
		list.stream().filter(x->condition1.test(x)).forEach(x->System.out.println("满足条件1的另一种写法="+x));
		System.out.println();
		list.stream().filter(condition1.and(condition2)).forEach(x->System.out.println("同时满足条件1和2的="+x));
		System.out.println();
		list.stream().filter(condition1.or(condition2)).forEach(x->System.out.println("满足条件1或2的="+x));
		System.out.println();
		//将过滤后的元素重新放入一个list中
		List<String> newList=list.stream().filter(condition1.and(condition2)).collect(Collectors.toList());
		newList.forEach(x->System.out.println("满足条件的新集合="+x));
		System.out.println();
	}
	
	
}