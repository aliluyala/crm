package com.synphoo.java.test.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Food> queue = new ArrayBlockingQueue<Food>(5);//阻塞队列
		ExecutorService exec = Executors.newFixedThreadPool(3);//线程池
		//生产者
		Producer p1 = new Producer(queue, exec);
		Producer p2 = new Producer(queue, exec);
		//消费者
		Consumer c1 = new Consumer(queue, exec);
		//生产
		exec.execute(p1);
		exec.execute(p2);
		//消费
		exec.execute(c1);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ignored) {
			
		}
		exec.shutdown();
		System.out.println("关闭...");
	}

}
