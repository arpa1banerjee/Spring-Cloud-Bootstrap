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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/v1")
@Api(value="Department Controller")
public class DepartmentController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DepartmentService departmentService;
	
	@ApiOperation(value = "View a list of available departments", response = ResponseEntity.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved all departments"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		return ResponseEntity.ok().body(departmentService.getAllDepartments());
	}
	
	@ApiOperation(value = "Get a department based on dept num", response = ResponseEntity.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved department object based on departmet number"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getDepartmentByDeptNumber/{deptNum}")
	public ResponseEntity<Department> getDepartmentByDeptNumber(
			@ApiParam(value = "Department num from which department object will retrieve", required = true) 
			@PathVariable String deptNum) 
					throws DeptNotFoundException {
		Department department = departmentService.getDepartmentById(deptNum);
		if(log.isDebugEnabled()) {
			log.debug("Department found: {}", department);
		}
		return ResponseEntity.ok().body(department);
	}
	@ApiOperation(value = "Get a department based on employee id", response = ResponseEntity.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved department object based on employee id"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/getDepartmentByEmpId/{empId}")
	public ResponseEntity<Department> getDepartmentByEmpId(
			@ApiParam(value = "Employee id from which department object will be retrieved", required = true) 
			@PathVariable long empId) throws DeptNotFoundException{
		Department department = departmentService.getDepartmentByEmpId(empId);
		if(log.isDebugEnabled()) {
			log.debug("Department found: {}", department);
		}
		return ResponseEntity.ok().body(department);
	}

}
