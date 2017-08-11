package com.synphoo.java.test.responseDto;

import javax.xml.bind.annotation.XmlElement;

import com.ddcash.server.app.framework.utils.StringHelper;
/**
 * 调用蜂鸟系统采集或查询
 *
 */
public class XMLResultData {
	/**
	 * 接口调用状态
	0	请求成功
	1	请求失败
	110	系统异常
	500	服务与外部通信失败失败
	 */
	@XmlElement(name = "StatusCode")
    protected Integer StatusCode;
	/**
	 * 
	 */
    @XmlElement(name = "Result")
    protected Object Result;
    /**
     * 描述
     */
    @XmlElement(name = "StatusDescription")
    protected String StatusDescription;
    /**
     * 本次会话的电商Token
     */
    @XmlElement(name = "Token")
    protected String Token;
    /**
     * 
     */
    @XmlElement(name = "Website")
    protected Object Website;
    /**
     * 下一步流程
	0	登录
	1	发短信
	2	验证短信
	3	完成
     */
    @XmlElement(name = "nextProCode")
    protected String nextProCode;
    /**
     * 验证码图片Base64字符串(无验证码返回none)
     */
    @XmlElement(name = "VerCodeBase64")
    protected Object VerCodeBase64;
    
    /**
      * 1000	登录失败
      * 1001	账号被锁定
      * 1002	用户名或密码错误
      * 1003	验证码错误或超时
      * 1004	系统繁忙
      * 1005	网站异常
      * 1006	登录超时
      * 1007	正在登录中
      * 1008	等待发送短信验证码
      * 2000	登录成功
      * 2001	数据正在采集
      * 2002	数据采集成功
      * 2003	数据采集失败
      */
    @XmlElement(name = "CrawlStatus")
    protected  String  CrawlStatus;
    
    //
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public Object getResult() {
		return Result;
	}
	public void setResult(Object result) {
		if(StringHelper.isNullOrEmpty(result)){
			result=null;
		}
		Result = result;
	}
	public String getStatusDescription() {
		return StatusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		if(StringHelper.isNullOrEmpty(statusDescription)){
			statusDescription="";
		}
		StatusDescription = statusDescription;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		if(StringHelper.isNullOrEmpty(token)){
			token="";
		}
		Token = token;
	}
	public Object getWebsite() {
		return Website;
	}
	public void setWebsite(Object website) {
		if(StringHelper.isNullOrEmpty(website)){
			website=null;
		}
		Website = website;
	}
	public Object getVerCodeBase64() {
		return VerCodeBase64;
	}
	public void setVerCodeBase64(Object verCodeBase64) {
		if(StringHelper.isNullOrEmpty(verCodeBase64)){
			verCodeBase64=null;
		}
		VerCodeBase64 = verCodeBase64;
	}
	
	public String getNextProCode() {
		return nextProCode;
	}
	public void setNextProCode(String nextProCode) {
		if(StringHelper.isNullOrEmpty(nextProCode)){
			nextProCode="";
		}
		this.nextProCode = nextProCode;
	}
	
	public String getCrawlStatus() {
		return CrawlStatus;
	}
	public void setCrawlStatus(String crawlStatus) {
		CrawlStatus = crawlStatus;
	}

	
	
	
}
