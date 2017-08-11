package com.synphoo.java.test.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class Consumer implements Runnable {

	private BlockingQueue<Food> queue;
	private ExecutorService exec;

	public Consumer(BlockingQueue<Food> queue, ExecutorService exec) {
		this.queue = queue;
		this.exec = exec;
	}

	@Override
	public void run() {
		while (!exec.isShutdown()) {
			try {
				Thread.sleep(2000);
				Food food = queue.take();//获取
				System.out.println("消费者Consumer " + food+" ,线程="+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RejectedExecutionException e) {

			}
		}
	}

}
