/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.bigDecimal;

import java.math.BigDecimal;

public class demo{
	public static void main(String[] args) {
		String payAmt="2788.69";
		BigDecimal bg = new BigDecimal(payAmt);  
    	BigDecimal bgInt = bg.multiply(new BigDecimal(100));
    	Integer amt = bgInt.intValue();
    	System.out.println("输出="+amt.toString());
	}
}