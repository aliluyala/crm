package com.synphoo.java.test.designPattern.producerConsumer;

import java.util.concurrent.BlockingQueue;
/**
 * 基于阻塞队列的通道实现
 * @author wangmingfeng
 *
 */
public class BlockingQueueChannel<T> implements Channel<T> {

	private final BlockingQueue<T> blockingQueue;//阻塞队列
	
	public  BlockingQueueChannel(BlockingQueue<T> blockingQueue) {
		this.blockingQueue=blockingQueue;
	}
	
	@Override
	public T take() throws InterruptedException {
		return blockingQueue.take();
	}

	@Override
	public void put(T product) throws InterruptedException {
		blockingQueue.put(product);
	}


}
