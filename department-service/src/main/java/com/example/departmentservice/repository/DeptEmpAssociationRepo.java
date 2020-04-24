package com.example.departmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentservice.dao.DeptEmpAssociation;
@Repository
public interface DeptEmpAssociationRepo extends JpaRepository<DeptEmpAssociation, Long> {
	List<DeptEmpAssociation> findByEmployeeNumber(long empId);
}
