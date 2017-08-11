package com.synphoo.java.test.responseDto;

import com.ddcash.server.app.framework.utils.StringHelper;
import com.google.gson.annotations.SerializedName;
/**
 * 调用蜂鸟系统公积金接口的采集、查询、评分计算返回的Dto
 * 注意：接口返回的数据都是json格式的，用@SerializedName处理；
 *      接口返回的额数据是xml格式的，用@XmlElement处理；
 * @author wangmingfeng
 *
 */
public class JSONResultData extends Result{
	/**
	 * 接口调用状态
		0	请求成功
		1	请求失败
		5      需要验证码
		110	系统异常
		500	服务与外部通信失败失败
	 */
	@SerializedName("StatusCode")
    protected Integer statusCode;
    /**
     * 描述
     */
	@SerializedName("StatusDescription")
    protected String statusDescription;
    
	/**
	 * 结果-json字符串
	 */
    @SerializedName("Result")
    protected Object result;
    
    /**
     * 验证码图片Base64字符串(无验证码返回none)
     */
    @SerializedName("VerCodeBase64")
    protected String verCodeBase64;
    
    /**
     * 本次会话的令牌
     */
    @SerializedName("Token")
    protected String token;
    
    /**
     * 网址对象
     */
    @SerializedName("Website")
    protected String website;
    /**
     * 下一步流程
	0	登录
	1	发短信
	2	验证短信
	3	完成
     */
    @SerializedName("nextProCode")
    protected String nextProCode;
    
	public Integer getStatusCode() {
		if(StringHelper.isNullOrEmpty(statusCode)){
    		statusCode=null;
		}
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		if(StringHelper.isNullOrEmpty(statusCode)){
    		statusCode=null;
		}
		this.statusCode = statusCode;
    }
	public Object getResult() {
		if(StringHelper.isNullOrEmpty(result)){
			result=null;
		}
		return result;
	}
	public void setResult(Object result) {
		if(StringHelper.isNullOrEmpty(result)){
			result=null;
		}
		this.result = result;
	}
	public String getStatusDescription() {
		if(StringHelper.isNullOrEmpty(statusDescription)){
			statusDescription="";
		}
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		if(StringHelper.isNullOrEmpty(statusDescription)){
			statusDescription="";
		}
		this.statusDescription = statusDescription;
	}
	public String getToken() {
		if(StringHelper.isNullOrEmpty(token)){
			token="";
		}
		return token;
	}
	public void setToken(String token) {
		if(StringHelper.isNullOrEmpty(token)){
			token="";
		}
		this.token = token;
	}
	public String getVerCodeBase64() {
		if(StringHelper.isNullOrEmpty(verCodeBase64)){
			verCodeBase64="";
		}
		return verCodeBase64;
	}
	public void setVerCodeBase64(String verCodeBase64) {
		if(StringHelper.isNullOrEmpty(verCodeBase64)){
			verCodeBase64="";
		}
		this.verCodeBase64 = verCodeBase64;
	}
	public String getWebsite() {
		if(StringHelper.isNullOrEmpty(website)){
			website="";
		}
		return website;
	}
	public void setWebsite(String website) {
		if(StringHelper.isNullOrEmpty(website)){
			website="";
		}
		this.website = website;
	}
	public String getNextProCode() {
		if(StringHelper.isNullOrEmpty(nextProCode)){
			nextProCode=null;
		}
		return nextProCode;
	}
	public void setNextProCode(String nextProCode) {
		if(StringHelper.isNullOrEmpty(nextProCode)){
			nextProCode=null;
		}
		this.nextProCode = nextProCode;
	}
}
