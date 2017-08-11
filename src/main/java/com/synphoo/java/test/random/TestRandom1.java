package com.synphoo.java.test.random;
/**
 * java.lang.Math.Random;
 * 调用这个Math.Random()函数能够返回带正号的double值，
 * 该值大于等于0.0且小于1.0，即取值范围是[0.0,1.0)的左闭右开区间，
 * 返回值是一个伪随机选择的数，在该范围内（近似）均匀分布。
 * @author wangmingfeng
 *
 */
public class TestRandom1 {
    
    public static void main(String[] args) {
    	System.out.println(fun2());
	}
    
    public static void fun(){
    	// 结果是个double类型的值，区间为[0.0,1.0）
        System.out.println("Math.random()=" + Math.random()); 
        String str=String.valueOf(Math.random());
        System.out.println(str);
        System.out.println(str.substring(2));//16位
        // 注意不要写成(int)Math.random()*3，这个结果为0，因为先执行了强制转换
//        int num = (int) (Math.random() * 3); 
//        System.out.println("num="+num);
        /**
         * 输出结果为：
         * 
         * Math.random()=0.02909671613289655
         * num=0
         * 
         */
    }
    
    /**
     * 获取16位随机数
     * @return
     */
    public static String fun2(){
    	// 结果是个double类型的值，区间为[0.0,1.0）
        String str=String.valueOf(Math.random());
        return str.substring(2);//16位
    }
}