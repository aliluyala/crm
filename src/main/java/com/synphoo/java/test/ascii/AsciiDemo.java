package com.synphoo.java.test.ascii;
/**
 * 字符与ascii码相关转换
 * @author wangmingfeng
 *
 */
public class AsciiDemo {
	private static int asnum;
	private static char stchar;

	public static void main(String[] args) {
		//字符转ascii码
		System.out.println(getAsc("A"));//结果是：65
		//ascii码转字符 
		System.out.println(backchar(65));//结果是：'A'
	}

	/**
	 * 字符转ASCII码
	 * 
	 * @param st
	 * @return
	 */
	public static int getAsc(String st) {
		/**
		 * getBytes方法：
		 * Encodes this String into a sequence of bytes 
		 * using the platform's default charset, storing the result into a new byte array. 
		 */
		byte[] gc = st.getBytes();
		asnum = (int) gc[0];
		return asnum;
	}

	/**
	 * ASCII码转字符
	 * 
	 * @param backnum
	 * @return
	 */
	public static char backchar(int backnum) {
		stchar = (char) backnum;
		return stchar;
	}
}

