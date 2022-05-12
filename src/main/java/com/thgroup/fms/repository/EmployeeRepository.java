package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thgroup.fms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="Select manv From nhanvien Order By manv Desc Limit 1", nativeQuery = true)
	String findFirstMaNV();
	
}
