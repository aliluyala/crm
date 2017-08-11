package com.synphoo.java.test.designPattern.producerConsumer.demo2;

/**
 * 生产工作者线程
 * @author wangmingfeng
 *
 */
public class Producer implements Runnable{
	private Product product;
	
	public Producer(Product product) {
		this.product=product;
	}
	
	@Override
	public void run() {
		//多次生产
		for (int i = 0; i < 1; i++) {
			try {
				Thread.sleep((long)Math.random()*1000);//休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//
			product.put();
		}
	}

}
