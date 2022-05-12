package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.repository.CustomerRepository;
import com.thgroup.fms.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return this.customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int idKhachHang) {
		Optional<Customer> optional = this.customerRepo.findById(idKhachHang);
		Customer customer = null;
		if(optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException("Customer not found for id::" + idKhachHang);
		}
		return customer;
	}

	@Override
	public void removeCustomerById(int idKhachHang) {
		this.customerRepo.deleteById(idKhachHang);
	}

	@Override
	public String getMaxId() {
		return this.customerRepo.findFirstMaKH();
	}

	@Override
	public Customer findCustomer(int id_tai_khoan) {
		return this.customerRepo.findCustomer(id_tai_khoan);
	}

	
	

}
