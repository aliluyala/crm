package com.synphoo.java.test.staticKeyword;

class StaticAoo {
	//静态变量
	static int age;
	
	//静态方法
	static void getAge(){
		
	}
	
	//静态内部类
	static class StaticAtt{
		
	}
	
	//内部类
	class StaticAss{
		
	}
	
	public static void main(String[] args) {
		StaticAoo a=new StaticAoo();
		StaticAoo.StaticAtt t=new StaticAoo.StaticAtt();//静态内部类 实例，通过类调用；
		StaticAoo.StaticAss s=a.new StaticAss();// 内部类 实例,通过实例调用内部类；
		
		System.out.println("a="+a);
		System.out.println("t="+t);
		System.out.println("s="+s);
	}

}
