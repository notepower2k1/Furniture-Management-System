package com.thgroup.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Category;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CategoryService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.FurnitureService;
import com.thgroup.fms.service.OrderService;
import com.thgroup.fms.service.ShoppingCartService;
import com.thgroup.fms.utils.Helper;

@Controller
public class HomePageController {

	@Autowired
	private FurnitureService furnitureService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShoppingCartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = {"/", "/home"})
	public String homePage(Model model) {
		List<Category> categories = this.categoryService.getAllCategories();
		int ItemCount = 0;
		if (cartService.getCount() > 0){
			ItemCount = cartService.getCount();
		}
		model.addAttribute("furnituresList", this.furnitureService.getAllFurnitures());
		model.addAttribute("categoriesList", categories);
		model.addAttribute("cartItem",cartService.getAllItem());
		model.addAttribute("ItemTotal",cartService.getTotal());
		model.addAttribute("ItemCount",ItemCount);
		
		return "user/home/homepage";
	}
	
	
	@GetMapping("/detail-furniture/{idNoiThat}")
	public String furnitureDetailPage(@PathVariable(value="idNoiThat") int idNoiThat, Model model) {
		Furniture furniture = this.furnitureService.getFurnitureById(idNoiThat);
		
		float Original_Price = furniture.getDonGia();
		float khuyenmai = furniture.getKhuyenMai().getGiaTri();  
		float New_Price = Original_Price * (1 - khuyenmai);
		float save_money = Original_Price - New_Price;
		
		String img_zom = furniture.getHinhAnh();
		List<Category> categories = this.categoryService.getAllCategories();
		model.addAttribute("furniture", furniture);
		model.addAttribute("categoriesList", categories);
		model.addAttribute("save_money",save_money);
		model.addAttribute("new_price",New_Price);
		model.addAttribute("img_zom",img_zom);
		model.addAttribute("cartItem",cartService.getAllItem());
		model.addAttribute("ItemTotal",cartService.getTotal());
		model.addAttribute("ItemCount",cartService.getCount());
		
		return "user/detailFurniture";
	}
	@GetMapping("/orderHistory")
	public String orderHistory(Model model) {
		int id_taikhoan = 0;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    id_taikhoan = accountService.findidtai_khoan(currentUserName);
		}
		
		Customer current = customerService.findCustomer(id_taikhoan);	
		List<Order> orderlist = this.orderService.findOrder(current.getIdKhachHang());			
		model.addAttribute("orderList",orderlist);
		return "user/home/OrderHistory";
	}
	
	
	@GetMapping("/account")
	public String account(Model model) {
		int id_taikhoan = 0;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    id_taikhoan = accountService.findidtai_khoan(currentUserName);
		    model.addAttribute("account",currentUserName);
		}
		
		Customer current = customerService.findCustomer(id_taikhoan);	
		
		
		model.addAttribute("userInfo",current);
		return "user/home/account";
		
	
	}
	
	
	
	@GetMapping("/account/update/{idKhachHang}")
	public String accountUpdate(@PathVariable(value="idKhachHang") int idKhachHang, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    model.addAttribute("account",currentUserName);
		}
		Customer customer = this.customerService.getCustomerById(idKhachHang);
		
		model.addAttribute("customer", customer);
		return "user/home/accountUpdate";
	}
	@PostMapping("/account/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttrs) {
		
		
		if (customer.getMaKH() == null) {
			String newId = Helper.getNewID(this.customerService.getMaxId(), 2, 1, "KH");
		    customer.setMaKH(newId);
		}
		this.customerService.saveCustomer(customer);
		
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		return "redirect:/account";
	}
	
}
