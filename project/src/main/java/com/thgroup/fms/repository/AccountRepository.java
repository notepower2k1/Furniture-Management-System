package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value="SELECT idtai_khoan from taikhoan WHERE ten_tai_khoan = :#{#tenTaiKhoan}", nativeQuery = true)
	int findidtai_khoan(@Param("tenTaiKhoan") String tenTaiKhoan);
	
	Account findByTenTaiKhoan(String tenTaiKhoan);
}
