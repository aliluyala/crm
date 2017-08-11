package com.synphoo.java.test.thread.create;
/**
 * java多线程实现的3种方式之一：实现Runnable接口
 * @author wangmingfeng
 *
 */
public class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("do Thread2 run method");
	}
	
	public static void main(String[] args) {
		//当传入一个Runnable target参数给Thread后，Thread的run()方法就会调用target.run()方法
		Thread2 thread2=new Thread2();
		Thread t=new Thread(thread2);
		t.start();
	}

}
