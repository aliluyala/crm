package com.synphoo.java.test.designPattern.producerConsumer;

/**
 * 通道Channel的抽象
 * @author wangmingfeng
 *
 */
public interface  Channel<T> {
	
	/**
	 * 从通道取一个“产品”
	 * @return
	 * @throws InterruptedException
	 */
	T take() throws InterruptedException;
	
	/**
	 * 往通道存一个“产品”
	 * @param product
	 * @throws InterruptedException
	 */
	void put(T product) throws InterruptedException;
	
}
