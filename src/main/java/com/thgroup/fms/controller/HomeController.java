package com.thgroup.fms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thgroup.fms.service.CategoryService;
import com.thgroup.fms.service.OrderDetailsService;
import com.thgroup.fms.service.OrderService;

@Controller
public class HomeController {
	@Autowired
	private OrderDetailsService orderDService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/admin")
	public String dashboardPage(Model model) {
		
		//Area chart
		List<Integer> months = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		List<String> areaChartLabels = new ArrayList<>();
		List<Float> areaChartData = new ArrayList<>();
		months.forEach(month -> {
			areaChartLabels.add("Tháng " + month);
			areaChartData.add(this.orderDService.getRevenueWithMonth(month));
		});
		model.addAttribute("areaChartData", areaChartData);
		model.addAttribute("areaChartLabels", areaChartLabels);
		
		//Pie chart
		List<String> pieChartLabels = new ArrayList<>();
		List<Float> pieChartData = new ArrayList<>();
		this.categoryService.getAllCategories().forEach(category -> {
			pieChartLabels.add(category.getTenLoai());
		});
		pieChartLabels.forEach(label -> {
			pieChartData.add(this.orderDService.getRevenueWithCategory(label));
		});
		model.addAttribute("pieChartData", pieChartData);
		model.addAttribute("pieChartLabels", pieChartLabels);
		
		//4 Cards ở trên
		model.addAttribute("orderTotal", this.orderService.getOrderTotal());
		model.addAttribute("orderConfirmQtt", this.orderService.getConfirmOrderQtt());
		model.addAttribute("orderPendingQtt", this.orderService.getPendingOrderQtt());
		model.addAttribute("revenueTotal", this.orderDService.getRevenueTotal());
		model.addAttribute("lMonthRevenue", this.orderDService.getLMonthRevenue());
		
		return "admin/home/dashboard";
	}
}
