package com.example.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dao.Department;
import com.example.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/getDepartmentByDeptNumber/{deptNum}")
	public Department getDepartmentByDeptNumber(@PathVariable String deptNum){
		Department department = new Department();
		try {
			department = departmentService.getDepartmentById(deptNum);
		} catch (Exception e) {
			log.error("Exception ocurred {}", e);
		}
		return department;
	}
	
	@GetMapping("/getDepartmentByEmpId/{empId}")
	public Department getDepartmentByEmpId(@PathVariable long empId){
		Department department = new Department();
		try {
			department = departmentService.getDepartmentByEmpId(empId);
		} catch (Exception e) {
			log.error("Exception ocurred {}", e);
		}
		return department;
	}

}
