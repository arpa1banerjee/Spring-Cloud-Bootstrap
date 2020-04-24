package com.example.departmentservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "dept_no", length = 4)
	private String departmentNumber;
	
	@Column(name = "dept_name")
	private String departmentName;

	public Department(String departmentNumber, String departmentName) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
	}

	public Department() {
		super();
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentNumber=" + departmentNumber + ", departmentName=" + departmentName + "]";
	}
	
	

}
