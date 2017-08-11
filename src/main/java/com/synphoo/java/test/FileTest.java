package com.synphoo.java.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/*import org.tempuri.SendMessageService;
import org.tempuri.SendMessageServiceSoap;
import org.tempuri.SmsMessageData;*/
/**
 * 文件操作-输入输出流
 * @author wangmingfeng
 *
 */
public class FileTest {

	/*demoA*/
	public static void main(String[] args) {
		String pathname="d:\\bank";
		File file=new File(pathname);
		if(file.isDirectory()){
			//打印文件(这里指的是file文件夹)的路径
			System.out.println(file.getPath());
		}
	}
	
	public void doMethodA(String url) throws Exception{
		/*SendMessageService sendMessageService=new SendMessageService(new URL(url));
		SendMessageServiceSoap sendMessageServiceSoap=sendMessageService.getSendMessageServiceSoap();
		SmsMessageData messageData =new SmsMessageData();
		messageData.setCustomerType((short)1);
		boolean result=sendMessageServiceSoap.sendSmsMessage(messageData);*/
	}
}
