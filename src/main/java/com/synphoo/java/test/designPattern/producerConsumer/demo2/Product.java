/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.designPattern.producerConsumer.demo2;
public class Product{
	private int number=2;
	
	/**
	 * 存入
	 */
	public synchronized void put(){
		//只要number不为0就休眠，为0，则存入
		while (number!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number++;
		System.out.println("生产者【"+Thread.currentThread().getName()+"】存入后："+number);
		notify();
	}
	
	/**
	 * 取出
	 */
	public synchronized void take(){
		//只要number为0就休眠，不为0，则取出
		while (number==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		number--;
		System.out.println("消费者【"+Thread.currentThread().getName()+"】取出后:"+number+"=================");
		notify();
	}
}