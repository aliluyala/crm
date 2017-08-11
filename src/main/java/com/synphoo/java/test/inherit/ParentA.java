package com.synphoo.java.test.inherit;

public class ParentA{
	private String name;
	private String age;
	public ParentA(String name,String age) {
		System.out.println("parent constructor with parameters");
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}