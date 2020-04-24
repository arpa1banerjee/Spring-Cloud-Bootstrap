package com.example.salaryservice.dao;

import java.io.Serializable;
import java.util.Date;

public class SalaryId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long employeeNumber;
	private Date fromDate;
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	

}
