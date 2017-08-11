package com.synphoo.java.test.lombok;

import lombok.extern.java.Log;

@Log
public class StudentTest {

	public static void main(String[] args) {
		//stu
		Student stu=new Student();
		stu.setName("王先森");
		stu.setAge(28);
		stu.setStudentNo("30000009999");
		
		System.out.println(stu.getName()+","+stu.getAge()+","+stu.getStudentNo());
		System.out.println(stu.toString());
		log.info("测试log输出");
		
		Student stu2=new Student();
		stu2.setName("王先森");
		stu2.setAge(28);
		stu2.setStudentNo("30000009999");
		//
		System.out.println(stu.hashCode());
		System.out.println(stu2.hashCode());
		System.out.println("hashcode值="+(stu.hashCode()==stu2.hashCode()));
		System.out.println("equal="+stu.equals(stu2));//true
		stu2.setAge(29);
		System.out.println("equal2="+stu.equals(stu2));//false
		
		log.info("测试结束");
		
		Student stu3=new Student("a",1,"c");

		
	}
}
