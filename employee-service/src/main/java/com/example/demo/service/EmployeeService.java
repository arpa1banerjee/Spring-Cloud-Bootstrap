package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Employee;
import com.example.demo.dto.Department;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.Salary;
import com.example.demo.feignService.DepartmentServiceFeign;
import com.example.demo.feignService.SalaryServiceFeign;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	SalaryServiceFeign salaryServiceProxy;
	
	@Autowired
	DepartmentServiceFeign departmentServiceFeign;
	
	@Autowired
	Mapper mapper;

	public EmployeeDTO getEmployeeDetail(long empId) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Optional<Employee> employee = employeeRepository.findById(empId);
		if(employee.isPresent()) {
			employeeDTO = mapper.map(employee.get(), EmployeeDTO.class);
			
			Salary salary = getSalaryDetail(empId);
			employeeDTO.setSalary(salary.getSal());
			
			Department department = getDepartmentDetail(empId);
			employeeDTO.setDept_name(department.getDepartmentName());
		}
		return employeeDTO;
	}
	
	private Department getDepartmentDetail(long empId) {
		return departmentServiceFeign.getDeptByEmpId(empId);
	}

	private Salary getSalaryDetail(long empId) {
		List<Salary> salary = salaryServiceProxy.getSalary(empId);
		if(log.isDebugEnabled()) {
			salary.forEach(sal -> log.debug("Salary fetched from salary microservice, {}", sal));
		}
		Long currenTimeinMillis = System.currentTimeMillis();
		return salary.stream()
			.filter(sal -> (currenTimeinMillis > sal.getFromDate().getSeconds() && currenTimeinMillis < sal.getToDate().getTime()))
			.collect(toSingleItem());
	}
	
	private static <T> Collector<T, ?, T> toSingleItem() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    throw new IllegalStateException();
	                }
	                return list.get(0);
	            }
	    );
	}

}
