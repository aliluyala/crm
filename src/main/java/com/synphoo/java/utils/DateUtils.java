package com.synphoo.java.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: DateFormatUtil
 * @Description:app接口与Date相关的公用类
 * @author dk
 * @date 2014年12月5日 下午2:29:31
 * 
 */
public class DateUtils {
    private static SimpleDateFormat sdf                 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String      ENG_DATE_FROMAT     = "EEE, d MMM yyyy HH:mm:ss z";
    public static final String      YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String      YYYYMMDDHHMMSS      = "yyyyMMddHHmmss";
    public static final String      YYYY_MM_DD_HH_MM    = "yyyy-MM-dd HH:mm";
    public static final String      MM_DD_HH_MM         = "MM-dd HH:mm";
    public static final String      MM_DD_HH_MM_CN      = "MM月dd日 HH:mm";
    public static final String      YYYY_MM_DD          = "yyyy-MM-dd";
    public static final String      YYYY                = "yyyy";
    public static final String      MM                  = "MM";
    public static final String      DD                  = "dd";
    
    
    // TODO **********2016.09.08Ljx添加该3个属性for魔豆**************
    public static final String YYYY_MM = "yyyy-MM"; 
    public static final String MM_DD = "MM-dd"; 
    public static final String HH_MM = "HH:mm"; 
    // TODO **********2016.09.08Ljx添加该3个属性for魔豆**************

    /**
     * @Title: dateToString
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param date
     * @param @param formate
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String dateToString(Date date, String formate) {
        if (date == null) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(formate);
        return dateFormat.format(date);
    }

    public static String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return dateFormat.format(date);
    }

    public static String datetime2String(Date date) {
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

    /**
     * 得到本周周一
     * 
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        c.add(Calendar.DATE, -dayofweek + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(c.getTime());
    }

    /**
     * 得到本周周日
     * 
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek() {
        Calendar c = Calendar.getInstance();
        int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        c.add(Calendar.DATE, -dayofweek + 7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(c.getTime());
    }

    /**
     * @描述 —— 格式化日期对象
     */
    public static Date date2date(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String str = sdf.format(date);
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * @描述 —— sql时间对象转换成字符串
     */
    public static String timestamp2string(Timestamp timestamp, String formatStr) {
        String strDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        strDate = sdf.format(timestamp);
        return strDate;
    }

    /**
     * @描述 —— 字符串转换成时间对象
     */
    public static Date string2date(String dateString, String formatStr) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        Date formateDate = null;
        DateFormat format = new SimpleDateFormat(formatStr);
        try {
            formateDate = format.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
        return formateDate;
    }

    /**
     * @描述 —— Date类型转换为Timestamp类型
     */
    public static Timestamp date2timestamp(Date date) {
        if (date == null)
            return null;
        return new Timestamp(date.getTime());
    }

    /**
     * @描述 —— 获得当前年份
     */
    public static String getNowYear() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
        return sdf.format(new Date());
    }

