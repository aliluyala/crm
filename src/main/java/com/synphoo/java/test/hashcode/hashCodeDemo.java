/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.hashcode;
public class hashCodeDemo{
	public static void main(String[] args) {
		String msg="hello,world!";
		System.out.println(msg.hashCode());//1842822377
		
		String msg2="hello,world!";
		System.out.println(msg.hashCode());//1842822377,msg和msg2的hashcode值大小相等

	}
}