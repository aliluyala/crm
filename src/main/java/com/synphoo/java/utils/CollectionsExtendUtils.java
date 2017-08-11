package com.synphoo.java.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * List.Set.Map扩展工具类
 * @author wangmingfeng
 *
 */
public class CollectionsExtendUtils {
	
	/**
	 * 使用Arrays.asList将Object[]转换为List<Object>
	 * @param arr
	 * @return
	 */
	public static List<Object> getListFromArray(Object[] arr){
		if(null!=arr&&arr.length>=0){
			List<Object> list=Arrays.asList(arr);
			return list;
		}
		return null;
	}
	
	/**
	 * 使用for each循环将List<Object>转换为List<Integer>
	 * @param targetList
	 * @return
	 */
	public static List<Integer> changeListFromObjectToInteger(List<Object> targetList){
		if(CollectionUtils.isNotEmpty(targetList)){
			List<Integer> ls=new ArrayList<Integer>();
			for (Object obj : targetList) {
				ls.add((Integer)obj);
			}
			return ls;
		}
		return null;
	}
	
	/**
	 * 使用for each循环将List<Object>转换为List<String>
	 * @param targetList
	 * @return
	 */
	public static List<String> changeListFromObjectToString(List<Object> targetList){
		if(CollectionUtils.isNotEmpty(targetList)){
			List<String> ls=new ArrayList<String>();
			for (Object obj : targetList) {
				ls.add((String)obj);
			}
			return ls;
		}
		return null;
	}
	
	/**
	 * 数组转集合:将int[]转为List<Integer>
	 * @param arr
	 * @return
	 */
	public static List<Integer> getListFromArray(int[] arr){
		if(null!=arr&&arr.length>=0){
			List<Integer> ls=new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				ls.add(arr[i]);
			}
			return ls;
		}
		return null;
	}
	
}
