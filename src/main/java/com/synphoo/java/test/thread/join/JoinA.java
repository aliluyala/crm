package com.synphoo.java.test.thread.join;
public class JoinA implements Runnable{

	private int i=0;
	@Override
	public void run() {
		while (i<10) {
			i++;
			System.out.println("线程name="+Thread.currentThread().getName()+" ,输出i="+i);
		}
	}
	
} 