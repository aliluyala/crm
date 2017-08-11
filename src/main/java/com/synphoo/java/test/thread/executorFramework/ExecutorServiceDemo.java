package com.synphoo.java.test.thread.executorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ExecutorServiceDemo obj=new ExecutorServiceDemo();
//		obj.doExecutorServiceFun1();
		obj.doExecutorServiceFun2();
	}
	
	public void doExecutorServiceFun1(){
		//
		//创建固定数目线程的线程池
	    Executor executor=Executors.newFixedThreadPool(10);
	    ExecutorService executorService=(ExecutorService) executor;
	    Runnable task1=new Runnable() {
			@Override
			public void run() {
				System.out.println("任务1执行,线程name="+Thread.currentThread().getName()+" ,id="+Thread.currentThread().getId()+" ,priority="+Thread.currentThread().getPriority());
			}
		};
	    
	    while (!executorService.isShutdown()) {
	    	executorService.execute(task1);
		}
	    
	    executorService.shutdown();
	}
	
	public void doExecutorServiceFun2(){
		Callable<Integer> callable=new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("任务inside callable");
				Thread.sleep(3000);
				return new Integer(8);
			}
			
		};
		FutureTask<Integer> futureTask=new FutureTask<Integer>(callable);//FutureTask<V>实现了Future<V>接口和Runable<V>接口
		Thread newThread=new Thread(futureTask);
		newThread.start();
		//
		try {
			/**
			 * Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞。
			 */
			System.out.println("blocking here");
			Integer result=futureTask.get();//获取任务执行的返回结果
			System.out.println("result值="+result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
