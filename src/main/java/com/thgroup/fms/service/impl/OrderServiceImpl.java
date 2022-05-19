package com.thgroup.fms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Order;
import com.thgroup.fms.repository.OrderRepository;
import com.thgroup.fms.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	public OrderServiceImpl(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public List<Order> getAllOrders() {
		return this.orderRepo.findAll();
	}

	@Override
	public Order saveOrder(Order Order) {
		return this.orderRepo.save(Order);
	}

	@Override
	public Order getOrderById(int idDonHang) {
		Optional<Order> optional = this.orderRepo.findById(idDonHang);
		Order order = null;
		if(optional.isPresent()) {
			order = optional.get();
		} else {
			throw new RuntimeException("Order not found for id::" + idDonHang);
		}
		return order;
	}

	@Override
	public void removeOrderById(int idDonHang) {
		this.orderRepo.deleteById(idDonHang);
	}

	@Override
	public String getMaxId() {
		return this.orderRepo.findFirstMaDonHang();
	}

	@Override
	public int getConfirmOrderQtt() {
		return this.orderRepo.getConfirmOrderQtt();
	}

	@Override
	public int getPendingOrderQtt() {
		return this.orderRepo.getPendingOrderQtt();
	}

	@Override
	public int getOrderTotal() {
		return this.orderRepo.getOrderTotal();
	}

	@Override
	public List<Order> findOrder(int id_tk) {
		// TODO Auto-generated method stub
		return this.orderRepo.getOrderInfo(id_tk);
	}

}
