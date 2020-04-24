package com.example.demo.feignService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Salary;

@Component
public class SalaryServiceFallback implements SalaryServiceFeign {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public List<Salary> getSalary(long empId) {
		if(log.isDebugEnabled()) {
			log.debug("Fallback initiated for salary service as there is some problem with it for empId: {}", empId);
		}
		
		return new ArrayList<>();
	}

}
