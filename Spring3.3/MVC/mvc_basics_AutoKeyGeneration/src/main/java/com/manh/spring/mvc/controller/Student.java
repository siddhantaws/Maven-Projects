package com.manh.spring.mvc.controller;

public class Student {

	private double grade; 
	
	private String studentName;
	

	public Student(double grade, String studentName) {
		super();
		this.grade = grade;
		this.studentName = studentName;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}
