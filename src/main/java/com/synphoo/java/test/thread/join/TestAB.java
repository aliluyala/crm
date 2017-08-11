package com.synphoo.java.test.thread.join;

public class TestAB {

	public static void main(String[] args) {
		Thread ta=new Thread(new JoinA());
		Thread tb=new Thread(new JoinB());
		//启动线程a
		ta.start();
		try {
			ta.join();//ta执行完，再往下走
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//启动线程b
		tb.start();
		try {
			tb.join();//tb执行完，再往下走
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("线程name="+Thread.currentThread().getName()+",id="+Thread.currentThread().getId());
	}
}
