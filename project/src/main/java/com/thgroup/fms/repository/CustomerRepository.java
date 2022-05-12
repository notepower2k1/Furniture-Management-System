package com.thgroup.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query(value="Select makh From khachhang Order By makh Desc Limit 1", nativeQuery = true)
	String findFirstMaKH();
	
	@Query(value = "SELECT * from khachhang join taikhoan on khachhang.id_tai_khoan = taikhoan.idtai_khoan WHERE id_tai_khoan = :#{#id_tai_khoan}",nativeQuery = true)
	Customer findCustomer(@Param("id_tai_khoan") int id_tai_khoan);
}
