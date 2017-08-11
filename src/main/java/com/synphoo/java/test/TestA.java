package com.synphoo.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.ddcash.server.app.framework.utils.DateFormatUtil;
import com.synphoo.java.utils.DateUtils;
import com.synphoo.java.utils.ThreadUtils;

public class TestA {
	//private static final Logger  logger = LoggerFactory.getLogger(TestA.class);
	public static void main(String[] args) {
		//doSyncFun();
		//timeTestFun();
		//randomFun();
		//forFun();
		//doList();
		//doStringArr();
		//doIntegerLong();
		String content="好吗如果天地中国人美国，韩国普陀山贷款。寒山石静安？是";//27
		System.out.println(content.indexOf("贷款"));
		System.out.println("内容长度="+content.length());
		String searchName="贷款";
		System.out.println("关键字长度="+searchName.length());
//		System.out.println(contentTemp.length());
		System.out.println("输出="+getDealedSearchRecommend(content, searchName));
	}
	
	private static void doSyncFun(){
		ThreadUtils.async(new Runnable() {
	        @Override
	        public void run() {
	            try {
	            	System.out.println("测试"+DateUtils.getCurrentDate());
	            } catch (Exception e) {
	                //logger.error("decision fail", e);
	            }
	        }
	    });
	}
	
	private static void randomFun(){
		Random random=new Random();
		Integer flag=random.nextInt(100);
		System.out.println("0-100范围内的随机数"+flag);
	}
	
	private static void timeTestFun(){
		System.out.println("输出："+DateFormatUtil.getLeftSeconds(null, null));
	}
	
	private static void forFun(){
		for (int i = 1; i < 5; i++) {
			System.out.println("select"+i);
		}
	}
	
	private static void doList(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		List<Integer> sublist=list.subList(0, 3);
		System.out.println(sublist);
		List<Integer> sublist2=list.subList(3, 6);
		System.out.println(sublist2);
	}
	
	private static void doStringArr(){
		String[] arr={"大伙好","早餐","糯米"};
		List<String> list=new ArrayList<String>();
		CollectionUtils.addAll(list, arr);
		System.out.println(list);
		list.add("过完年");
		System.out.println(list);
		String str="  糯米   ";
		System.out.println(list.contains(str.trim()));
	}
	
	private static void doIntegerLong(){
		Integer a=1888888888;
		//System.out.println("输出a="+a+"");
		Long b=Long.valueOf(a+"");
		//System.out.println("输出b="+b);
		int sum=Integer.parseInt(b.toString())+1;
		System.out.println(sum);
	}
	
	public static String getDealedSearchRecommend(String content,String searchName){
		String rtn="";
		if(StringUtils.isNotBlank(content)&&StringUtils.isNotBlank(searchName)){
			int contentLen=content.length();//帖子内容长度
			int targetLen=searchName.length();//关键字长度<=10
			if(contentLen>15){
				int idx=content.indexOf(searchName);//以关键字第一次出现的地方为命中点
				if(idx==0){
					//关键字在开头
					rtn=content.substring(0,15);//15个字
				}else if((idx+targetLen)==contentLen){
					//关键字在最后
					rtn=content.substring(content.length()-15);//15个字
				}else{
					//关键字(关键字搜索的有效长度为10)在中间
					if(targetLen<=15){
						//always true 
						//a1:关键字长度<=15
						if((idx+15)<=contentLen){
							//b1:索引值+15 <= 内容长度
							rtn=content.substring(idx, (idx+15));//15个字
						}else{
							//b1:索引值+15 > 内容长度
							rtn=content.substring(contentLen-15);//小于15个字
						}
					}else{
						//a2:关键字长度>15
						//do nothing
					}
				}
			}else{
				rtn=content;
			}
		}
		return rtn;
	}
	
}
