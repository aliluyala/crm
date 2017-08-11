/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.executorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
Executor框架是指java 5中引入的一系列并发库中与executor相关的一些功能类，
其中包括:线程池，Executor，Executors，ExecutorService，CompletionService，Future，Callable等。
==
并发编程的一种编程方式是把任务拆分为一些列的小任务，即Runnable，
然后在提交给一个Executor执行，Executor.execute(Runnalbe) 。
Executor在执行时使用内部的线程池完成操作。 

==
【Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口】
1、创建固定数目线程的线程池；
public static ExecutorService newFixedThreadPool(int nThreads)

2、创建一个可缓存的线程池；
调用execute 将重用以前构造的线程（如果线程可用）。
如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
public static ExecutorService newCachedThreadPool()

3、创建一个单线程化的Executor；
public static ExecutorService newSingleThreadExecutor()

4、创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类；
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)



5、豆豆钱使用的线程池
private static final ExecutorService es = new ThreadPoolExecutor(10, 15, 1000, TimeUnit.SECONDS,
                                                new ArrayBlockingQueue<Runnable>(1000),
                                                new ThreadPoolExecutor.CallerRunsPolicy());
                                                
Creates a new ThreadPoolExecutor with the given initial parameters and default thread factory.
Parameters:
【corePoolSize】 the number of threads to keep in the pool, even if they are idle, 
unless allowCoreThreadTimeOut is set
【maximumPoolSize】 the maximum number of threads to allow in the pool
【keepAliveTime】 when the number of threads is greater than the core, 
this is the maximum time that excess idle threads will wait for new tasks before terminating.
【unit】 the time unit for the keepAliveTime argument
【workQueue】 the queue to use for holding tasks before they are executed. 
This queue will hold only the Runnable tasks submitted by the execute method.
【handler】 the handler to use when execution is blocked because the thread bounds and queue capacities are reached
Throws:
【IllegalArgumentException】 - if one of the following holds:
corePoolSize < 0
keepAliveTime < 0
maximumPoolSize <= 0
maximumPoolSize < corePoolSize
NullPointerException - if workQueue or handler is null



Creates and executes a periodic action that becomes enabled first after the given initial delay, 
and subsequently with the given period; 
that is executions will commence after initialDelay then initialDelay+period, 
then initialDelay + 2 * period, and so on. 
If any execution of the task encounters an exception, 
subsequent executions are suppressed. Otherwise, 
the task will only terminate via cancellation or termination of the executor. 
If any execution of this task takes longer than its period, 
then subsequent executions may start late, but will not concurrently execute.
Parameters:
【command】 the task to execute
【initialDelay】 the time to delay first execution
【period】 the period between successive executions
【unit】 the time unit of the initialDelay and period parameters
Returns:
a ScheduledFuture representing pending completion of the task, and whose get() method will throw an exception upon cancellation
Throws:
【RejectedExecutionException】 - if the task cannot be scheduled for execution
【NullPointerException】 - if command is null
【IllegalArgumentException】 - if period less than or equal to zero

二、ExecutorService与生命周期
ExecutorService扩展了Executor并添加了一些生命周期管理的方法。
一个Executor的生命周期有三种状态，【运行 ，关闭 ，终止】 。
Executor创建时处于运行状态。当调用ExecutorService.shutdown()后，处于关闭状态，isShutdown()方法返回true。
这时，不应该再向Executor中添加任务，所有已添加的任务执行完毕后，Executor处于终止状态，isTerminated()返回true。
如果Executor处于关闭状态，往Executor提交任务会抛出unchecked exception RejectedExecutionException。


三、使用Callable，Future返回结果
Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞。
FutureTask<V>实现了Future<V>和Runable<V>。
Callable代表一个有返回值得操作。




*/