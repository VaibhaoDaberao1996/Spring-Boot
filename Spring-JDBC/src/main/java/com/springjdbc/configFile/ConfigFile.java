package com.springjdbc.configFile;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoClass;

@Configuration
public class ConfigFile {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds =new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		ds.setUsername("root");
		ds.setPassword("bravestone@96");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemp() {
		JdbcTemplate temp =new JdbcTemplate();
		temp.setDataSource(getDataSource());
		return temp;
	}
	 
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoClass stuDao = new StudentDaoClass();
		stuDao.setTemp(getJdbcTemp());
		return stuDao;
	}
}
