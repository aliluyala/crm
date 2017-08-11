package com.synphoo.java.test.classLoader;
/**
 * 
 */
/**
 * @author wangmingfeng
 *
 */
public class ClassLoaderA{
	static{
		System.out.println("类ClassLoaderA被加载了");
	}
	
	public static void main(String[] args) {
		/**
		 * ClassLoader的关系：
		 * 根加载器
		 * 扩展类加载器
		 * 应用类加载器
		 * 用户自定义类加载器
		 */
		ClassLoader classLoader=ClassLoader.getSystemClassLoader();
		try {
			//ClassLoader的loadClass方法加载一个类不属于主动调用，不会导致类的初始化。
			//并不会让类加载器初始化com.synfoo.java.test.classLoader.ClassLoaderBoot，因为这不属于主动调用此类
			Class cla=classLoader.loadClass("com.synfoo.java.test.classLoader.ClassLoaderBoot");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}