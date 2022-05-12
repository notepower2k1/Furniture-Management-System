package com.thgroup.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "Select madh From dondathang Order By madh Desc Limit 1", nativeQuery = true)
	public String findFirstMaDonHang();
	@Query(value = "Select count(iddon_hang) From dondathang", nativeQuery = true)
	public int getOrderTotal();
	@Query(value = "Select count(iddon_hang) From dondathang Where tinh_trang = 1", nativeQuery = true)
	public int getConfirmOrderQtt();
	@Query(value = "Select count(iddon_hang) From dondathang Where tinh_trang = 0", nativeQuery = true)
	public int getPendingOrderQtt();
		
	@Query(value ="SELECT * FROM dondathang WHERE id_khach_hang = :#{#id_kh}", nativeQuery = true)
	List<Order> findOrder(@Param("id_kh")int id_kh);
	
	
}
