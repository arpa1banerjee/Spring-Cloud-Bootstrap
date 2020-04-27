package com.example.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.dao.Department;
import com.example.departmentservice.exception.DeptNotFoundException;
import com.example.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		return ResponseEntity.ok().body(departmentService.getAllDepartments());
	}
	
	@GetMapping("/getDepartmentByDeptNumber/{deptNum}")
	public ResponseEntity<Department> getDepartmentByDeptNumber(@PathVariable String deptNum) throws DeptNotFoundException{
		Department department = departmentService.getDepartmentById(deptNum);
		if(log.isDebugEnabled()) {
			log.debug("Department found: {}", department);
		}
		return ResponseEntity.ok().body(department);
	}
	
	@GetMapping("/getDepartmentByEmpId/{empId}")
	public ResponseEntity<Department> getDepartmentByEmpId(@PathVariable long empId) throws DeptNotFoundException{
		Department department = departmentService.getDepartmentByEmpId(empId);
		if(log.isDebugEnabled()) {
			log.debug("Department found: {}", department);
		}
		return ResponseEntity.ok().body(department);
	}

}
