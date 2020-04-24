package com.example.salaryservice.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SalaryId.class)
@Table(name = "salaries")
public class Salary{
	
	@Id
	@Column(name = "emp_no")
	private long employeeNumber;
	
	@Column(name = "salary")
	private double sal;
	
	@Id
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;

	public Salary(long employeeNumber, double salary, Date fromDate, Date toDate) {
		super();
		this.employeeNumber = employeeNumber;
		this.sal = salary;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Salary() {
		super();
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double salary) {
		this.sal = salary;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Salary [employeeNumber=" + employeeNumber + ", salary=" + sal + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	

}
