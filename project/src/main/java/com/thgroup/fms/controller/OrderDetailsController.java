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

import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;
import com.thgroup.fms.service.FurnitureService;
import com.thgroup.fms.service.OrderDetailsService;
import com.thgroup.fms.service.OrderService;

@Controller
public class OrderDetailsController {
	@Autowired
	private FurnitureService furnitureService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailsService orderDService;
	public OrderDetailsController(FurnitureService furnitureService, OrderService orderService,
			OrderDetailsService orderDService) {
		super();
		this.furnitureService = furnitureService;
		this.orderService = orderService;
		this.orderDService = orderDService;
	}
	
	@GetMapping("/admin/update-orderdetail/{idNoiThat}/{idDonHang}")
	public String updateOrderDetailPage(@PathVariable(value="idNoiThat") int idNoiThat,
			@PathVariable(value="idDonHang") int idDonHang, Model model) {
		OrderDetails orderD = this.orderDService.getByIds(idDonHang, idNoiThat);
		List<Furniture> furnituresList = this.furnitureService.getAllFurnitures();
		List<Order> ordersList = this.orderService.getAllOrders(); 
	    model.addAttribute("orderD", orderD);
	    model.addAttribute("furnituresList", furnituresList);
	    model.addAttribute("ordersList", ordersList);
	    return "admin/order/update_orderdetails";
	}
	
	@PostMapping("/admin/save-orderdetail")
	public String saveOrderDetail(@ModelAttribute("orderdetail") OrderDetails orderdetail,
			RedirectAttributes redirectAttrs) {
		this.orderDService.save(orderdetail);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		return "redirect:/admin/update-order/" + orderdetail.getDonDatHang().getIdDonHang();
	}
	
	@GetMapping("/admin/delete-orderdetail/{idNoiThat}/{idDonHang}")
	public String deleteOrderDetail(@PathVariable(value="idNoiThat") int idNoiThat,
			@PathVariable(value="idDonHang") int idDonHang,
			RedirectAttributes redirectAttrs) {
		this.orderDService.removeByIds(idDonHang, idNoiThat);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
		return "redirect:/admin/update-order/" + idDonHang;
	}
}
