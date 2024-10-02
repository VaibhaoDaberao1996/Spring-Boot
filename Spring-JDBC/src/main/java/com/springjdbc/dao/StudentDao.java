package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Student;

public interface StudentDao {

	public int insert(Student student);           //Create
	
	public Student getSingleStudent(int stuId);	
												  //Read
	public List<Student> getAllStudent();
	
	public int update(Student student);			  //Update
	
	public int delete(int stuId);				  //Delete
}
