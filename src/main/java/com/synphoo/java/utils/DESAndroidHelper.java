package com.synphoo.java.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES加密算法
 * @创建者 : chaochen
 * @创建时间 : 2016/6/20 23:29
 * @描述 : ${TODO}
 */

public final class DESAndroidHelper {
	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };
	public static final String KEY_DES_DDQ = "goodstudent";

	/**
	 * 加密
	 * 
	 * @param encryptString
	 * @return
	 * @throws Exception
	 */
	public static String encryptDES(String encryptString) throws Exception {

		IvParameterSpec zeroIv = new IvParameterSpec(iv);

		SecretKeySpec key = new SecretKeySpec(KEY_DES_DDQ.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

		return Base64Utils.encode(encryptedData);

	}

	/**
	 * 解密
	 * 
	 * @param decryptString
	 * @return
	 * @throws Exception
	 */
	public static String decryptDES(String decryptString) throws Exception {

		byte[] byteMi = Base64Utils.decode(decryptString);

		IvParameterSpec zeroIv = new IvParameterSpec(iv);

		SecretKeySpec key = new SecretKeySpec(KEY_DES_DDQ.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);

		byte decryptedData[] = cipher.doFinal(byteMi);

		return new String(decryptedData);

	}

}

