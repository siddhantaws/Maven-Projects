package com.manh.examples.student.domain;

import java.util.Date;

public class Student {
	private int studentNo;
	
	private String name;
	
	private Date birthday;
	
	private int grade;

	public Student() {}

	public Student(int studentNo, String name, Date birthday, int grade) {
		this.studentNo = studentNo;
		this.name = name;
		this.birthday = birthday;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
	}
}