package com.synphoo.java.test.thread.executorFramework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/**
 * 并行计算数组的和----要所有任务都完成之后，再把各任务的结果加到result中。
 * @author wangmingfeng
 *
 */
public class ExecutorServiceDemo2 {
	
	private ExecutorService executorService;
	private int coreCpuNumbers;
	//FutureTask<V>实现了Future<V>和Runable<V>
	private List<Future<Long>> futureList=new ArrayList<Future<Long>>();

	/**
	 * 内部类,实现Callable接口，Callable代表一个有返回值的操作
	 *
	 */
	class InnerClassCalculate implements Callable<Long>{
		
		private int start;
		private int end;
		private int[] numbers;
		
		/**
		 * 构造方法
		 * @param numbers
		 * @param start
		 * @param end
		 */
		public InnerClassCalculate(final int[] numbers,int start,int end){
			this.numbers=numbers;
			this.start=start;
			this.end=end;
		}

		@Override
		public Long call() throws Exception {
			Long sum=0l;
			for (int i = start; i < end; i++) {
				sum+=numbers[i];
			}
			System.out.println("start="+start+" ,end="+end+" ,numbers="+numbers.length+" ,sum="+sum+" ,线程name="+Thread.currentThread().getName());
			if("pool-1-thread-1".equals(Thread.currentThread().getName())){
				//System.out.println("-->延时1s开始");
				Thread.sleep(10000);//延时3s
				//System.out.println("延时1s完成!!!!!!");
			}else if("pool-1-thread-2".equals(Thread.currentThread().getName())){
				//System.out.println("-->延时3s开始");
				Thread.sleep(7000);//延时3s
				//System.out.println("延时3s完成!!!!!!");
			}else if("pool-1-thread-3".equals(Thread.currentThread().getName())){
				//System.out.println("-->延时5s开始");
				Thread.sleep(2000);//延时3s
				//System.out.println("延时5s完成!!!!!!");
			}else if("pool-1-thread-4".equals(Thread.currentThread().getName())){
				//System.out.println("-->延时7s开始");
				Thread.sleep(1000);//延时3s
				//System.out.println("延时7s完成!!!!!!");
			}else{
				System.out.println("其它线程name="+Thread.currentThread().getName());
			}
			System.out.println("计算结果sum="+sum);
			return sum;
		}
	}
	
	/**
	 * 构造方法
	 */
	public ExecutorServiceDemo2(){
		//availableProcessors返回到虚拟机的最大可用的处理器数量
		this.coreCpuNumbers=Runtime.getRuntime().availableProcessors();//jvm可用的处理器数量
//		System.out.println("jvm可用的处理器数量="+this.coreCpuNumbers);
		this.executorService=Executors.newFixedThreadPool(coreCpuNumbers);//创建线程池
	}
	
	/**
	 * 用线程池执行异步操作
	 * @param numbers
	 * @return
	 */
	public Long doSum(final int[] numbers){
		//根据cpu核心个数拆分任务，创建FutureTask并提交至Executor
		for (int i = 0; i < coreCpuNumbers; i++) {
			int increment=numbers.length/coreCpuNumbers+1;//拆分
			int start=i*increment;
			if(start>numbers.length){
				start=numbers.length;
			}
			int end=i*increment+3;
			if(end>numbers.length){
				end=numbers.length;
			}
			InnerClassCalculate cal=new InnerClassCalculate(numbers, start, end);
			FutureTask<Long> futureTask=new FutureTask<Long>(cal);
			futureList.add(futureTask);
			if(!executorService.isShutdown()){
				//System.out.println("submit第"+(i+1)+"个");
				executorService.submit(futureTask);//调用线程池线程处理futureTask----并行计算
			}
		}
		//submit之后再跌倒futureList
		return getResult();
	}
	
	/**
	 * 迭代每一个子任务，获取部分和，相加返回
	 * （从异步操作中获取结果）
	 * @return
	 */
	public Long getResult(){
		Long result=0l;
		//future 异步执行的操作
		int i=1;
		//迭代futureTask的数组
		for (Future<Long> future : futureList) {
			try {
				// 如果计算未完成则阻塞（如果任务还没有完成则当前线程会阻塞）  
				//System.out.println("\n获取第"+i+"个开始......");
				Long subSum=future.get();//等callable里面的call方法执行结束才继续往下走
				result+=subSum;
				System.out.println("获取第"+i+"个完成,result="+result);
				++i;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    return result;			
	}
	
	/**
	 * 关闭线程池
	 */
	public void closeExecutorService(){
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		Date start=new Date();
		System.out.println("start-->线程name="+Thread.currentThread().getName());
		int numbers[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,30,40,50,60,70,80,90,100};
		ExecutorServiceDemo2 obj=new ExecutorServiceDemo2();
		Long sum=obj.doSum(numbers);
		System.out.println("输出sum="+sum);
		obj.closeExecutorService();
		System.out.println("end-->线程name="+Thread.currentThread().getName());
		Date end=new Date();
		System.out.println("时间="+(end.getTime()-start.getTime()));
	}
	
	
}
