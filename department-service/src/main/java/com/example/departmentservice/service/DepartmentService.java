package com.example.departmentservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentservice.dao.Department;
import com.example.departmentservice.dao.DeptEmpAssociation;
import com.example.departmentservice.exception.DeptNotFoundException;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.repository.DeptEmpAssociationRepo;

@Service
public class DepartmentService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	DeptEmpAssociationRepo deptEmpAssociationRepo;
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public Department getDepartmentById(String depNumber) throws DeptNotFoundException {
		return departmentRepository.findById(depNumber)
				.orElseThrow(() -> new DeptNotFoundException("Department record not found for depNumber: " + depNumber));
	}
	
	public Department getDepartmentByEmpId(long empId) throws DeptNotFoundException {
		List<DeptEmpAssociation> depEmps = deptEmpAssociationRepo.findByEmployeeNumber(empId);
		if(log.isDebugEnabled()) {
			depEmps.forEach(obj -> log.debug(obj.toString()));
		}
		Long currenTimeinMillis = System.currentTimeMillis();
		DeptEmpAssociation depEmp = depEmps.stream()
			.filter(sal -> (currenTimeinMillis > sal.getFromDate().getSeconds() && currenTimeinMillis < sal.getToDate().getTime()))
			.collect(toSingleItem());
		return getDepartmentById(depEmp.getDepartmentNumber());
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
