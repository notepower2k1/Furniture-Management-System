package com.thgroup.fms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;
import com.thgroup.fms.repository.FurnitureRepository;
import com.thgroup.fms.repository.OrderDetailsRepository;
import com.thgroup.fms.repository.OrderRepository;
import com.thgroup.fms.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderDetailsRepository repo;
	@Autowired
	private FurnitureRepository repoF;
	@Autowired
	private OrderRepository repoO;
	@Override
	public List<OrderDetails> getByOrderId(int idDonHang) {
		List<OrderDetails> list = new ArrayList<>();
		List<OrderDetails> temp = this.repo.findAll();
		temp.forEach(item -> {
			if (item.getDonDatHang().getIdDonHang() == idDonHang) {
				list.add(item);
			}
		});
		return list;
	}

	@Override
	public OrderDetails save(OrderDetails orderDetails) {
		return this.repo.save(orderDetails);
	}

	@Override
	public OrderDetails getByIds(int idDonHang, int idNoiThat) {
		Furniture noiThat = this.repoF.getById(idNoiThat);
		Order donHang = this.repoO.getById(idDonHang);
		return this.repo.findBydonDatHangAndNoiThat(donHang, noiThat);
	}

	@Override
	public void removeByIds(int idDonHang, int idNoiThat) {
		Furniture noiThat = this.repoF.getById(idNoiThat);
		Order donHang = this.repoO.getById(idDonHang);
		this.repo.deleteBydonDatHangAndNoiThat(donHang, noiThat);
	}

	@Override
	public float getRevenueTotal() {
		return this.repo.getRevenueTotal();
	}

	@Override
	public Float getLMonthRevenue() {
		Float res = this.repo.getLMonthRevenue();
		if (res == null) {
			return (float) 0;
		} else {
			return res;
		}
	}

	@Override
	public Float getRevenueWithMonth(int month) {
		Float res = this.repo.getRevenueWithMonth(month);
		if (res == null) {
			return (float) 0;
		} else {
			return res;
		}
	}

	@Override
	public Float getRevenueWithCategory(String category) {
		Float res = this.repo.getRevenueWithCategory(category);
		if (res == null) {
			return (float) 0;
		} else {
			return res;
		}
	}
}
