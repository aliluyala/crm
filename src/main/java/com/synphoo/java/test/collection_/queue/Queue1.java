/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.collection_.queue;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.lang3.StringUtils;

/**
 * java.util.Queue接口
 * Queue接口扩展了java.util.Collection接口
 * @author wangmingfeng
 *
 */
public class Queue1{
/*
	队列是一种特殊的线性表，是运算受到限制的一种线性表，只允许在表的一端进行插入，而在另一端进行删除元素的线性表。队尾（rear）是允许插入的一端。队头（front）是允许删除的一端。空队列是不含元素的空表。
 根据这样的操作。队列特点是先进先出~
	在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。该接口扩展了java.util.Collection接口。
Queue使用时要尽量避免Collection的add()和remove()方法，
而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，
add()和remove()方法在失败的时候会抛出异常。 
如果要使用前端而不移出该元素，使用element()或者peek()方法。
值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
*/
	/*
	在Java多线程应用中，队列的使用率很高，多数生产消费模型的首选数据结构就是队列。
	Java提供的线程安全的Queue可以分为阻塞队列和非阻塞队列，
	其中阻塞队列的典型例子是BlockingQueue，非阻塞队列的典型例子是ConcurrentLinkedQueue，
	在实际应用中要根据实际需要选用阻塞队列或者非阻塞队列。
	*/
	
	public static void main(String[] args) {
		Queue<String> queue=new LinkedList<String>();
		//offer方法,添加，有返回值
		boolean result=queue.offer("合肥");
		queue.offer("南京");
		queue.offer("无锡");
		queue.offer("苏州");
		queue.offer("上海");
		System.out.println("queue.size="+queue.size());
		String target=null;
		//poll方法,移除，有返回值
		while (StringUtils.isNotBlank(target=queue.poll())) {
			System.out.println("输出target="+target+" ,queue.size="+queue.size());
		}
		
	}
	
	
}