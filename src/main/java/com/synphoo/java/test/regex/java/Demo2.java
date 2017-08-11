package com.synphoo.java.test.regex.java;

import java.util.regex.Pattern;
/**
 * 实际测试
 * @author wangmingfeng
 *
 */
public class Demo2 {
	 //4304*****7733
    public static void main(String[] args) {
    	//4304*****7733
    	String regEx_Custom_1="(\\d{3})\\d{11}(\\w{4})";
    	String referalIentityNo="320922199612035718";
    	String fomateReferalIentityNo = referalIentityNo.replaceAll("(\\d{3})\\d{11}(\\w{4})","$1*****$2");
    	//System.out.println("1输出="+fomateReferalIentityNo);//320*****5718
    	//调用
    	//Pattern方式1
    	String email="96345584@qq.com";
		Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		if (!p.matcher(email).matches()){
			//System.out.println("邮箱格式不正确，请输入正确的邮箱");
		}else{
			//System.out.println("邮箱正确");
		}
		//Pattern方式2
		String value="100.25";
        String pattern = "^[1-9]([0-9])*00(.00*)?$";
        //System.out.println("输出="+Pattern.matches(pattern, value));
        String word="张三";
        //String word="http://www.beta2.ddcash.cn/apphomepage/homePage.html?token=e79fda90-b043-49ca-8309-805895e83969&customerId=1000909689&name=张三";
    	String regexWord="[\u4e00-\u9fa5]+";
    	System.out.println("6输出="+Pattern.matches(regexWord,word));
	}
}
