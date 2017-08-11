/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.exception;

public class ReturnDemo{
	
	public static void main(String[] args) {
		int result=ReturnDemo.test();
	}
	
	static int test(){
		try {
			int i=1;
			int j=1;
			i++;
			j--;
			int result=i/j;
			return result;
		} catch (Exception e) {
			System.out.println("do catch block");
			return -1;
		}finally{
			System.out.println("do finally block");
			return -2;
		}
	}
}