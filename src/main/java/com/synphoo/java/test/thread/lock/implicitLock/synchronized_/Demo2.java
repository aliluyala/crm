package com.synphoo.java.test.thread.lock.implicitLock.synchronized_;
/**
 * synchronized与wait()、notifyAll()的使用
 * @author wangmingfeng
 *
 */
public class Demo2 {
/*
1、
wait()/notify()：
wait----调用任意对象的 wait() 方法导致线程阻塞，并且该对象上的锁被释放。
notify----而调用任意对象的notify()方法则导致因调用该对象的 wait() 方法而阻塞的线程中随机选择的一个解除阻塞（但要等到获得锁后才真正可执行）。 

2、
有synchronized的地方不一定有wait,notify 
有wait,notify的地方必有synchronized.

3、
wait和notify不是属于线程类，而是每一个对象都具有的方法（事实上，这两个方法是Object类里的），
而且，这两个方法都和对象锁有关，有锁的地方，必有synchronized。 
锁是针对对象的，wait()/notify()的操作是与对象锁相关的，
那么把wait()/notify()设计在Object中也就是合情合理的了。


4、
为什么有wait,notify的地方必有synchronized？ 
synchronized方法中由当前线程占有锁。另一方面，调用wait()notify()方法的对象上的锁必须为当前线程所拥有。
因此，wait()notify()方法调用必须放置在synchronized方法中，
synchronized方法的上锁对象就是调用wait()notify()方法的对象。
若不满足这一条件，则程序虽然仍能编译，但在运行时会出现IllegalMonitorStateException 异常。

5、
可见，用对象锁来管理试图进入synchronized方法的线程， 
另外，由条件判断来管理已经进入同步方法中的线程即当前线程 。

6、
这里还补充两点： 
6.1. 调用wait()方法前的判断最好用while，而不用if；因为while可以实现被唤醒后线程再次作条件判断；而if则只能判断一次 
6.2. 用notifyAll()优先于notify()。 

7、
能调用wait()/notify()的只有当前线程，前提是必须获得了"对象锁"，就是说必须要进入到synchronized方法中。

*/
	
	
	
public static void main(String[] args) {
	
}
	
	//银行转账，同一时刻只有一个人可以转账
	float[] account;
	//同步的转账方法
	public synchronized void transfer(int from,int to,float cash){
		while(account[from]>0){
			try {
				wait();//线程阻塞，对象锁会释放
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		account[from]-=cash;
		account[to]+=cash;
		notifyAll();//会解除因调用wait()方法而阻塞的线程
		//notify()方法则导致因调用该对象的 wait() 方法而阻塞的线程中随机选择的一个解除阻塞（但要等到获得锁后才真正可执行）。 
	}
	
	
	
	
	
	
	
	
}
