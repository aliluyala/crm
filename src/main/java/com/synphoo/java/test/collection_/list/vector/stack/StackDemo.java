/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.collection_.list.vector.stack;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class StackDemo{
	/*
	队列中元素是先进先出；栈则是后进先出；
	栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
	堆栈只定义了默认构造函数，用来创建一个空栈。 堆栈除了包括由Vector定义的所有方法，也定义了自己的一些方法。
	方法：
	boolean empty() ----测试堆栈是否为空。
	Object peek( ) ----查看堆栈顶部的对象，但不从堆栈中移除它。
	Object pop( ) ----移除堆栈顶部的对象，并作为此函数的值返回该对象。
	Object push(Object element) ----把项压入堆栈顶部。
	int search(Object element) ----返回对象在堆栈中的位置，以 1 为基数。
	*/
	public static void main(String[] args) {
		//后进先出
		Stack<String> stack=new Stack<String>();
		stack.push("合肥");
		stack.push("南京");
		stack.push("上海");
		stack.push("北京");
		System.out.println("输出="+stack.isEmpty()+" ,stack.size="+stack.size());
		String peekElement=stack.peek();
		System.out.println("peekElement输出="+peekElement);
		int search=stack.search("合肥");//4,从上往下基数增大
		System.out.println("search输出="+search);
		String popStr=null;
		while (!stack.isEmpty()&&StringUtils.isNotBlank(popStr=stack.pop())) {
			System.out.println("pop输出="+popStr+" ,stack.size="+stack.size());
		}
	}
}