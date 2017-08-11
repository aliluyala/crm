package com.synphoo.java.test.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class Producer implements Runnable {

	private BlockingQueue<Food> queue;
	private ExecutorService exec;

	public Producer(BlockingQueue<Food> queue, ExecutorService exec) {
		this.queue = queue;
		this.exec = exec;
	}

	@Override
	public void run() {
		while (!exec.isShutdown()) {
			Food food = new Food();
			food.setName("");
			try {
				Thread.sleep(4000);
				queue.put(food);//存放
				System.out.println("生产者Produce " + food+" ,线程="+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RejectedExecutionException e) {

			}
		}
	}

}
