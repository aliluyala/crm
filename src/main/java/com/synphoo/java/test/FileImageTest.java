package com.synphoo.java.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.codec.Charsets;

public class FileImageTest {

	public static void main(String[] args) {
		//读取路径图片到byte[]
		FileImageTest obj=new FileImageTest();
		String url="D:\\id.jpg";
		byte[] a=obj.doImage2byteFun(url);
		System.out.println(a.length);
		System.out.println(a);
		//将byte[]数据写到图片路径
		obj.doByte2imageFun(a, "D:\\study\\id.jpg");
		//byte[]转String
		String c=new String(a);
		System.out.println("字符串打印"+c);
		System.out.println("长度："+c.getBytes().length);
	}
	
	/**
	 * 图片到byte[]
	 * 使用了FileImageInputStream与ByteArrayOutputStream
	 * @param inFileUrl
	 * @return
	 */
	public byte[] doImage2byteFun(String inFileUrl) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(inFileUrl));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}
	/**
	 * byte[]到图片
	 * 使用了FileImageOutputStream
	 * @param data
	 * @param outFilePath
	 */
	public void doByte2imageFun(byte[] data, String outFilePath) {
		if (data.length < 3 || outFilePath.equals(""))
			return;
		try {
			FileImageOutputStream imageOutput = new FileImageOutputStream(
					new File(outFilePath));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in "
					+ outFilePath);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}
}
