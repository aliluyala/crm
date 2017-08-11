/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.date;

import java.util.Date;

import org.joda.time.DateTime;
import com.synphoo.java.utils.DateUtils;

public class DateDemo{
	
	public static void main(String[] args) {
//		DateDemo.oneFun();
//		System.out.println(DateUtils.getNextYearStartTime());
		
//		Date startTime=new Date();
//		System.out.println("开始-"+startTime);
//		System.out.println("结束-"+DateFormatUtil.addDays(startTime, 30));
//		System.out.println(DateFormatUtil.getLeftSeconds(startTime, DateFormatUtil.addDays(startTime, 30)));
		
		/*String str=DateFormatUtil.getCurrentTime("yyyyMMddHHmmss");
		System.out.println(str);*/
		/*Date nowTime=new Date();
		long a=System.currentTimeMillis();
		String b=String.valueOf(a);
		long c=Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10));
		System.out.print("a="+a+" \nb="+b+" \nc="+c+" \n" );

		System.out.println(DateUtils.date2timestamp(nowTime));
		long d=DateUtils.getSecondsBetweenTwoDate(null,nowTime);
		System.out.println("d="+d);
		long e = nowTime.getTime() / 1000;//取商
		System.out.println("e="+e);*/
		fun2();
	}
	
	public static void oneFun(){
		Date createdDate= DateUtils.addDays(DateUtils.getNow(), 0);
		Date targetDate=DateUtils.addDays(DateUtils.getNow(), -7);
		System.out.println("createdDate="+createdDate);
		System.out.println("targetDate="+targetDate);
		if(DateUtils.date2date(createdDate,DateUtils.YYYY_MM_DD).compareTo(targetDate)>=0){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	
	public static void fun2(){
		final DateTime now = DateTime.now();
		
        final int secondOfDay = now.secondOfDay().get();
        System.out.println(secondOfDay);
        final long count = secondOfDay / 60;
        System.out.println("打印count="+count);
	}
}