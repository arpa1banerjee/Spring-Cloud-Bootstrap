package com.example.salaryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salaryservice.dao.Salary;
import com.example.salaryservice.service.SalaryService;

@RestController
@RequestMapping("/api/v1")
public class SalaryController {
	
	@Autowired
	SalaryService salaryService;
	
	@GetMapping("/getSalaryRecordCount")
	public int getSalaryRecordCount() {
		return salaryService.getSalaryRecordCount();
	}
	
	@GetMapping("/getSalaryRecordByEmpId/{empId}")
	public List<Salary> getSalaryRecordByEmpId(@PathVariable int empId) {
		return salaryService.getSalaryRecordByEmpId(empId);
	}
	

}
