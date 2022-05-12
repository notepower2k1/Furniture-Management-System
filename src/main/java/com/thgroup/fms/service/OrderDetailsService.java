package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> getByOrderId(int idDonHang);
	OrderDetails save(OrderDetails orderDetails);
	OrderDetails getByIds(int idDonHang, int idNoiThat);
	void removeByIds(int idDonHang, int idNoiThat);
	float getRevenueTotal();
	Float getLMonthRevenue();
	Float getRevenueWithMonth(int month);
	Float getRevenueWithCategory(String category);
}
