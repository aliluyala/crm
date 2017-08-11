package com.synphoo.java.test.thread.create;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * java多线程实现的3种方式之一：ExecutorService Callable Future
 * ExecutorService--线程池接口
 * @author wangmingfeng
 *
 */
@SuppressWarnings("unchecked")
public class Thread3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main程序开始,thread name="+Thread.currentThread().getName());
		Date d1=new Date();
		int taskSize=5;//线程个数
		//创建一个线程池
		ExecutorService pool=Executors.newFixedThreadPool(taskSize);
		//创建多个有返回值的任务
		List<Future> list=new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable callable=new Callable3(i+"");
			//执行任务并获取future对象,ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future
			Future future=pool.submit(callable);
			//System.out.println("打印="+future.get().toString());
			list.add(future);
		}
		//关闭线程池
		pool.shutdown();
		//获取所有并发任务的执行结果
		for (Future future : list) {
			System.out.println("打印="+future.get().toString());//从future对象上获取任务的返回值，并输出
		}
		Date d2=new Date();
		long t=d2.getTime()-d1.getTime();
		System.out.println("main程序结束,时间【"+t+"】毫秒,thread name="+Thread.currentThread().getName());
		
	}
}
