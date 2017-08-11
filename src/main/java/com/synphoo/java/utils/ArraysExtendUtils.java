package com.synphoo.java.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 数组扩展工具类
 * @author wangmingfeng
 *
 */
public class ArraysExtendUtils {
	
	
	public static Object[] getArrayFromList(List<Object> list){
		if(CollectionUtils.isNotEmpty(list)){
			Object[] arr=list.toArray();
			return arr;
		}
		return null;
	}
	
	/**
	 * int数组类型转object数组类型
	 * @param arr
	 * @return
	 */
	public static Object[] toObjectArray(int[] arr){
		if(null!=arr&&arr.length>=0){
			Object[] obj=new Object[arr.length];
			for (int i = 0; i < arr.length; i++) {
				obj[i]=arr[i];
			}
			return obj;
		}
		return null;
	}
	
	/**
	 * int数组类型转object数组类型
	 * @param arr
	 * @return
	 */
	public static Object[] toObjectArray(String[] arr){
		if(null!=arr&&arr.length>=0){
			Object[] obj=new Object[arr.length];
			for (int i = 0; i < arr.length; i++) {
				obj[i]=arr[i];
			}
			return obj;
		}
		return null;
	}

}
