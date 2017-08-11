/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.io.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class fileDemo{
	
	public static void main(String[] args) {
		
	}
	
	public void doFun(String zipEntryName,String outPath,String descDir){
		String[] fileName =zipEntryName.split("\\."); // 文件名
		outPath =  (descDir+"/"+zipEntryName).replaceAll("\\*", "/");//存储路径
		for(int i=1;i<999999999;i++){
			File files = new File(outPath); 
			if(files.exists()){ 
				outPath =  (descDir+"/"+fileName[0]+"("+i+")."+fileName[1]).replaceAll("\\*", "/");
			}else{
				break;
			}
		}
        //写入文件
		/*ZipEntry zipEntry = null;
		ZipInputStream zipIn = new ZipInputStream(in);
        InputStream in = zipIn.getInputStream(zipEntry);
        OutputStream out = new FileOutputStream(outPath); 
        byte[] buf1 = new byte[1024]; 
        int len; 
        while((len=in.read(buf1))>0){ 
            out.write(buf1,0,len); 
        } 
        in.close(); 
        out.close();            */
	}
	
	
	public void doFun2(){
		
	}
	
	
}