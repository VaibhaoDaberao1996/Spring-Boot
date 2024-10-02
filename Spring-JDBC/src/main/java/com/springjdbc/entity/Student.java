package com.springjdbc.entity;

public class Student {

	private int stuId;
	private String stuName;
	private String stuCity;
	
	public int getRollno() {
		return stuId;
	}
	public void setRollno(int rollno) {
		this.stuId = rollno;
	}
	public String getName() {
		return stuName;
	}
	public void setName(String name) {
		this.stuName = name;
	}
	public String getCity() {
		return stuCity;
	}
	public void setCity(String city) {
		this.stuCity = city;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + stuId + ", name=" + stuName + ", city=" + stuCity + "]";
	}
	
	
}
