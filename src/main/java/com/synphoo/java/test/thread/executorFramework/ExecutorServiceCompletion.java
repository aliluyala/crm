package com.synphoo.java.test.thread.executorFramework;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.synphoo.java.test.thread.executorFramework.ExecutorServiceDemo2.InnerClassCalculate;

/**
 * 
 * CompletionServie的例子----只要任务每完成一个，就把结果加到result中
 * 在刚在的例子中，getResult()方法的实现过程中，迭代了FutureTask的数组，如果任务还没有完成则当前线程会阻塞，
 * 如果我们希望任意子任务完成后就把其结果加到result中，而不用依次等待每个任务完成，可以使CompletionService。
 * @author wangmingfeng
 *
 */
public class ExecutorServiceCompletion {
	/**
	 * 生产者submit()执行的任务。使用者take()已完成的任务，并按照完成这些任务的顺序处理它们的结果 。
	 * 也就是调用CompletionService的take方法是，会返回按完成顺序放回任务的结果，
	 * CompletionService内部维护了一个阻塞队列BlockingQueue，
	 * 如果没有任务完成，take()方法也会阻塞。
	 */
	private int coreCpuNumbers;
	private ExecutorService executorService;
	private CompletionService<Long> completionService;
	
	/**
	 * 构造函数
	 */
	public ExecutorServiceCompletion(){
		coreCpuNumbers=Runtime.getRuntime().availableProcessors();
		executorService=Executors.newFixedThreadPool(coreCpuNumbers);
		completionService=new ExecutorCompletionService<Long>(executorService);
	}
	
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
			System.out.println("计算结果："+sum);
			return sum;
		}
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
			if(!executorService.isShutdown()){
				//System.out.println("submit第"+(i+1)+"个");
				//注意
				completionService.submit(cal);//调用线程池线程处理futureTask----并行计算
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
		int i=1;
		for (int j = 0; j < coreCpuNumbers; j++) {
			try {
				//System.out.println("\n获取第"+i+"个开始......");
				//注意
				Long subSum=completionService.take().get();
				result+=subSum;
				System.out.println("获取第"+i+"个完成, result="+result);
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
		ExecutorServiceCompletion obj=new ExecutorServiceCompletion();
		Long sum=obj.doSum(numbers);
		System.out.println("\n最终输出sum="+sum);
		obj.closeExecutorService();
		System.out.println("end-->线程name="+Thread.currentThread().getName());
		Date end=new Date();
		System.out.println("时间="+(end.getTime()-start.getTime()));
	}
	
	

}
