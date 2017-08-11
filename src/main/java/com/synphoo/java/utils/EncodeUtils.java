package com.synphoo.java.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodeUtils {
    private static final Logger logger          = LoggerFactory.getLogger(EncodeUtils.class);
    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * Base64编码String
     * 
     * @param value
     * @return String
     */
    public static String base64Encode(String value) {
        byte[] data = getBytes(value);
        if (data == null) {
            return null;
        }
        return Base64.encodeBase64String(data);
    }

    /**
     * Base64解码
     * 
     * @param value
     * @return String
     */
    public static String base64Decode(String value) {
        byte[] data = Base64.decodeBase64(value);
        return convertString(data);
    }

    /**
     * 获取字符串的字节数据
     * 
     * @param value
     */
    public static byte[] getBytes(String value) {
        byte[] result = null;
        try {
            result = value.getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error("get utf-8 bytes fail", e);
            throw new RuntimeException("get string bytes fail", e);
        }
        return result;
    }

    /**
     * 字节数组转String
     * 
     * @param data
     * @return String
     */
    public static String convertString(byte[] data) {
        String result = null;
        try {
            result = new String(data, DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error("convert string fail", e);
        }
        return result;
    }

    /**
     * 字符转码
     * 
     * @param value
     * @return String
     */
    public static String urlDecode(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return URLDecoder.decode(value, DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error(value + "url decode fail", e);
        }
        return null;
    }
}
