package com.example.salaryservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salaryservice.dao.Salary;
import com.example.salaryservice.repository.SalaryRepository;

import jdk.internal.org.jline.utils.Log;

@Service
public class SalaryService {
	
	private static Logger LOG = LoggerFactory.getLogger(SalaryService.class);
	
	@Autowired
	SalaryRepository salaryRepository;
	
	public int getSalaryRecordCount() {
		List<Salary> salarieRecords = new ArrayList<>();
		try {
			salarieRecords = salaryRepository.findAll();
			if(LOG.isDebugEnabled()) {
				LOG.debug("Salary table size {}", salarieRecords.size());
			}
		} catch (Exception e) {
			LOG.error("exception happened {}", e);
		}
		return salarieRecords.size();
	}

	public List<Salary> getSalaryRecordByEmpId(long empId) {
		List<Salary> salRecords = new ArrayList<>();
		try {
			salRecords = salaryRepository.findByemployeeNumber(empId);
			if(LOG.isDebugEnabled()) {
				if(!salRecords.isEmpty()) {
					salRecords.forEach(record -> LOG.debug("Salary records: {}", record));
				} else {
					LOG.debug("No salaray record found for employee {}", empId);
				}
			}
		}catch (Exception e) {
			LOG.error("exception happened {}", e);
		}
		return salRecords;
	}

}
