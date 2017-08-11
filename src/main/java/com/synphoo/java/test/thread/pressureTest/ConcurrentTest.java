/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.thread.pressureTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import javax.servlet.ServletContext;
/**
 * java模拟并发操作进行压力测试
 * @author wangmingfeng
 *
 */
public class ConcurrentTest {
	/**
	 * 200
	 */
	private static int thread_num = 200;
	/**
	 * 460
	 */
	private static int client_num = 460;
	/**
	 * keywordMap
	 */
	private static Map keywordMap = new HashMap();
	/**
	 * 静态代码块
	 */
	static {
		try {
			//当前类ConcurrentTest.class文件的URI目录。不包括自己
			//输出：file:/D:/workspacewmf/crm/target/classes/com/synfoo/java/test/thread/pressureTest/
			//System.out.println(ConcurrentTest.class.getResource(""));
			
			//
			//当前的classpath的绝对URI路径
			//输出：file:/D:/workspacewmf/crm/target/classes/
			//System.out.println(ConcurrentTest.class.getResource("/"));
		
			///D:/workspacewmf/crm/target/classes/com/synfoo/java/test/thread/pressureTest/
			//System.out.println(ConcurrentTest.class.getResource("").getPath());
			//
			InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("clicks.txt")), "GBK");
			BufferedReader buffer = new BufferedReader(isr);
			String line = "";
			while ((line = buffer.readLine()) != null) {
				keywordMap.put(line.substring(0, line.lastIndexOf(":")), "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getRandomSearchKey(final int no) {
		String ret = "";
		int size = keywordMap.size();
		// int wanna = (int) (Math.random()) * (size - 1);
		ret = (keywordMap.entrySet().toArray())[no].toString();
		ret = ret.substring(0, ret.lastIndexOf("="));
		System.out.println("\t" + ret);
		return ret;
	}

	public static void main(String[] args) {
		int size = keywordMap.size();
		ExecutorService exec = Executors.newCachedThreadPool();
		// 200个线程可以同时访问
		final Semaphore semp = new Semaphore(thread_num);
		// 模拟460个客户端访问
		for (int index = 0; index < client_num; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						// 获取许可
						semp.acquire();
						System.out.println("Thread:" + NO);
						String host = "http://localhost:7070/app/data/ws/rest/appEnums/getAppEnums";
						String para = "method=getQueryResult&pageNum=1&pageSize=5&"
								+ "queryKeyWord="
								+ getRandomSearchKey(NO)
								+ "&questionID=-1&questionIdPath=-1&searchType=1"
								+ "&proLine=&proSeries=&proType=" + NO;
						System.out.println(host + para);
						URL url = new URL(host);// 此处填写供测试的url
						HttpURLConnection connection = (HttpURLConnection) url
								.openConnection();
						// connection.setRequestMethod("POST");
						// connection.setRequestProperty("Proxy-Connection",
						// "Keep-Alive");
						connection.setDoOutput(true);
						connection.setDoInput(true);
						PrintWriter out = new PrintWriter(
								connection.getOutputStream());
						out.print(para);
						out.flush();
						out.close();
						BufferedReader in = new BufferedReader(
								new InputStreamReader(
										connection.getInputStream()));
						String line = "";
						String result = "";
						while ((line = in.readLine()) != null) {
							result += line;
						}
						// System.out.println(result);
						// Thread.sleep((long) (Math.random()) * 1000);
						// 释放
						System.out.println("第：" + NO + " 个");
						semp.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		// 退出线程池
		exec.shutdown();
	}

}