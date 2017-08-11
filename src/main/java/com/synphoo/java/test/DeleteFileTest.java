package com.synphoo.java.test;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

/**
 * 递归删除文件
 * @author wangmingfeng
 *
 */
public class DeleteFileTest {
	
	public static void main(String[] args) {
		DeleteFileTest obj=new DeleteFileTest();
		//测试1：
		//String url="D:\\workspacewmf\\alibaba\\123";
		//obj.doFunOnA(url);
		//测试2：
		//String url="D:\\workspacewmf\\alibaba\\124";
		//obj.doFunOnB(url);
		//测试3：
		//String url="D:\\workspacewmf\\alibaba\\128";
		//obj.doFunOnC(url,"");
		//测试4：
		String url="D:\\workspacewmf\\alibaba\\125";
		File folder=new File(url);
		obj.deleteDir(folder);
	}
	/**
	 * 删除根目录下的所有文件（仅删除文件，不删除目录）
	 * @param url
	 */
	public void doFunOnA(String filePath){
		System.out.println("路径名称："+filePath);
		if(StringUtils.isNotBlank(filePath)){
			File soureFile=new File(filePath);
			if(soureFile.exists()){
				if(soureFile.isDirectory()){
					File[] arr=soureFile.listFiles();
					for (File file : arr) {
						if(file.isDirectory()){
							doFunOnA(file.getAbsolutePath());
						}else{
							System.out.println("第一处删除文件名称："+file.getName());
							file.delete();
						}
					}
				}else{
					//不会执行else语句
				}
			}
		}
	}
	
	/**
	 * 删除根目录下的所有文件（删除根目录、根目录下的所有子文件和子目录）
	 * @param url
	 */
	public void doFunOnB(String filePath){
		System.out.println("路径名称："+filePath);
		if(StringUtils.isNotBlank(filePath)){
			File soureFile=new File(filePath);
			if(soureFile.exists()){
				if(soureFile.isDirectory()){
					File[] arr=soureFile.listFiles();
					for (File file : arr) {
						if(file.isDirectory()){
							doFunOnB(file.getAbsolutePath());
						}else{
							System.out.println("第一处删除文件名称："+file.getName());
							file.delete();
						}
					}
				}else{
					//不会执行else语句
				}
				System.out.println("删除目录名称："+soureFile.getName());
				soureFile.delete();
			}
			
		}
	}
	
	/**
	 * 删除根目录下的所有文件（删除根目录下的所有子文件和子目录，但不删除根目录）
	 * @param url
	 */
	public void doFunOnC(String rootPath,String childPath){
		if(StringUtils.isNotBlank(rootPath)){
			File soureFile;
			if(StringUtils.isNotBlank(childPath)){
				soureFile=new File(childPath);
			}else{
				soureFile=new File(rootPath);
			}
			System.out.println("路径名称："+soureFile.getAbsolutePath());
			if(soureFile.exists()){
				if(soureFile.isDirectory()){
					File[] arr=soureFile.listFiles();
					for (File file : arr) {
						if(file.isDirectory()){
							doFunOnC(rootPath,file.getAbsolutePath());
						}else{
							System.out.println("第一处删除文件名称："+file.getName());
							file.delete();
						}
					}
				}else{
					//不会执行else语句
				}
			}
			if(!soureFile.getAbsolutePath().equals(rootPath)){
				System.out.println("删除目录名称："+soureFile.getName());
				soureFile.delete();
			}else{
				System.out.println("根目录不删除，根目录名称："+soureFile.getName());
			}
		}
	}
	
    private static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
               File file = new File(dir, children[i]);
               if(!file.isDirectory())
               {
            	   file.delete();
               }
            }
        }
    }
}
