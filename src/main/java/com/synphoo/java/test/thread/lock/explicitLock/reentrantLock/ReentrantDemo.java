/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.lock.explicitLock.reentrantLock;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * @author wangmingfeng
 *
 */
public class ReentrantDemo {
	//extends AbstractQueue implements BlockingDeque,Serializable
	/**
	 * explicit lock--显示锁
	 * implicit lock--隐式锁；
	 */
	/*
	
	1、可以认为ReentrantLock是具有和synchronized类似的“性能、功能加强版”同步锁。 
	2、
	synchronized缺点： 
	a. 只有一个condition与锁相关联，这个condition是什么？就是synchronized针对的对象锁。 
	b. 多线程竞争一个锁时，其余未得到锁的线程只能不停的尝试获得锁，而不能中断。这种情况对于大量的竞争线程会造成性能的下降等后果。
	3、
	针对synchronized的一系列缺点，JDK5提供了ReentrantLock，目的是为同步机制进行改善
	4、
	ReentrantLock提供了lockInterruptibly()方法可以优先考虑响应中断，而不是像synchronized那样不响应interrupt()操作。 
	解释一下“响应中断”是什么意思：
	比如A、B两线程去竞争锁，A得到了锁，B等待，但是A有很多事情要处理，所以一直不返回。
	B可能就会等不及了，想中断自己，不再等待这个锁了，转而处理其他事情。在这种情况下，
	synchronized的做法是，B线程中断自己（或者别的线程中断它），我不去响应，继续让B线程等待，你再怎么中断，我全当耳边风。
	而lockInterruptibly()的做法是，B线程中断自己（或者别的线程中断它），ReentrantLock响应这个中断，不再让B等待这个锁的到来。
	5、
	由于ReentrantLock在提供了多样的同步功能（除了可响应中断，还能设置时间限制），
	因此在同步比较激烈的情况下，性能比synchronized大大提高。 
	不过，在同步竞争不激烈的情况下，synchronized还是非常合适的（因为JVM会进行优化，具体不清楚怎么优化的）。
	因此不能说ReentrantLock一定更好，只是两者适合情况不同而已，在同步竞争不激烈时用synchronized，激烈时用ReentrantLock。
	换句话说，ReentrantLock的可伸缩性可并发性要更好一些。
	除非您对 ReentrantLock的某个高级特性有明确的需要，或者有明确的证据（而不是仅仅是怀疑）表明在特定情况下，
	同步已经成为可伸缩性的瓶颈，否则还是应当继续使用 synchronized。
	
	6、
	对于synchronized，JVM会自动释放锁；
	而使用ReentrantLock时，切记要在finally中释放锁，这是与synchronized使用方式很大的一个不同。
	*/
	private final ReentrantLock reentrantLock;
	private final Condition notEmpty;
	private final Condition notFull;
	
	public ReentrantDemo(int capacity,boolean fair){
		reentrantLock=new ReentrantLock(fair);
		notEmpty=reentrantLock.newCondition();//为该ReentrantLock设置了两个Condition 
		notFull=reentrantLock.newCondition();//为该ReentrantLock设置了两个Condition 
	}
	
	public void put(){
		
	}
	
	public void take() throws InterruptedException{
		int count=10;
		final ReentrantLock lock=this.reentrantLock;
		lock.lockInterruptibly();//“响应中断”功能，"上锁"
		
		try {
			while(count==0){
				notEmpty.await();
			}
		} catch (Exception e) {
			notEmpty.signal();
		} finally{
			//使用ReentrantLock时，切记要在finally中手动释放锁
			lock.unlock(); //"解锁"
		}
		
		
	}
	
	
	
	
}