/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
package com.synphoo.java.test.designPattern.producerConsumer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synphoo.java.utils.DateUtils;

/**
 * 对附件生成全文检索所需的索引文件
 * 生产者-消费者模式
 * @author wangmingfeng
 * 角色：
 * AttachementProcessor--生产者
 * targetChannel--通道
 * 消费者indexingThread
 */
public class AttachementProcessor{
	private final Logger logger=LoggerFactory.getLogger(AttachementProcessor.class);
	private final String attachment_store_base_dir="D:\\workspacewmf\\crm\\src\\main\\resources\\storeFile";
	//通道
	private final Channel<File> targetChannel=new BlockingQueueChannel<File>(new ArrayBlockingQueue<File>(200));
	
	/**
	 * 保存文件
	 * @param inputStream
	 * @param dirId
	 * @param originalFileName
	 * @throws IOException
	 */
	public void saveAttachement(InputStream inputStream,String dirId,String originalFileName) throws IOException{
		File file=saveAsFile(inputStream, dirId, originalFileName);
		if(file.exists()){
			System.out.println("文件"+file.getName()+"保存成功！");
		}
	}
	
	/**
	 * 保存文件
	 * @param inputStream
	 * @param documentId
	 * @param originalFileName
	 * @return
	 * @throws IOException
	 */
	private File saveAsFile(InputStream inputStream,String dirId,String originalFileName) throws IOException{
		String dirName=attachment_store_base_dir+"\\"+dirId;
		File dir=new File(dirName);
		System.out.println("输出dir结果"+dir);
		if(!dir.isDirectory()&&!dir.exists()){
			dir.mkdirs();//与dir.mkdir();区别：
		}
		String name2=Normalizer.normalize(originalFileName,Normalizer.Form.NFC);
		System.out.println("输出name2结果"+name2);//wsdl.txt
		originalFileName=getProcessedString(originalFileName);
		System.out.println("输出originalFileName结果"+originalFileName);
		File file=new File(dirName+"/"+Normalizer.normalize(originalFileName,Normalizer.Form.NFC));
		//file = D:\workspacewmf\crm\src\main\resources\storeFile\20170503114100\wsdl.txt
		System.out.println(" 输出dirName结果 "+dirName);
		System.out.println("输出file.getCanonicalFile().getParent()结果 "+file.getCanonicalFile().getParent());
		//防止目录跨域攻击
		if (!dirName.equals(file.getCanonicalFile().getParent())) {
			throw new SecurityException("Invalid originalFileName:"+originalFileName);
		}
		System.out.println("上传之前结果："+file.exists());
		BufferedOutputStream bufferedOutputStream=null;
		BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
		byte[] byteArray=new byte[2048];
		int len=-1;
		try{
			bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file));
			while ((len=bufferedInputStream.read(byteArray))>0) {
				bufferedOutputStream.write(byteArray,0,len);
			}
			bufferedOutputStream.flush();
		}catch(Exception e){
			logger.error("写文件异常",e);
		}finally{
			bufferedInputStream.close();
			if(null!=bufferedOutputStream){
				bufferedOutputStream.close();
			}
		}
		System.out.println("输出file结果"+file.exists());
		return file;
	}
	
	/**
	 * 处理文件名
	 * @param original
	 * @return
	 */
	public String getProcessedString(String original){
		String name="";
		if(StringUtils.isNotBlank(original)){
			String[] arr=original.split("\\.");//“.”必须以“\\.”转义
			synchronized (this) {
				if(null!=arr&&arr.length==2){
					name=arr[0]+"_"+new Date().getTime()+"."+arr[1];
				}
			}
		}
		return name;
	}
	
	/**
	 * 消费者indexingThread--自身的工作者线程
	 */
	private final AbstractTerminatableThread indexingThread=new AbstractTerminatableThread(){
		@Override
		public void run() {
			File file=null;
			try {
				file=targetChannel.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			indexFile(file);
		}
		
		private void indexFile(File file) {
			//省略其它代码
			//模拟生成索引文件的时间消耗
			Random random=new Random();
			
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	};
	
	public void init(){
		indexingThread.start();
	}
	
	public void shutdown(){
		indexingThread.doTerminate();
	}
	
	
}