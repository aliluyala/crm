package com.synphoo.java.test.designPattern.producerConsumer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		Test test=new Test();
		AttachementProcessor attachementProcessor=new AttachementProcessor();
		System.out.println("输出File.separator结果 "+ File.separator);//  输出结果: \
		String path=test.getPath2("/");
		File file=new File("D:"+File.separator+"mydemo"+File.separator+"fileDir"+File.separator+"wsdl.txt");
		InputStream inputStream=null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String dirId="10086";
		String originalFileName="wsdl.txt";
		try {
			attachementProcessor.saveAttachement(inputStream, dirId, originalFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPath(String type){
		String path="";
		if("".equals(type)){
			//当前目录
		}else if(".".equals(type)){
			//当前目录
		}else if("../".equals(type)){
			//上一级目录
		}else if("/".equals(type)){
			//根目录
		}
		path=getClass().getResource(type).getFile().toString();
		System.out.println("path输出="+path);
		return path;
	}
	
	public String getPath2(String type){
		String path="";
		/*if("".equals(type)){
			//当前目录
		}else if(".".equals(type)){
			//当前目录
		}else if("../".equals(type)){
			//上一级目录
		}else if("/".equals(type)){
			//根目录
		}*/
		//path=Test.class.getClass().getResource(type).getPath();///   D:/workspacewmf/crm/target/classes/
		//path=Thread.currentThread().getContextClassLoader().getResource(".").getPath();//   /D:/workspacewmf/crm/target/classes/
		path=this.getClass().getClassLoader().getResource(".").getPath();///   D:/workspacewmf/crm/target/classes/
		System.out.println("输出path2结果"+path);
		return path;
	}
}
