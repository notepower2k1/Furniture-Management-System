package com.thgroup.fms.service;

import java.util.List;


import com.thgroup.fms.entity.Account;

public interface AccountService {
	List<Account> getAllAccounts();
	Account saveAccount(Account account);
	Account getByUsername(String tenTaiKhoan);
	Account getById(int idTaiKhoan);
	void removeAccountById(int idTaiKhoan);
	Account findTopByTenTaiKhoan(String tenTaiKhoan);
}