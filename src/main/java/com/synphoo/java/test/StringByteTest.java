package com.synphoo.java.test;

public class StringByteTest {
	public static void main(String[] args) {
		String str="我是中国人";
		byte[] arr=str.getBytes();
		System.out.println("打印："+arr);
		String str2=new String(arr);
		System.out.println("打印2："+str2);
	}
}
