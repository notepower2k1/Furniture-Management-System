package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer saveCustomer(Customer customer);
	Customer getCustomerById(int idKhachHang);
	void removeCustomerById(int idKhachHang);
	String getMaxId();
	Customer getByAccount(Account taiKhoan);
}
