package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.repository.EmployeeRepository;
import com.thgroup.fms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int idNhanVien) {
		Optional<Employee> optional = this.employeeRepo.findById(idNhanVien);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id::" + idNhanVien);
		}
		return employee;
	}

	@Override
	public void removeEmployeeById(int idNhanVien) {
		this.employeeRepo.deleteById(idNhanVien);
	}

	@Override
	public String getMaxId() {
		return this.employeeRepo.findFirstMaNV();
	}

	@Override
	public Employee getByAccount(Account taiKhoan) {
		return this.employeeRepo.findByTaiKhoan(taiKhoan);
	}

}
