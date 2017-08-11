package com.synphoo.java.test.thread.create;

import java.util.Date;
import java.util.concurrent.Callable;
/**
 * 实现Callable接口
 * @author wangmingfeng
 *
 */
public class Callable3 implements  Callable<Object>{

	private String taskNum;
	
	public Callable3(String x){
		this.taskNum=x;
	}

	@Override
	public Object call() throws Exception {
		//返回类型和Callable<>里面的类型一致
		System.out.println(">>>>工作任务"+taskNum+"启动,thread name="+Thread.currentThread().getName());
		Date d1=new Date();
		Thread.sleep(1000);
		Date d2=new Date();
		long t=d2.getTime()-d1.getTime();
		System.out.println(">>>>工作任务"+taskNum+"停止,thread name="+Thread.currentThread().getName());
		return "Object="+taskNum+"任务返回执行结果，任务时间【"+t+"毫秒】";
	}
}
