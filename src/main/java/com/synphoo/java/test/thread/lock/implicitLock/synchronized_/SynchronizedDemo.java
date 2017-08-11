/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.lock.implicitLock.synchronized_;
/**
 * 
 * @author wangmingfeng
 *
 */
public class SynchronizedDemo{
	/**
	 * 1.synchronized是针对对象的隐式锁使用的，注意是对象！
	 * 
	 * 	synchronized缺点： 
		a. 只有一个condition与锁相关联，这个condition是什么？就是synchronized针对的对象锁。 
		b. 多线程竞争一个锁时，其余未得到锁的线程只能不停的尝试获得锁，而不能中断。
		     这种情况对于大量的竞争线程会造成性能的下降等后果。
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedDemo target=new SynchronizedDemo();
		target.testFun();//target带隐式锁
		
	}
	/**
	 * testFun()互斥访问
	 */
	synchronized void testFun(){
		System.out.println("隐式锁属于该方法所属类的对象");
	}
	
	void testFun2(){
		/**
		 * 用法是: synchronized(this){区块}，它的作用域是this，即是当前对象。
		 * 当然这个括号里可以是任何对象，synchronized对方法和块的含义和用法并不本质不同；
		 */
		synchronized (SynchronizedDemo.class) {
			System.out.println("同步代码块");
		}
		
		//
	}
}