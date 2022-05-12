package com.thgroup.fms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	@Transactional
	public OrderDetails findBydonDatHangAndNoiThat(Order donHang, Furniture noiThat);
	@Transactional
	public void deleteBydonDatHangAndNoiThat(Order donHang, Furniture noiThat);
	@Query(value = "SELECT SUM(gia_mua*so_luong) FROM chitietddh ct JOIN "
			+ "dondathang ddh ON ddh.iddon_hang = ct.iddon_hang WHERE tinh_trang = 1", nativeQuery = true)
	public float getRevenueTotal();
	@Query(value = "SELECT SUM(gia_mua*so_luong) FROM chitietddh ct JOIN "
			+ "dondathang ddh ON ddh.iddon_hang = ct.iddon_hang "
			+ "WHERE YEAR(ngay_lap) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH) "
			+ "AND MONTH(ngay_lap) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) "
			+ "AND tinh_trang = 1", 
			nativeQuery = true)
	public Float getLMonthRevenue();
	@Query(value = "SELECT SUM(gia_mua*so_luong) FROM chitietddh ct JOIN "
			+ "dondathang ddh ON ddh.iddon_hang = ct.iddon_hang "
			+ "WHERE MONTH(ngay_lap) = :#{#month} AND tinh_trang = 1", nativeQuery = true)
	public Float getRevenueWithMonth(@Param("month") int month);
	@Query(value = "SELECT SUM(gia_mua*so_luong) FROM ((chitietddh ct JOIN "
			+ "dondathang ddh ON ddh.iddon_hang = ct.iddon_hang) JOIN "
			+ "noithat nt ON nt.idnoi_that = ct.idnoi_that) JOIN "
			+ "loainoithat lnt ON lnt.idloai = nt.id_loai "
			+ "WHERE ten_loai = :#{#category} AND tinh_trang = 1",  nativeQuery = true)
	public Float getRevenueWithCategory(@Param("category") String category);
}
