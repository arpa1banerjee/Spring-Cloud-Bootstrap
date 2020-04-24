package com.example.demo.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.Department;

@FeignClient(name = "department-service", fallback = DepartmentServiceFallback.class)
public interface DepartmentServiceFeign {

	@GetMapping("/api/v1/getDepartmentByEmpId/{empId}")
	public Department getDeptByEmpId(@PathVariable long empId);
}
