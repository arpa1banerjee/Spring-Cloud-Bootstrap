package com.example.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when department record is not
 * found for a given department number in departments table
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeptNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeptNotFoundException(String msg) {
		super(msg);
	}

}
