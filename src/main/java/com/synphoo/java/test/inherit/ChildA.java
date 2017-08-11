package com.synphoo.java.test.inherit;

class ChildA extends ParentA {
	private String sex;
	public ChildA() {
		/**
		 子类的构造方法，不管这个构造方法带不带参数，
		 默认的它都会先去寻找父类的不带参数的构造方法。
		 如果父类没有不带参数的构造方法，
		 那么子类必须用supper关键子来调用父类带参数的构造方法，否则编译不能通过
		 */
		super("", "");//这句话必须要
		System.out.println("child constructor");
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public static void main(String[] args) {
		new ChildA();
	}

}
