/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.threadLocal;

import java.util.Random;

/**
 * threadLocal
 * @author wangmingfeng
 *
 */
public class ThreadLocalDemo implements Runnable{

	/*
	1、
	This class provides thread-local variables. 好，这个ThreadLocal类提供了线程本地的变量。
	
	2、
	我们已经知道了synchronized的含义是同步，也就是针对的是主存中的变量，只不过多线程执行时为了实现同步就需要每个线程在操作这个变量时
	要完成那三个步骤（对，就是主存与线程工作内存之间完成交互的那三步），我们很自然想到： 
	1. 使用目的：需要有某些变量在多个线程中共享，有共享才会需要同步。 
	2. 执行效率：直观上感觉一下，同步的执行效率肯定不高，事实上也的确是这样，为什么？看看那三步多麻烦。 
	好，现在再来看看ThreadLocal的定义，我们能想到什么？ 
	首先让我们思考一个问题，并不是所有多线程程序都需要共享啊，这个时候还用同步那一套岂不是很多余？
	让每个线程维护自己的变量不就OK了，反正又不需要共享。对，ThreadLocal就是干这个事的。
	另一方面，那不用多说，性能上肯定优越喽。 
	
	3、
	小结一下：对比synchronized和ThreadLocal首先要清楚，两者的使用目的不同，关键点就在是否需要共享变量。
	就是说，ThreadLocal根本不是同步。
	再说啰嗦一点：ThreadLocal和Synchonized都用于解决“多线程并发访问”。
	但是ThreadLocal与synchronized有本质的区别，
	synchronized是利用“锁”的机制，使变量或代码块在某一时该只能被一个线程访问。
	而ThreadLocal为每一个线程都提供了“变量的副本”，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。
	Synchronized用于“线程间的数据共享”；
	而ThreadLocal则用于“线程间的数据隔离”。
	
	ps:
	thread-local static:静态本地线程 
	thread-local memory:线程局部内存
	thread-local storage:局部线程存储
	*/
	
	private final static ThreadLocal threadLocal=new ThreadLocal();//
	public static void main(String[] args) {
		
		ThreadLocalDemo runnableObj=new ThreadLocalDemo();
		Thread t1=new Thread(runnableObj, "线程t1");
		Thread t2=new Thread(runnableObj, "线程t2");
		t1.start();
		t2.start();
		
		
	}
	
	@Override
	public void run() {
		access();
	}
	
	public void access(){
		String currentThread=Thread.currentThread().getName();
		System.out.println("线程name="+currentThread+" is running.");
		Random random=new Random();
		int age=random.nextInt(100);// between zero (inclusive) and bound (exclusive)
		System.out.println("线程name="+currentThread+" set age="+age);
		Student stu=getObj();   //每个线程都独立维护一个Student变量 
		stu.setAge(age);
		System.out.println("线程name="+currentThread+" first read age="+stu.getAge());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程name="+currentThread+" second read age="+stu.getAge());
		
		
	}
	
	public Student getObj(){
		Student obj=(Student) threadLocal.get(); //从ThreadLocal对象中取  
		if(null==obj){
			obj=new Student();
			threadLocal.set(obj);
		}
		
		return obj;
	}
	
	/*public void setToLocal(Student obj){
		threadLocal.set(obj);//放入ThreadLocal对象中
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}