package com.example.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.departmentservice.dao.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
	
//	@Query(value = "SELECT dep FROM Department dep JOIN dep.dept_emp depemp ON\n" + 
//			"dep.departmentNumber = depemp.dept_no AND depemp.emp_no = :empId")
//	Department findDeptbyEmpId(long empId);

}
