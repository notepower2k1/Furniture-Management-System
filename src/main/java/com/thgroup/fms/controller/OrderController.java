package com.thgroup.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.EmployeeService;
import com.thgroup.fms.service.OrderDetailsService;
import com.thgroup.fms.service.OrderService;
import com.thgroup.fms.utils.Helper;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailsService orderDetailService;

	
	@Autowired
	private AccountService accountService;
	
	public OrderController(OrderService orderService, EmployeeService employeeService,
			CustomerService customerService) {
		super();
		this.orderService = orderService;
	
	}

	@GetMapping("/admin/order")
	public String ordersListPage(Model model) {
		model.addAttribute("ordersList", this.orderService.getAllOrders());
		return "admin/order/index";
	}
	
	@GetMapping("/admin/detail-order/{idDonHang}")
	public String orderDetailPage(@PathVariable(value="idDonHang") int idDonHang, Model model) {
		Order order = this.orderService.getOrderById(idDonHang);
		List<OrderDetails> detailsList = this.orderDetailService.getByOrderId(idDonHang);
		model.addAttribute("order", order);
		model.addAttribute("detailsList", detailsList);
		return "admin/order/detail";
	}
	
	@GetMapping("/admin/update-order/{idDonHang}")
	public String updateEmployeePage(@PathVariable(value="idDonHang") int idDonHang, Model model) {
		Order order = this.orderService.getOrderById(idDonHang);
		List<Account> accountList = this.accountService.getAllAccounts();
		List<OrderDetails> detailsList = this.orderDetailService.getByOrderId(idDonHang);
	    model.addAttribute("order", order);
	    model.addAttribute("accountList", accountList);
	    model.addAttribute("detailsList", detailsList);
	    return "admin/order/update_order";
	}
	    
	@PostMapping("/admin/save-order")
	public String saveOrder(@ModelAttribute("order") Order order,
			RedirectAttributes redirectAttrs) {
		if (order.getMaDH() == null) {
			String newId = Helper.getNewID(this.orderService.getMaxId(), 2, 2, "DH");
			order.setMaDH(newId);
		}
		this.orderService.saveOrder(order);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		return "redirect:/admin/order";
	}
	
	@GetMapping("/admin/delete-order/{idDonHang}")
	public String deleteOrder(@PathVariable(value="idDonHang") int idDonHang,
			RedirectAttributes redirectAttrs) {
		this.orderService.removeOrderById(idDonHang);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
	    return "redirect:/admin/order";
	}
}
