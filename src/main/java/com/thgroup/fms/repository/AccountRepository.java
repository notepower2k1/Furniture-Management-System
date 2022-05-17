package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thgroup.fms.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	Account findByTenTaiKhoan(String tenTaiKhoan);
	
	Account findTopByTenTaiKhoan(String tenTaiKhoan);

}
