package com.synphoo.java.test.ascii;

/**
 * 
 * 【支付宝，微信支付必备】Java实现url参数按照参数名ASCII码从小到大排序（字典序）
 * 参数名ASCII码从小到大排序
 */
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ddcash.server.app.framework.utils.MD5Utils;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//字典序列排序
		Map<String,String> paraMap = new HashMap<String,String>();
		paraMap.put("device_info","1000");
		paraMap.put("body","test");
		paraMap.put("appid", "wxd930ea5d5a258f4f");
		paraMap.put("mch_id", "10000100");
		paraMap.put("nonce_str","ibuaiVcKdpRxkhJA");
		String url = formatUrlMap(paraMap, true, false);
		System.out.println(url);
		url=url+"&key=192006250b4c09247ec02edce69f6a2d";
		String ss="";
		try {
			ss = MD5Utils.encrypt(url);
		} catch (Exception e) {
		}
				System.out.println("加密="+ss.toUpperCase());
		/**
		 * 控制台输出
		   appid=wxd678efh567hg6787&body=%E8%85%BE%E8%AE%AF%E5%85%85%E5%80%BC%E4%B8%AD%E5%BF%83-QQ%E4%BC%9A%E5%91%98%E5%85%85%E5%80%BC&out_trade_no=20150806125346&total_fee=200
		 */
	}
	
	/**
	 * 
	 * 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串<br>
	 * 实现步骤: <br>
	 * 
	 * @param paraMap   要排序的Map对象
	 * @param urlEncode   是否需要URLENCODE
	 * @param keyToLower    是否需要将Key转换为全小写  true:key转化成小写，false:不转化
	 * @return
	 */
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)
	{
	    String buff = "";
	    Map<String, String> tmpMap = paraMap;
	    try
	    {
	        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());// tmpMap.entrySet()
	        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
	        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()
	        {
	
	            @Override
	            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
	            {
	                return (o1.getKey()).toString().compareTo(o2.getKey());
	            }
	        });
	        // 构造URL 键值对的格式
	        StringBuilder buf = new StringBuilder();
	        for (Map.Entry<String, String> item : infoIds)
	        {
	            if (StringUtils.isNotBlank(item.getKey()))
	            {
	                String key = item.getKey();
	                String val = item.getValue();
	                if (urlEncode)
	                {
	                    val = URLEncoder.encode(val, "utf-8");
	                }
	                if (keyToLower)
	                {
	                    buf.append(key.toLowerCase() + "=" + val);
	                } else
	                {
	                    buf.append(key + "=" + val);
	                }
	                buf.append("&");
	            }
	
	        }
	        buff = buf.toString();
	        if (buff.isEmpty() == false)
	        {
	            buff = buff.substring(0, buff.length() - 1);
	        }
	    } catch (Exception e)
	    {
	       return null;
	    }
	    return buff;
	}

}