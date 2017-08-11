/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * semaphore信号量
 * @author wangmingfeng
 *
 */
public class Demo{
/**
 * Semaphore是一种基于计数的信号量。
 * 它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做完自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞。
 * Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池。
 * 我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。
 * 
 * 同ReentrantLock一样，Semaphore内部也是依靠一个继承自AbstractQueuedSynchronizer的Sync抽象类型的类成员变量sync来实现主要功能的
 * 
 * 同时，Semaphore也是由公平性和非公平性两种实现模式，对应Sync的两个实现类FairSync和NonfairSync
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @param args
 */
	
	public static void main(String[] args) {
		
	}
	
	public void init(){
		int permits=5;//阈值 阀值
		boolean fair=false;
		Semaphore semaphore=new Semaphore(permits);
//		Semaphore semaphore2=new Semaphore(permits, fair);
		
		try {
			semaphore.acquire();//申请许可
			//业务逻辑
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			//释放许可
			semaphore.release();
		}
		
	}
	
}