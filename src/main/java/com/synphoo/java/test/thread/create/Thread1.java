package com.synphoo.java.test.thread.create;
/**
 * java多线程实现的3种方式之一：继承Thread类
 * @author wangmingfeng
 *
 */
public class Thread1 extends Thread{

	@Override
	public void run() {
		System.out.println("do Thread1 run method");
	}
	
	public static void main(String[] args) {
		Thread t=new Thread1();
		t.start();
	}
	
}