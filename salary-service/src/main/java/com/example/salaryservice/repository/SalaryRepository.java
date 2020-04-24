package com.example.salaryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.salaryservice.dao.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

	@Query(value = "SELECT sal FROM Salary sal WHERE sal.employeeNumber = :empId")
	List<Salary> findByemployeeNumber(@Param("empId") long empId);

}
