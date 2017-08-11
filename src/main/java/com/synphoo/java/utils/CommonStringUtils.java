package com.synphoo.java.utils;

import org.apache.commons.lang3.StringUtils;

public class CommonStringUtils {

	
	/**
	 * 处理字符串----返回包含关键字的最长15个字的结果字符串
	 * @param content 原字符串
	 * @param searchName 字符串中的关键字
	 * @return
	 */
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
