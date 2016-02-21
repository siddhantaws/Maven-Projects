package com.manh.examples.student.dao;

import java.util.List;

import com.manh.examples.student.domain.Student;

public interface StudentDao {
	
	public void insert(Student student);

	public void update(Student student);

	public void delete(Student student);

	public Student findByStudentNo(int studentNo);

	public void insertBatch(List<Student> students);

	public List<Student> findAll();

	public String getName(int studentNo);

	public int countAll();
}