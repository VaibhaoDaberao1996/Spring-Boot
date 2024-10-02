package com.springjdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springjdbc.configFile.ConfigFile;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
		  ApplicationContext context = new
		  AnnotationConfigApplicationContext(ConfigFile.class);
		  
		  StudentDao stuDao =context.getBean("studentDao",StudentDao.class);
		 
		/*
		 * Student stu1 =new Student(); stu1.setRollno(14); stu1.setName("sanjana");
		 * stu1.setCity("new york");
		 * 
		 * int added =stuDao.insert(stu1); System.out.println("student added "+added);
		 */
    	
		/*
		 * Student student =stuDao.getSingleStudent(11); System.out.println(student);
		 */
    	
		
		
		/*
		 * List<Student> students= studao.getAllStudent(); for(Student s:students) {
		 * System.out.println(s); }
		 */
		 
    	
		/*
		 * int delete =stuDao.delete(14); System.out.println("delete row : "+delete);
		 */
    	
		/*
		 * Student student =new Student(); student.setRollno(12);
		 * student.setName("Shubham"); student.setCity("Pune");
		 * 
		 * int update =stuDao.update(student);
		 * System.out.println("Update item : "+update);
		 */
    }
}
