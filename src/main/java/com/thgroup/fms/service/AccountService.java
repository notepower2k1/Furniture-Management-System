package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Account;

public interface AccountService {
	List<Account> getAllAccounts();
	Account saveAccount(Account account);
	int findidtai_khoan(String tenTaiKhoan);
}