package com.synphoo.java.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class Demo {

	public static void main(String[] args) {
		/**
		 * 目前我国公民身份证号码由18位数字组成：前6位为地址码，第7至14位为出生日期码，第15至17位为顺序码，第18位为校验码。
		 * 检验码分别是“0、1、2、……10”共11个数字，当检验码为“10”时，为了保证公民身份证号码18位，所以用“X”表示。
		 */
		//身份证正则表达式(15位) 
//		String regex1= "^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$"; 
		//身份证正则表达式(18位) 
//		String regexw="^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$"; 
//		String str="320281199210260295";
//		System.out.println("str=="+str);
//		System.out.println("结果："+RegExpUtils.checkByRule(CommonEnum.Reg_Ex_IdentityNo.getCode(), str));
		/*String str="\"320123198101284817\"";
		if(StringUtils.isNotBlank(str)){
			System.out.println("="+str.substring(1,str.length()-1));
		}else{
			System.out.println("空");
		}*/
		/*Map<String, String> aMap=new HashMap<String, String>();
		aMap.put("name", "石祥刚");
		aMap.put("loginType", "1");
		aMap.put("username2", "320123198101284817");
		aMap.put("password", "347700");
		aMap.put("identitycard", "320123198101284817");
		System.out.println(aMap.toString());
		String authParams=GsonUtils.toJson(aMap);
		System.out.println("输出："+authParams);*/
		/*String username=(String) aMap.get("username");
		String identitycard=(String) aMap.get("identitycard");
		String password=(String) aMap.get("password");
		System.out.println("输出："+username);
		System.out.println("输出："+identitycard);
		System.out.println("输出："+password);
		String now=DateFormatUtil.dateToString(new Date());
		System.out.println(now);*/
//		String au="{\"name\":\"赵磊\",\"password\":\"111111\",\"identitycard\":\"13018219790307001X\",\"vercode\":\"6275\"}";
//		Map<String, Object> authParamsMap=GsonUtils.toMap(au);
//		System.out.println(authParamsMap.get("name"));
//		String str="320281199210260295";
//		System.out.println(RegExpUtils.checkByRule(CommonEnum.Reg_Ex_IdentityNo.getCode(), str));
		
		/*String val="\"\"";
		System.out.println("输出："+val);
		if(StringUtils.isNotBlank(val)&&val.contains("\"")){
			System.out.println("截断："+val.substring(1, val.length()-1));
		}*/
//		String str="验证码不对";
		/*System.out.println(str.toUpperCase());
		String data="登录失败,操作失败:进行身份校验时出错:个人登录密码不正确,请重新输入!";
		int startIndex=data.trim().indexOf("登录失败,");
		System.out.println(startIndex);
		System.out.println(data.substring(startIndex+5));*/
		//System.out.println(StringHelper.getDealedStatusDescOfFengNiao(InvokeFengNiaoOperationName.Gjj_Login,str));
//		String id="652123197910252528";
//		Boolean flag=IDCardUtil.isIDCard(id);
//		System.out.println(flag);
		/*String[] arr={"a","b","c"};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i+"输出："+(i+1));
		}*/
		/*int size=1;
		for (int i = 0; i < 5; i++) {
			System.out.println("输出:"+((size++)));
		}*/
		/*String ss="bbs/topic/262/show_img_2.jpg";
		String[] arr=ss.split("/");
		Integer idx=ss.lastIndexOf("/");*/
		/*for (int i = 0; i < arr.length; i++) {
			System.out.println("输出"+arr[i]);
		}*/
		//System.out.println(ss.substring(0, idx));
//		long authHours=DateFormatUtil.getHoursBetweenTwoDate(DateFormatUtil.string2date("2016-12-30 08:09:30"), DateFormatUtil.string2date("2017-01-01 11:24:01"));
		//System.out.println(new Date());//当前时间 Thu Jan 05 18:12:38 CST 2017
		//System.out.println(DateFormatUtil.addDays(new Date(), 1));//下一个月 Sun Feb 05 00:00:00 CST 2017
//		System.out.println(authHours);
//		System.out.println(7/2);//取商
//		System.out.println(7%2);//取余
/*		Object obj="1";
		System.out.println(String.valueOf(obj).equals("1"));*/
		/*CacheManager cacheManager=new CacheManagerImpl();
		Object obj2=null;
		obj2=cacheManager.get("sss");
		if(null!=obj2&&String.valueOf(obj2).equals(CommonEnum.Fixed_Value_1.getCode())){
			cacheManager.delete("sss");
		}*/
		/*
		Date nowDate=new Date();
		Date endShowDate=DateFormatUtil.addDays(nowDate, Integer.valueOf(CommonEnum.Fixed_Value_1.getCode()));
		System.out.println(nowDate);
		System.out.println(endShowDate);
		Integer expireSeconds=Integer.valueOf(String.valueOf(DateFormatUtil.getSecondsBetweenTwoDate(nowDate, endShowDate)));
		System.out.println(expireSeconds);*/
		/*java.util.List<Object> users=null;
		System.out.println(CollectionUtils.isNotEmpty(users));
		if(CollectionUtils.isNotEmpty(users)){
			for (Object object : users) {
				System.out.println("进入");
			}
		}*/
		
		/*String str1="hello";
		String str2="he"+new String("llo");
		System.out.println(str1==str2);//false
		
		int i=Integer.MAX_VALUE;
		int j=i+1;
		System.out.println(i);//2147483647
		System.out.println(j);//-2147483648
		boolean k=j<i;
		System.out.println(k);//true
*/		
		//Thread.getAllStackTraces().keySet().forEach(thread -> System.out.println(thread.getName()+"->"+thread.isDaemon()+" "+thread.getPriority()));
		
		/*Date nowDate=DateFormatUtil.string2date("2017-07-20 15:45:00",DateFormatUtil.YYYY_MM_DD_HH_MM_SS);
		//Date endShowDate=DateFormatUtil.addDays(nowDate, Integer.valueOf(CommonEnum.Fixed_Value_15.getCode()));
		Date endShowDate=DateFormatUtil.addMonth(nowDate, 1);
		System.out.println(nowDate);
		System.out.println(endShowDate);*/
		Integer num=new Integer(1);
		System.out.println(num.toString());
		
		
		
		
		
		
		
		
	}
}
