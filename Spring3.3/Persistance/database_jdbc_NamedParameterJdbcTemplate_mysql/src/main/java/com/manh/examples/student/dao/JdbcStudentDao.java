package com.manh.examples.student.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.manh.examples.student.domain.Student;



public class JdbcStudentDao implements StudentDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void insert(Student student) {
		String sql = 
			"INSERT INTO STUDENT (STUDENT_NO, NAME, BIRTHDAY, GRADE) " + 
			"VALUES (:studentNo, :name, :birthday, :grade)";
		
//		BeanPropertySqlParameterSource() wraps a normal Java object as a SQL parameter source.
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(student);
		
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}

	public void insertBatch(List<Student> students) {
		String sql = 
			"INSERT INTO STUDENT (STUDENT_NO, NAME, BIRTHDAY, GRADE) " + 
			"VALUES (:studentNo, :name, :birthday, :grade)";
		
		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();

		for (Student student : students) {
			parameters.add(new BeanPropertySqlParameterSource(student));
		}

		namedParameterJdbcTemplate.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
	}

	public Student findByStudentNo(int studentNo) {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NO = ?";

		RowMapper<Student> studentRowMapper = BeanPropertyRowMapper.newInstance(Student.class);
		
		Student student = namedParameterJdbcTemplate
			.getJdbcOperations()
			.queryForObject(sql, studentRowMapper, studentNo);

		return student;
	}

	public void update(Student student) {
		String sql = "UPDATE STUDENT SET NAME = :name, GRADE = :grade, BIRTHDAY = :birthday WHERE STUDENT_NO = :studentNo";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(student);
		
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}

	public void delete(Student student) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("studentNo", student.getStudentNo());

		String sql = "DELETE FROM STUDENT WHERE STUDENT_NO = :studentNo";
		
		namedParameterJdbcTemplate.update(sql, args);
	}

	public List<Student> findAll() {
		String sql = "SELECT * FROM STUDENT";
		
		RowMapper<Student> rm = BeanPropertyRowMapper.newInstance(Student.class);
		List<Student> students = namedParameterJdbcTemplate.query(sql, rm);

		return students;
	}

	public String getName(int studentNo) {
		String sql = "SELECT NAME FROM STUDENT WHERE STUDENT_NO = ?";

		String name = namedParameterJdbcTemplate
			.getJdbcOperations()
			.queryForObject(sql, String.class, studentNo);

		return name;
	}

	public int countAll() {
		String sql = "SELECT COUNT(*) FROM STUDENT";

		int count = namedParameterJdbcTemplate
			.getJdbcOperations()
			.queryForObject(sql, Integer.class);

		return count;
	}
}
