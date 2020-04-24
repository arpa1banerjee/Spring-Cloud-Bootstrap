package com.example.demo.dto;

public class Department {

	private String departmentNumber;
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
