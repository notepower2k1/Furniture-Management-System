package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Account getByUsername(String tenTaiKhoan) {
		return this.accountRepository.findByTenTaiKhoan(tenTaiKhoan);
	}

	@Override
	public Account getById(int idTaiKhoan) {
		Optional<Account> optional = this.accountRepository.findById(idTaiKhoan);
		Account account = null;
		if(optional.isPresent()) {
			account = optional.get();
		} else {
			throw new RuntimeException("Account not found	for id:" + idTaiKhoan);
		}
		return account;
	}

	@Override
	public void removeAccountById(int idTaiKhoan) {
		this.accountRepository.deleteById(idTaiKhoan);
	}

	@Override
	public Account findTopByTenTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return this.accountRepository.findTopByTenTaiKhoan(tenTaiKhoan);
	}

	

}
