package com.thgroup.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.repository.AccountRepository;
import com.thgroup.fms.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account saveAccount(Account account) {
		return this.accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return this.accountRepository.findAll();
	}

	@Override
	public int findidtai_khoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return this.accountRepository.findidtai_khoan(tenTaiKhoan);
	}

	

}
