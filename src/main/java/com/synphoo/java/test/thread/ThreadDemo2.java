package com.synphoo.java.test.thread;

public class ThreadDemo2 {
	
	//用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新值。volatile很容易被误用，它不能用来保证进行原子性操作。
	public static volatile int count=0;
	
	/**
	 * 变量加1方法
	 */
	public synchronized static void add(){
		try {
			Thread.sleep(1);//延迟1毫秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/*synchronized (ThreadDemo2.class) {
			count++;
		}*/
		count++;
		
	}
	
	/**
	 * main方法
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					ThreadDemo2.add();
				}
			}).start();
		}
		/*main函数作为一个主线程，有可能先运行到 System.out.println("运行结果:Counter.count=" + Counter.count);而还剩几个新线程在跑，这个代码好像说服力不太大
		 * 下面的延迟如果去掉，
		 * 输出的结果就不正确
		 * 
		 * */
		 try {
			Thread.sleep(2000);//延迟2秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("count结果="+count);//每次输出的结果可能不一样
	}
	
}
