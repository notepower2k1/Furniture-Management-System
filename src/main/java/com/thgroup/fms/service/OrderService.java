package com.thgroup.fms.service;

import java.util.List;


import com.thgroup.fms.entity.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Order saveOrder(Order Order);
	Order getOrderById(int idDonHang);
	void removeOrderById(int idDonHang);
	String getMaxId();
	int getConfirmOrderQtt();
	int getPendingOrderQtt();
	int getOrderTotal();
	List<Order> findOrder(int id_tk);
}
