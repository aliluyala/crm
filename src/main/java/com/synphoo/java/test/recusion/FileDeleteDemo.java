/*
     需求：删除H:\demo目录下的带内容的文件
     分析：
         A：封装该目录
         B：获取该目录下所有的文件或文件夹的File数组
         C：遍历该File数组，获取每一个File对象
         D：判断所遍历的FIle对象
             是否是文件夹
                 是：返回步骤B
                 不是：判断里面是否有内容
                     有：删除
                     不是：不理
     B-D设为递归方法：
         返回类型;void
         参数列表：File xxx
         出口：文件里面有内容
 */
package com.synphoo.java.test.recusion;

import java.io.File;

public class FileDeleteDemo {

    public static void main(String[] args) {
        //封装该目录
        File allfile = new File("H:\\demo");
        //调用递归
        deletefile(allfile);    
     }
    
    //递归方法
    private static void deletefile(File allfile) {
        //获取该目录下的所有文件或文件夹的File数组
        File[] arrayfile = allfile.listFiles();
        
        //遍历该数组，获取每一个File对象
        for(File file : arrayfile){
            //判断是否是文件夹
            if(file.isDirectory()){
                //是的话，返回步骤B
                deletefile(file);
            }
            else{
                //不是，就判断是否为空文件
                long l = file.length();
                if(l != 0 ){
                    file.delete();
                }
                //如果是空文件的话，就输出它的名称和绝对路径
                else{
                    System.out.println(file.getName()+"\t"+file.getAbsolutePath());
                    /*
                    a.txt    H:\demo\a.txt
                    地方.mp3    H:\demo\地方.mp3
                    斯蒂芬撒.avi    H:\demo\撒旦发射的\斯蒂芬撒.avi
                    */
                }
            }
        }

    }

}