package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(int idNhanVien);
	void removeEmployeeById(int idNhanVien);
	String getMaxId();
	Employee getByAccount(Account taiKhoan);
}
