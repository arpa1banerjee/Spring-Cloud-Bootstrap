package com.example.departmentservice.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value = DeptEmpAssociationId.class)
@Table(name = "dept_emp")
public class DeptEmpAssociation {
	@Id
	@Column(name = "emp_no")
	private long employeeNumber;
	
	@Id
	@Column(name = "dept_no")
	private String departmentNumber;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;

	public DeptEmpAssociation(long employeeNumber, String departmentNumber, Date fromDate, Date toDate) {
		super();
		this.employeeNumber = employeeNumber;
		this.departmentNumber = departmentNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
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

	public DeptEmpAssociation() {
		super();
	}

	@Override
	public String toString() {
		return "DeptEmpAssociation [employeeNumber=" + employeeNumber + ", departmentNumber=" + departmentNumber
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	
	
}
