package com.example.demo.feignService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Department;

@Component
public class DepartmentServiceFallback implements DepartmentServiceFeign {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public Department getDeptByEmpId(long empId) {
		if(log.isDebugEnabled()) {
			log.debug("Fallback initiated for department service as there is some problem with it for empId: {}", empId);
		}
		
		return new Department();
	}

}
