/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.jvm;

/**
 *  JVM之总内存
 * @author wangmingfeng
 *
 */
public class MainMemory{
	/*
	 * JMM-java memory model--"java内存模型"
	1、
	JVM中（留神：马上讲到的这两个存储区只在JVM内部与物理存储区无关）存在一个主内存（Main Memory），
	Java中所有的变量存储在主内存中，所有实例和实例的字段都在此区域，
	对于所有的线程是共享的（相当于黑板，其他人都可以看到的）。
	每个线程都有自己的工作内存（Working Memory），
	工作内存中保存的是主存中变量的拷贝，（相当于自己笔记本，只能自己看到），
	工作内存由缓存和堆栈组成，其中缓存保存的是主存中的变量的copy，堆栈保存的是线程局部变量。
	线程对所有变量的操作都是在工作内存中进行的，
	线程之间无法直接互相访问工作内存，变量的值得变化的传递需要主存来完成。
	在JMM中通过并发线程修改的变量值，必须通过线程变量同步到主存后，其他线程才能访问到。 
	
	2、
	这可如何是好呢？还好有synchronized和volatile： 
	2.1.	多个线程共有的字段应该用synchronized或volatile来保护. 
	2.2.  synchronized负责线程间的互斥.即同一时候只有一个线程可以执行synchronized中的代码. 
		synchronized还有另外一个方面的作用：在线程进入synchronized块之前，
		会把工作存内存中的所有内容映射到主内存上，然后把工作内存清空再从主存储器上拷贝最新的值。
		而在线程退出synchronized块时，同样会把工作内存中的值映射到主内存，不过此时并不会清空工作内存。
		这样一来就可以强制其按照上面的顺序运行，以保证线程在执行完代码块后，
		工作内存中的值和主内存中的值是一致的，保证了数据的一致性！ 
	2.3.	volatile负责线程中的变量与主存储区同步.但不负责每个线程之间的同步. 
	volatile的含义是：线程在试图读取一个volatile变量时，会从主内存区中读取最新的值。现在很清楚了吧。 
	3、
	a.从主内存中复制数据到工作内存 
	b.执行代码，对数据进行各种操作和计算 
	c.把操作后的变量值重新写回主内存中 
	
	4、
	*/
	public static void main(String[] args) {
		
	}
}