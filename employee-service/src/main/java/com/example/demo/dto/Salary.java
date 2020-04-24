package com.example.demo.dto;

import java.util.Date;


public class Salary{
	private long employeeNumber;
	private double sal;
	private Date fromDate;
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
