package com.synphoo.java.utils;

import java.util.Random;

public class RandomUtils {
	
	/**
	 * AB Redirect
	 * @param percentA
	 * @return 	0  -- A
	 * 		 	1  -- B
	 */
	public static int getRandomInt(int percentA){
		int result = 0;
		Random r = new Random(); 
		/**
		 * nextInt返回一个伪随机数，它是取自此随机数生成器序列的、
		 * 在 0（包括）和指定值（不包括）之间均匀分布的值。  
		 */
		if(r.nextInt(100)>= percentA)
			result = 1;
		return result;
	}
	
}