    /**
     * @描述 —— 获得当前月份
     */
    public static String getNowMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(MM);
        return sdf.format(new Date());
    }

    /**
     * @描述 —— 获得当前日期中的日
     */
    public static String getNowDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(DD);
        return sdf.format(new Date());
    }

    /**
     * @描述 —— 指定时间距离当前时间的中文信息
     */
    public static String getLnow(long time) {
        Calendar cal = Calendar.getInstance();
        long timel = cal.getTimeInMillis() - time;
        if (timel / 1000 < 60) {
            return "1分钟以内";
        } else if (timel / 1000 / 60 < 60) {
            return timel / 1000 / 60 + "分钟前";
        } else if (timel / 1000 / 60 / 60 < 24) {
            return timel / 1000 / 60 / 60 + "小时前";
        } else {
            return timel / 1000 / 60 / 60 / 24 + "天前";
        }
    }

    /**
     * 当前时间一星期前的时间
     * 
     * @return
     */
    public static final String getLastWeek() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -7);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当前日期的指定格式的字符串
     *
     * @param format
     *            指定的日期时间格式，若为null或""则使用指定的格式"yyyy-MM-dd HH:mm"
     * @return
     */
    public static String getCurrentTime(String format) {
        if (format == null || format.trim().equals("")) {
            sdf.applyPattern(YYYY_MM_DD_HH_MM_SS);
        } else {
            sdf.applyPattern(format);
        }
        return sdf.format(new Date());
    }

    public static String getCurrentDate() {
        return dateToString(new Date(), YYYY_MM_DD_HH_MM_SS);
    }

    public static Boolean checkIsTime(String time) {
        DateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            format.parse(time);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 比较日期先后
     * 
     * @param date
     * @param interval
     * @return boolean
     */
    public static boolean isExpired(Date date, int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, interval);
        Calendar now = Calendar.getInstance();
        return calendar.before(now);
    }

    public static Date string2date(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return string2date(value, "yyyy-MM-dd");
    }

    public static String string2string(String value, String from, String to) {
        return dateToString(string2date(value, from), to);
    }

    /**
     * 加1天
     * 
     * @param value
     * @return Date
     */
    public static Date addOneDay(String value) {
        return addDays(value, 1);
    }

    public static Date addOneDay(Date value) {
        return addDays(value, 1);
    }

    /**
     * 当前日期，加num天
     * @param value
     * @param num
     * @return
     */
    public static Date addDays(String value, int num) {
        return addDays(string2date(value), num);
    }

    public static Date addDays(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.DATE, num);
        return c.getTime();
    }

    public static Date addMonth(Date value, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(value);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    /**
     * 获取2个时间点之间的天数
     * @param start
     * @param end
     * @return
     */
    public static int getBetweenTwoDays(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        long longs = (end.getTime() - start.getTime());
        int days = (int) (longs / (24 * 60 * 60 * 1000));
        return days;
    }
    
    /**
     * 获取2个时间点之间的小时数
     * 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     * @param start
     * @param end
     * @return
     */
    public static long getHoursBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if(start.compareTo(end)>0){
        	return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        long minutesInMilli = secondsInMilli * 60;//分钟
        long hoursInMilli = minutesInMilli * 60;//小时
        //long daysInMilli = hoursInMilli * 24;//天数
        long hours = differ / hoursInMilli;//取商
        //different=different % hoursInMilli;//取余
        //System.out.println(hours+"--"+different);
        return hours;
    }
    
    /**
     * 获取2个时间点之间的秒数
     * 前提是：end（2017-01-13 11:24:01）大于start（2016-11-26 09:58:35）
     * @param start
     * @param end
     * @return
     */
    public static long getSecondsBetweenTwoDate(Date start, Date end) {
        if (start == null) {
            return 0;
        }
        if (end == null) {
            end = new Date();
        }
        if(start.compareTo(end)>0){
        	return 0;
        }
        long differ = (end.getTime() - start.getTime());//相差毫秒数
        long secondsInMilli = 1000;//毫秒
        //long minutesInMilli = secondsInMilli * 60;//分钟
        //long hoursInMilli = minutesInMilli * 60;//小时
        //long daysInMilli = hoursInMilli * 24;//天数
        long hours = differ / secondsInMilli;//取商
        //different=different % hoursInMilli;//取余
        //System.out.println(hours+"--"+different);
        return hours;
    }

    public static int getBetweenTwoDays(String start, String end) {
        return getBetweenTwoDays(string2date(start), string2date(end));
    }

    /**
     * 获取当前日期(只精确到天)
     */
    public static Date getNow() {
        return date2date(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取明天日期（精确到天）
     */
    public static Date getTomorrow() {
        return addOneDay(getNow());
    }

    public static String now() {
        return datetime2String(getNow());
    }

    public static Date getLastMonth() {
        return addMonth(getNow(), -1);
    }

    public static Date getNextMonth() {
        return addMonth(getNow(), 1);
    }

    public static Integer getAge(String identityNo) {
        String birthDay = CommonUtils.getIdentityBirth(identityNo);
        int days = getBetweenTwoDays(string2date(birthDay, "yyyy-MM-dd"), new Date());
        return days / 365;
    }
    
     /**
      * 根据年,月 得到指定月的第一天
      * @param year
      * @param month
      * @return
      */
    public static String getFirstDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(Calendar.YEAR, year);     
        cal.set(Calendar.MONTH, month-1);  
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));  
       return   new   SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());  
    } 
     /**
      * 根据年,月 得到指定月的最后一天
      * @param year
      * @param month
      * @return
      */
	 public static String getLastDayOfMonth(int year, int month) {     
         Calendar cal = Calendar.getInstance();     
         cal.set(Calendar.YEAR, year);     
         cal.set(Calendar.MONTH, month-1);     
         cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
        return  new   SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());  
     }   
	 
	 /**
	  * 获取字符串时间，其格式为：2017-01-01 00:00:00，返回String
	  * @param date
	  * @return
	  */
	 public static String getStartFormatStr(Date date) {
        if (null==date) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return dateFormat.format(date)+" 00:00:00";
	 }
	 
	 /**
	  * 获取字符串时间，其格式为：Wed Jan 11 00:00:00 CST 2017，返回Date
	  * @param date
	  * @return
	  */
	 public static Date getStartFormatDate(Date date) {
        if (null==date) {
            return date;
        }
        return DateUtils.string2date(DateUtils.getStartFormatStr(date),DateUtils.YYYY_MM_DD_HH_MM_SS);
	 }
	 
	 
	 /**
	  * 获取字符串时间，其格式为：2017-01-01 23:59:59，返回String
	  * @param date
	  * @return
	  */
	 public static String getEndFormatStr(Date date) {
        if (null==date) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return dateFormat.format(date)+" 23:59:59";
	 }
	 
	 /**
	  * 获取字符串时间，其格式为：Wed Jan 11 23:59:59 CST 2017，返回Date
	  * @param date
	  * @return
	  */
	 public static Date getEndFormatDate(Date date) {
		 if (null==date) {
	            return date;
	     }
	     return DateUtils.string2date(DateUtils.getEndFormatStr(date),DateUtils.YYYY_MM_DD_HH_MM_SS);
	 }
	 
	    /**
	     * 获取end-start之间相差的毫秒数，时间格式自定义,返回的时间形式自定义
	     * @param start 起始时间
	     * @param end 结束时间
	     * @param dateFormat 时间格式
	     * @param timeUnit 默认BbsCommonEnum.days；BbsCommonEnum.hours；BbsCommonEnum.minutes;BbsCommonEnum.seconds;BbsCommonEnum.milliseconds;
	     * @return
	     */
	    public static int getDifferBetweenTwoDays(String start, String end,String dateFormat,String timeUnit) {
	        return getDifferBetweenTwoDate(string2date(start,dateFormat), string2date(end,dateFormat),timeUnit);
	    }
	    
	    /**
	     * 获取end-start之间相差的时间
	     * @param start
	     * @param end
	     * @param timeUnit
	     * @return
	     */
	    public static int getDifferBetweenTwoDate(Date start, Date end,String timeUnit) {
	        if (start == null) {
	            return 0;
	        }
	        if (end == null) {
	            end = new Date();
	        }
	        if(StringUtils.isBlank(timeUnit)){
	        	timeUnit=CommonEnum.days.getCode();
	        }
	        long longs = (end.getTime() - start.getTime());
	        long differTime=0;
	        if(CommonEnum.days.getCode().equals(timeUnit)){
	        	differTime = longs / (24 * 60 * 60 * 1000);//相差的天数
	        }else if(CommonEnum.hours.getCode().equals(timeUnit)){
	        	differTime = longs /(60 * 60 * 1000);//相差的小时数
	        }else if(CommonEnum.minutes.getCode().equals(timeUnit)){
	        	differTime = longs /(60 * 1000);//相差的分钟数
	        }else if(CommonEnum.seconds.getCode().equals(timeUnit)){
	        	differTime = longs /1000;//相差的秒数
	        }else{
	        	//milliseconds
	        	differTime=(int)longs;//相差的毫秒数
	        }
	        return Integer.valueOf(String.valueOf(differTime));
	    }
	    
	    /**
	     * 获取两个时间之间的秒数差，默认返回当前时间点和明天零点之间的剩余秒数差
	     * @param nowDate
	     * @param endShowDate
	     * @return
	     */
	    public static int getLeftSeconds(Date nowDate,Date endShowDate){
	    	if(null==nowDate||null==endShowDate){
	    		nowDate=new Date();
				endShowDate=DateUtils.getStartFormatDate(DateUtils.addDays(nowDate, Integer.valueOf(CommonEnum.Fixed_Value_1.getCode())));
	    	}
	    	if(endShowDate.compareTo(nowDate)<0){
	    		return -1;
	    	}
	    	//System.out.println(nowDate);
			//System.out.println(endShowDate);
			Integer expireSeconds=Integer.valueOf(String.valueOf(DateUtils.getSecondsBetweenTwoDate(nowDate, endShowDate)));
			return expireSeconds;
	    }
	    
	    /**
	     * 获取下一年的开始时间，如当前是2017年，返回“2018-01-01 00:00:00”
	     * @return
	     */
	    public static String getNextYearStartTime() {
	        SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
	        String year=sdf.format(new Date());
	        int afterYear=Integer.valueOf(year)+1;//加1年
	        return String.valueOf(afterYear)+"-01-01 00:00:00";
	    }
 

}
