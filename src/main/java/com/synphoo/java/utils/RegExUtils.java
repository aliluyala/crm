package com.synphoo.java.utils;

import java.util.regex.Pattern;
/**
 * 正则表达式工具类
 * @author wangmingfeng
 *
 */
public class RegExUtils {
	
	
	/**
	 * 非零的正整数
	 */
	public static final String Reg_Ex_Positive_Integer = "^[1-9]\\d*$";
	/**
	 * 校验身份证号码的正则表达式
	 * 目前我国公民身份证号码由18位数字组成：前6位为地址码，第7至14位为出生日期码，第15至17位为顺序码，第18位为校验码。
	 * 检验码分别是“0、1、2、……10”共11个数字，当检验码为“10”时，为了保证公民身份证号码18位，所以用“X”表示。
	 */
	public static final String Reg_Ex_IdentityNo = "^([0-9]{17}([0-9]|X))$";
    /**
     * 输入正则表达式 和需要判断的值，返回判断结果
     * 
     * @param regex
     * @param value
     * @return
     */
    public static boolean checkValidByRegex(String regex, String value){
        return Pattern.matches(regex, value);
    }
}
