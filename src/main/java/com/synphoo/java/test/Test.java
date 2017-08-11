package com.synphoo.java.test;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.StringEntity;

import com.synphoo.java.utils.AES;

public class Test {
	public static void main(String[] args) {
		/*//字符串
		String str="never";
		String str2="Serneves";
		//正则表达式
		String regex="^er\\b$";//匹配一个单词边界
		String regex2="^er\\B\\W*$";
		//测试
		Boolean flag=Pattern.matches(regex, str);
		//打印
		System.out.println("输出："+flag);*/
		//秒数
/*		Date nowDate=new Date();
		System.out.println("输出nowDate="+DateFormatUtil.dateToString(nowDate,"yyyy-MM-dd HH:mm:ss"));
		Date endShowDate=DateFormatUtil.addDays(nowDate, 1);
		System.out.println("输出endShowDate="+DateFormatUtil.dateToString(endShowDate,"yyyy-MM-dd HH:mm:ss"));
		Integer expireSeconds=Integer.valueOf(String.valueOf(DateFormatUtil.getSecondsBetweenTwoDate(nowDate, endShowDate)));//86400
		System.out.println("输出相差秒数："+expireSeconds);*/
		
		/*Date nowDate=new Date();
		Date yesterdayDate=DateFormatUtil.addDays(nowDate, -1);
		System.out.println("字符串输出="+DateFormatUtil.getEndFormatStr(yesterdayDate));
		System.out.println("Date输出="+DateFormatUtil.getEndFormatDate(yesterdayDate));*/
        /* try {
        	String mobile="13633339999";
        	String a=DESAndroidHelper.encryptDES(mobile);
        	System.out.println("加密后a="+a);
        	String b=DESAndroidHelper.decryptDES(a);
        	System.out.println("解密后b="+b);
        	 String a="开到乌鲁木齐12345familyGODisAgIRL6789我爱你中国";
        	 String sKey="abcdefghijk123mn";
        	 String a1=AES.Encrypt(a, sKey);
        	 System.out.println("加密后a1="+a1);
        	 String a2=AES.Decrypt(a1, sKey);
        	 System.out.println("解密后a2="+a2);
        	
        	 
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		 String str=null;
    	 if(str.equals("1")){
    		 System.out.println("a");
    	 }else if(str.equals("0")){
    		 System.out.println("b");
    	 }else{
    		 System.out.println("c");
    	 }
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
