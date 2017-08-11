/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.synphoo.java.test.andOr;
public class Demo{
	
	public static void main(String[] args) {
		/*if(fun_2()&fun_3()){
			//不管fun_2和fun_3的返回值是多少，都会执行，只有两者都为true时，返回true
			System.out.println("正向1");
		}else{
			System.out.println("反向1");
		}*/
		
		/*if(fun_4()|fun_5()){
			//不管fun_4和fun_5的返回值是多少，都会执行，任意一个为true时，返回true
			System.out.println("正向2");
		}else{
			System.out.println("反向2");
		}*/
		
		System.out.println(switch_4());
	}
	
	public static void fun_1(){
		int a=1,b=(int) 2.0;
		double c=0.22223;
		Double d=3.6666;
		float e=(float) 1.2;
		float f=1.55f;
	}
	
	public static boolean fun_2(){
		System.out.println("fun_2");
		return true;
	}
	public static boolean fun_3(){
		System.out.println("fun_3");
		return true;
	}
	public static boolean fun_4(){
		System.out.println("fun_4");
		return true;
	}
	public static boolean fun_5(){
		System.out.println("fun_5");
		return true;
	}
	
	/**
	 * switch(A),括号中A的取值只能是整型或者可以转换为整型的数值类型，比如byte、short、int、char、String、还有枚举；需要强调的是：long类型是不能作用在switch语句上的。
	 * break default;
	 * @return
	 */
	public static int switch_1(){
		int a=1;
		switch(a){
			case 1:{
				a=a+a*1;
				break;
			}
			case 2:a=a+a*2;break;
			case 3:a=a+a*3;break;
			default:break;
		}
		System.out.println("a="+a);
		return a;
	}
	
	public static int switch_2(){
		int a=0;
		switch(a){
			case 1:{
				a=a+a*1;
				break;
			}
			case 2:a=a+a*2;break;
			case 3:a=a+a*3;break;
			default:a=9;break;
		}
		System.out.println("a="+a);
		return a;
	}
	
	public static String switch_3(){
		String a="a";
		switch(a){
			case "a":{
				a=a+" hello";
				break;
			}
			case "b":a=a+" hello";break;
			case "c":a=a+" hello";break;
			default:a=" default";break;
		}
		System.out.println("a="+a);
		return a;
	}
	
	public static long switch_4(){
		long a=10;
		switch(a){
		/**
		 * Cannot switch on a value of type long. Only convertible int values, strings or enum variables are permitted
		 */
			case 10:{
				a=a+1;
				break;
			}
			case 20:a=a+2;break;
			case 30:a=a+3;break;
			default:a=a+0;break;
		}
		System.out.println("a="+a);
		return a;
	}
	
	
}