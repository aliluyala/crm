package com.synphoo.java.test.thread.executorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 创建线程池
 * @author wangmingfeng
 *
 */
public class ExecutorDemo {
	
	public static void main(String[] args) {
		//创建固定数目线程的线程池
		Executor executor=Executors.newFixedThreadPool(10);
		Runnable task=new Runnable(){
			@Override
			public void run() {
				System.out.println("任务1执行,thread name="+Thread.currentThread().getName());
			}
		};
		executor.execute(task);
		
		//创建支持定时及周期性任务执行的线程池
		Executor executor2=Executors.newScheduledThreadPool(10);
		Runnable task2=new Runnable(){
			@Override
			public void run() {
				System.out.println("任务2执行,thread name="+Thread.currentThread().getName());
			}
		};
		ScheduledExecutorService schedule=(ScheduledExecutorService) executor2;
		schedule.scheduleAtFixedRate(task2, 0, 3, TimeUnit.SECONDS);//从第0秒开始，后续每隔3秒执行

	}

}
