package com.example.departmentservice.dao;

import java.io.Serializable;

public class DeptEmpAssociationId  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long employeeNumber;
	private String departmentNumber;
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
	

}
