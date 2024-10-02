package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.springjdbc.entity.Student;

public class StudentDaoClass implements StudentDao {
	

	private JdbcTemplate temp;

	public JdbcTemplate getTemp() {
		return temp;
	}

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	
	//Inserting Operation
	@Override
	public int insert(Student student) {
		String query = "insert into studentInfo(rollno,name,city) value(?,?,?)";
		int result =this.temp.update(query,student.getRollno(),student.getName(),student.getCity());
		System.out.println("No of row affected "+result);
		return result;
	}
	
	//Read|Get single Object
	@Override
	public Student getSingleStudent(int stuId) {
		 RowFetcher rowMap = new RowFetcher(); 
		 
		 String query="select * from studentInfo where rollno=? ";
		 Student student =this.temp.queryForObject(query, rowMap, stuId);
		 return student;
	}
	
	//Read|Get all Object
	@Override
	public List<Student> getAllStudent() {
		String query="select * from studentInfo";
		
		List<Student> students= this.temp.query(query, new RowFetcher());
		return students;
	}
	
	//Update Operation
	@Override
	public int update(Student student) {
		String query="update studentInfo set name=? ,city=? where rollno=? ";
		
		int update =this.temp.update(query,student.getName(),student.getCity(),student.getRollno());
		return update;
	}
	
	//Delete Operation
	@Override
	public int delete(int stuId) {
		String query ="delete from studentInfo where rollno=?";
		int delete=this.temp.update(query,stuId);
		return delete;
	}


}
