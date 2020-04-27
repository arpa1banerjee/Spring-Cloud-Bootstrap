package com.example.departmentservice.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.departmentservice.exception.CustomErrorDetail;
import com.example.departmentservice.exception.DeptNotFoundException;

@ControllerAdvice
public class DepartmentControllerAdvice {

	@ExceptionHandler(value = DeptNotFoundException.class)
	public ResponseEntity<?> deptNotFoundException(DeptNotFoundException ex, WebRequest req) {
		CustomErrorDetail error = new CustomErrorDetail(new Date(), ex.getMessage(), req.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
