package com.manh.examples.student;

import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.manh.examples.student.dao.StudentDao;
import com.manh.examples.student.domain.Student;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		StudentDao studentDao = (StudentDao) context.getBean("studentDao");

		Student student;
		try {
			student = studentDao.findByStudentNo(0001);
		} catch (EmptyResultDataAccessException e) {
			student = new Student(0001, "Sang Shin", new GregorianCalendar(2010, 4, 5).getTime(), 9);
			studentDao.insert(student);
		}
		student = studentDao.findByStudentNo(0001);
		
		System.out.println("--->Student No: " + student.getStudentNo());
		System.out.println("--->Name: " + student.getName());
		System.out.println("--->Birthday: " + student.getBirthday());
		System.out.println("--->Grade: " + student.getGrade());
		
		context.close();
	}
}