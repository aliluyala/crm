package com.synphoo.java.test.wxpay;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		String ss=CreateNoncestr();
		System.out.println("输出="+ss);
	}
	
	public static String CreateNoncestr() {
        String chars = "abcdABCDefghEFGHIJKL01234ijklMNOPmnopqrstQRSTuvwxUVWXyzYZ56789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
	}
}
