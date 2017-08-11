/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.runtime;

public class RuntimeDemo{
	
	public static void main(String[] args) {
		System.out.println("jvm可用的处理器数量="+Runtime.getRuntime().availableProcessors());
		//jvm可用的处理器数量=4
	}
}