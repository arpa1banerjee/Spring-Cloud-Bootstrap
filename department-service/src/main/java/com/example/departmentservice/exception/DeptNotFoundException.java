package com.example.departmentservice.exception;


/**
 * This exception is thrown when department record is not
 * found for a given department number in departments table
 *
 */
public class DeptNotFoundException extends Exception {
	
	public DeptNotFoundException(String msg) {
		super(msg);
	}

}
