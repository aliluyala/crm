package com.synphoo.java.test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.lang3.CharSet;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.*;
import java.util.Arrays;
 
/**
输出：
原文：[105, 99, 98, 99, 105, 99, 98, 99]
公钥：Sun RSA public key, 3072 bits
  modulus: 3331585596219175364905720784395018517318768164946096067199050963279362507696733294935770240982785303564616267568057711512424223261887842745979299643749947934589849898617066255137653932420217486013191079062617837978388243749364882570483825956783660927819057151334279403614875266715541900022611939996669167721489017958542284200609729572887821705419458550196805837810469325455441806341952637694305199412057104822139526103044686317347155319168324414414230529486129837947428354032473161449374074971892246408569451443632434564785091321929298164111026477848900443170221508934677640728086299046433139117671721711996316896932895569029359961787709617847196938295122312469204710381691514241593937494861800744265976011828382804247145428048853257969959334066857746801065302743922508439239593696449267284922982418939963683039286210544716140157236295641899095820735223419258452946114634901806819802592058925571343627270088512879385583239509
  public exponent: 65537
私钥：sun.security.rsa.RSAPrivateCrtKeyImpl@ffc2b7b5
加密结果：[90, -60, 126, 79, 83, -10, -88, 125, -52, -33, 30, -72, -32, -51, 92, 35, 64, 56, -84, 18, 73, 46, -31, 21, 100, 104, 33, 16, 2, 52, 118, 53, 111, 115, -93, 109, 64, -64, 21, 72, 12, -47, 72, 75, -123, -116, -91, -44, -54, 67, 0, -2, 44, -102, -86, -75, 17, -111, -8, 9, 14, 28, 21, 37, 49, 63, -52, 73, -85, -62, 50, 49, 92, 96, 125, 49, -104, -94, -40, 85, -84, -87, -75, 71, 72, -91, 19, 41, 51, -2, 70, -42, -60, 96, -25, -57, 89, -35, 29, -124, 68, 93, -96, 107, -5, -108, -83, -70, 35, 56, 28, -41, -18, 26, 10, -74, 58, 79, -76, -63, -11, 89, -8, -26, 64, 92, 57, 54, -12, 99, -15, -126, -37, 108, -118, -20, -44, 66, 125, 121, -128, 110, 4, 94, 80, 78, 59, -65, 49, -91, 11, -36, 42, -110, -2, -114, 25, 119, -111, 13, 101, 85, -102, -88, 52, -82, 111, 29, 75, -16, 44, -59, -9, 115, 125, 65, -2, 114, 14, 61, 116, 25, 125, -12, 75, 74, -92, 60, 92, 10, 1, -94, -116, -66, 101, -64, 73, 85, 105, 38, 98, 42, -79, -127, -52, -69, -110, 112, 0, 100, 118, -41, -88, 9, 73, -54, 40, 20, 53, 78, 54, -39, 39, -28, 16, -23, 31, -41, 28, 74, -53, -10, 120, 56, 83, -117, -60, -70, 125, -9, -38, 102, -101, -113, -50, -80, -17, -7, 50, 119, 1, 37, 111, -73, 6, -89, 33, -14, -70, 82, 112, -75, 32, 104, -94, -14, -18, -111, 11, 77, -111, 66, -72, -10, -108, -7, -16, -29, 83, -65, -116, -59, 31, -69, 121, 118, -41, -26, -86, 20, -69, -126, -6, -49, 17, -66, 79, 55, -98, 24, -57, 107, -55, -37, -13, -7, -121, -55, -44, 97, -32, 13, -35, 102, 46, -105, 15, -95, -81, 92, 36, -88, -65, 28, -42, -24, -22, -49, -48, 127, 35, 33, -125, 52, -6, -76, 88, 83, -71, -50, 116, -87, 85, -25, 45, -9, -99, 74, -43, -5, 32, -115, 36, -30, 112, -69, -102, 94, -96, -33, -126, -44, -27, 16, 108, -15, 36, 64, 78, 45, -50, -55, -104, 41, -67, -4, 82, 68, -48, -118, -97, -19, -36, 110]
解密结果：[105, 99, 98, 99, 105, 99, 98, 99]
原文比较：true
 */
public class RSADemo{
    public static void main(String[] args) 
    		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        //B给A发送的信息
        byte[] plain = "icbcicbc".getBytes("UTF-8");
        System.out.println("原文："+ Arrays.toString(plain));
 
        //A生成一个密钥对
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(586); // 指定密钥长度
        KeyPair keyPair = generator.generateKeyPair();
 
        //A把公钥公开
        PublicKey publicKey = keyPair.getPublic();
        //A自己保存好私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("公钥："+publicKey);
        System.out.println("私钥："+privateKey);
 
        Cipher cipher = Cipher.getInstance("RSA");
        
		//加密	
        //B用A的公钥把信息加密后发给A
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        cipher.update(plain);
        byte[] result1 = cipher.doFinal();
        System.out.println("加密结果："+Arrays.toString(result1));
 
		//解密
        //A得到B发过来的信息后用自己的私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();
        System.out.println("解密结果："+Arrays.toString(result2));
        

        System.out.println("原文比较："+Arrays.equals(result2, plain));
        //
        String orgStr=new String(result2, Charset.forName("UTF-8"));
        System.out.println("解密后的字符串："+orgStr);
        
        
    }
}