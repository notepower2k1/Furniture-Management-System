package com.thgroup.fms.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.CartItem;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.OrderDetails;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CategoryService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.EmployeeService;
import com.thgroup.fms.service.FurnitureService;
import com.thgroup.fms.service.OrderDetailsService;
import com.thgroup.fms.service.OrderService;
import com.thgroup.fms.service.ShoppingCartService;
import com.thgroup.fms.utils.Helper;

@Controller
@RequestMapping("/shopping-cart")
public class CartController {

	@Autowired
	private FurnitureService furnitureService;
	
	@Autowired
	private ShoppingCartService cartService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrderDetailsService orderDService;
	
	@Autowired
	private AccountService accountService;
	@GetMapping("/views")
	public String viewCart(Model model) {
		model.addAttribute("categoriesList", categoryService.getAllCategories());
		model.addAttribute("cartItem", cartService.getAllItem());
		model.addAttribute("total", cartService.getTotal());
		model.addAttribute("cartItem", cartService.getAllItem());
		model.addAttribute("itemTotal", cartService.getTotal());
		model.addAttribute("itemCount", cartService.getCount());
		return "user/cart/cart";
	}
	
	@GetMapping("/empty")
	public String cartEmpty(Model model) {
		return "user/cart/cart_empty";
	}
	
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		Furniture furniture = furnitureService.getFurnitureById(id);
		if (furniture!=null) {
			CartItem item = new CartItem();
			float originalPrice = furniture.getDonGia();
			float promotionValue = furniture.getKhuyenMai().getGiaTri();  
			float newPrice = originalPrice * (1 - promotionValue);
			
			item.setProductId(furniture.getIdNoiThat());
			item.setName(furniture.getTenNT());
			item.setPrice(newPrice);
			item.setQuantity(1);
			cartService.add(item);
		}
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("/delete/{id}")
	public String removeCart(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/shopping-cart/views";
	}
	@PostMapping("/update")
	public String update(@RequestParam("id")Integer id,@RequestParam("quantity")Integer quantity) {
		cartService.update(id, quantity);
		return "redirect:/shopping-cart/views";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model) {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);  
		    
		}
		
		if (account.getDsVT().size() == 1) {
			Customer customer = customerService.getByAccount(account);	
			model.addAttribute("userInfo",customer);


		} else if (account.getDsVT().size() > 1) {
			Employee employee = employeeService.getByAccount(account);	
			model.addAttribute("userInfo",employee);
		}
		model.addAttribute("categoriesList", categoryService.getAllCategories());
		model.addAttribute("cartItem", cartService.getAllItem());
		model.addAttribute("total", cartService.getTotal());
		model.addAttribute("cartItem", cartService.getAllItem());
		model.addAttribute("itemTotal", cartService.getTotal());
		model.addAttribute("itemCount", cartService.getCount());
		return "user/cart/checkout";
	}
	
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute("order") Order order,		
			RedirectAttributes redirectAttrs, @Param("note") String note) {
		
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);
		}
		
		if (account.getDsVT().size() == 1) {
			Customer customer = customerService.getByAccount(account);	
			order.setDiaChiNhanHang(customer.getDiaChi());
			order.setKhachHang(customer);
			order.setNhanVien(employeeService.getEmployeeById(2));
		} else if (account.getDsVT().size() > 1) {
			Employee employee = employeeService.getByAccount(account);	
			order.setDiaChiNhanHang(employee.getDiaChi());
			order.setKhachHang(null);
			order.setNhanVien(employee);
		}
		
		String newId = Helper.getNewID(this.orderService.getMaxId(), 2, 2, "DH");

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		order.setMaDH(newId);
		order.setGhiChu(note);
		order.setNgayLap(sqlDate);
		order.setTinhTrang(0);
		order.setNhanVien(null);
		this.orderService.saveOrder(order);
		
		Collection<CartItem> ds = this.cartService.getAllItem();
		OrderDetails detail = new OrderDetails();
		
		detail.setDonDatHang(order);
		ds.forEach(item ->{
			
			Furniture noithat = furnitureService.getFurnitureById(item.getProductId());
			detail.setNoiThat(noithat);
			detail.setSoLuong(item.getQuantity());
			detail.setGiaMua((float) item.getPrice());
			this.orderDService.save(detail);
		});
		
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		
		this.cartService.Clear();
		return "redirect:/shopping-cart/confirm";
	}
	@GetMapping("/confirm")
	public String Confirm() {
		return "user/home/confirm";
	}
}
