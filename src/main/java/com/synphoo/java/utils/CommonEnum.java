package com.synphoo.java.utils;

/**
 * 
 * @description 通用枚举
 *
 * @author lixining
 * @version $Id: Agent.java, v 0.1 2015年8月6日 下午2:27:09 lixining Exp $
 */
public enum CommonEnum {
	
	/**
	 * 时间单位：天
	 */
	days("days"),
	/**
	 * 时间单位：小时
	 */
	hours("hours"),
	/**
	 * 时间单位：分钟
	 */
	minutes("minutes"),
	/**
	 * 时间单位：秒
	 */
	seconds("seconds"),
	/**
	 * 时间单位：毫秒
	 */
	milliseconds("milliseconds"),
	/**
	 * 起始时间后缀
	 */
	time_format_suffix_start(" 00:00:00"),
	/**
	 * 结束时间后缀
	 */
	time_format_suffix_end(" 23:59:59"),
	/**
     * 客户导流豆豆花
     */
	Cache_GUIDE_CUSTOMER_TO_DDH("cache_guide_customer_to_ddh"),
	/**
	 * 配置豆豆钱App用户完成手机认证已超过的小时数
	 */
	VAR_MOBILE_AUTH_EXCEED_HOURS("VAR_MOBILE_AUTH_EXCEED_HOURS"),
	/**
	 * 固定值字符串“-1”
	 */
	Fixed_Value_Minus_1("-1"),
	/**
	 * 固定值字符串“0”
	 */
	Fixed_Value_0("0"),
	/**
	 * 固定值字符串“1”
	 */
	Fixed_Value_1("1"),
	/**
	 * 固定值字符串“2”
	 */
	Fixed_Value_2("2"),
	/**
	 * 固定值字符串“3”
	 */
	Fixed_Value_3("3"),
	/**
	 * 固定值字符串“4”
	 */
	Fixed_Value_4("4"),
	/**
	 * 固定值字符串“5”
	 */
	Fixed_Value_5("5"),
	/**
	 * 固定值字符串“15”
	 */
	Fixed_Value_15("15"),
	/**
	 * 固定值字符串“20”
	 */
	Fixed_Value_20("20"),
	/**
	 * 您还没有登录或登录已过期，请重新登录
	 */
	MESSAGE_SHOW_FOR_TOKEN_EXPIRED("您还没有登录或登录已过期，请重新登录"),
	/**
	 * 类型user-agent
	 */
	KEY_NAME_USER_AGENT("USER-AGENT"),
	/**
	 * 未知客户端
	 */
	DEVICE_TYPE_UNKNOWN("UNKNOWN"),
	/**
	 * IOS客户端
	 */
	DEVICE_TYPE_IOS("IOS"),
	/**
	 * ANDROID客户端
	 */
	DEVICE_TYPE_ANDROID("ANDROID"),
	/**
     * 公积金的初始化数据的缓存标识符的一部分
     */
	Cache_Housing_Fund_Character("housing_fund_cache"),
	/**
     * 社保的初始化数据的缓存标识符的一部分
     */
	Cache_Social_Security_Character("social_security_cache"),
	/**
	 * 校验身份证号码的正则表达式
	 * 目前我国公民身份证号码由18位数字组成：前6位为地址码，第7至14位为出生日期码，第15至17位为顺序码，第18位为校验码。
	 * 检验码分别是“0、1、2、……10”共11个数字，当检验码为“10”时，为了保证公民身份证号码18位，所以用“X”表示。
	 */
	Reg_Ex_IdentityNo("^([0-9]{17}([0-9]|X))$"),
	/**
     * Bool字符串“true”
     */
	Bool_Str_True("TRUE"),
	/**
     * Bool字符串“false”
     */
	Bool_Str_False("FALSE"),
	/**
     * 我的任务3
     */
	MY_Task_TYPE_3("myTask3"),
	/**
     * 我的任务3:任意绑定一个账号获取X元额度
     */
	MyTask3_Edq_Amout_X("myTask3_Edq_Amout_X"),
	/**
     * 我的任务3:绑定两个账号获取Y元额度
     */
	MyTask3_Edq_Amout_Y("myTask3_Edq_Amout_Y"),
	/**
     * ENABLE_DELETE_FLAG值为0
     */
	ENABLE_DELETE_FLAG_0("0"),
	/**
     * ENABLE_DELETE_FLAG值为1
     */
	ENABLE_DELETE_FLAG_1("1"),
    /**
     * 请求蜂鸟接口的豆豆钱bus_type
     */
    FENGNIAO_DDQ_BUS_TYPE("doudouqian"),
    /**
     * app前端请求接口类型：公积金
     */
	Request_Gjj("providentFund"),
	 /**
     * app前端请求接口类型：社保
     */
	Request_Shebao("socialSecurity");

    private String code;

    private CommonEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
