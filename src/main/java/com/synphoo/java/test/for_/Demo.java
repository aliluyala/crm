/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.for_;

import java.util.Arrays;
import java.util.List;

public class Demo{
	public static void main(String[] args) {
		String[] target = {
    			"aa",
    			"bb",
    			"cc",
    			"dd",
    			"ee",
    			"ff",
    			"gg",
    			"hh",
    			"ii",
    			"jj"
		};
		String[] arr = {
    			"aa2",
    			"bb2",
    			"cc2",
    			"dd",
    			"ee2"
		};
		List<String> targetList = Arrays.asList(target);
		boolean flag=false;
		int n=-1;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("打印i="+i);
			if(targetList.contains(arr[i])){
				flag=true;
				n=i;
				break;
			}
		}
		System.out.println("flag="+flag+" ,n="+n);
	
	}
}