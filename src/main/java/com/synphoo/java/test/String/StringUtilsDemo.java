/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.String;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsDemo{
	
	public static void main(String[] args) {
//		fun();
		String name="刘畅";
		name=name.substring(0, 1)+"*";
		System.out.println(name);
	}
	public static void fun(){
		List<String> list=new ArrayList<String>();
		list.add("我");
		list.add("是");
		list.add("中");
		list.add("国");
		list.add("人");
		String joinStr=StringUtils.join(list.toArray(), ",");
		System.out.println("joinStr="+joinStr);
		//
		String[] strArr={"a",null,"b","c",""};
		System.out.println(StringUtils.join(strArr,"%"));
	}
}