package com.example.demo.dto;

import java.util.Date;

public class EmployeeDTO {
	
	private String first_name;
	private String last_name;
	private char gender;
	private Date hire_date;
	private String dept_name;
	private double salary;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmployeeDTO(String first_name, String last_name, char gender, Date hire_date, String dept_name,
			double salary) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.hire_date = hire_date;
		this.dept_name = dept_name;
		this.salary = salary;
	}
	public EmployeeDTO() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeDTO [first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ ", hire_date=" + hire_date + ", dept_name=" + dept_name + ", salary=" + salary + "]";
	}
	
	

}
