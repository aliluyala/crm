package com.synphoo.java.test.thread;

public class ThreadDemo1 {
	/*
	 http-bio-8886-exec-19
	 */
	
	public static int count=0;
	
	public static void add(){
		count++;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					ThreadDemo1.add();
				}
			}).start();
		}
		/**
		 * 当主线程先于其它线程执行完，输出的结果会不一致；
		 */
		try {
			Thread.sleep(2000);//延迟1毫秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//main函数作为一个主线程，有可能先运行到 System.out.println("运行结果:Counter.count=" + Counter.count);而还剩几个新线程在跑，这个代码好像说服力不太大
		System.out.println("count结果="+count);//每次输出的结果可能不一样
	}
}
