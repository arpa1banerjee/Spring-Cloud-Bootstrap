package com.example.demo.feignService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.Salary;

@FeignClient(name = "salary-service", fallback = SalaryServiceFallback.class)
public interface SalaryServiceFeign {

	@GetMapping("/api/v1/getSalaryRecordByEmpId/{empId}")
	public List<Salary> getSalary(@PathVariable long empId);
}
