package com.manh.examples.student;

import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.manh.examples.student.dao.StudentDao;
import com.manh.examples.student.domain.Student;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		StudentDao studentDao = (StudentDao) context.getBean("studentDao");

		Student student = new Student(0001, "Sang Shin", new GregorianCalendar(2010, 4, 5).getTime(), 9);
		try {
			studentDao.insert(student);
			
			student = studentDao.findByStudentNo(0001);
			System.out.println("--->Student No: " + student.getStudentNo());
			System.out.println("--->Name: " + student.getName());
			System.out.println("--->Birthday: " + student.getBirthday());
			System.out.println("--->Grade: " + student.getGrade());
			
//			Causes an error since we are using duplicate key
			student = new Student(0001, "Sang Shin", new GregorianCalendar(2010, 4, 5).getTime(), 9);
			studentDao.insert(student);
		} catch (DataAccessException dataAccessException) {
			SQLException sqlException = (SQLException) dataAccessException.getCause();
			System.out.println("--->Error code: " + sqlException.getErrorCode());
			System.out.println("--->SQL state: " + sqlException.getSQLState());
			System.out.println("--->Message: " + sqlException.getMessage());
		} finally {
			context.close();
		}
	}
}