package com.synphoo.java.test.thread.join;
public class JoinB implements Runnable{

	private int j=0;
	@Override
	public void run() {
		while (j<10) {
			j++;
			System.out.println("线程name="+Thread.currentThread().getName()+" ,==========输出j="+j);
		}
	}
	
} 