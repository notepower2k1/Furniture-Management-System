package com.thgroup.fms.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.entity.Role;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.OrderService;
import com.thgroup.fms.service.RoleService;
import com.thgroup.fms.utils.Helper;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public CustomerController(CustomerService customerService, AccountService accountService) {
		super();
		this.customerService = customerService;
		this.accountService = accountService;
	}

	@GetMapping("/admin/customer")
	public String customersListPage(Model model) {
		model.addAttribute("customersList", this.customerService.getAllCustomers());
		return "admin/customer/index";
	}
	
	@GetMapping("/admin/detail-customer/{idKhachHang}")
	public String furnitureDetailPage(@PathVariable(value="idKhachHang") int idKhachHang, Model model) {
		Customer customer = this.customerService.getCustomerById(idKhachHang);
		model.addAttribute("customer", customer);
		return "admin/customer/detail";
	}
	    
	@GetMapping("/admin/create-customer")
	public String createCustomerPage(Model model) {
	    Customer customer = new Customer();
	    
	    String newId = Helper.getNewID(this.customerService.getMaxId(), 2, 1, "KH");
	    customer.setMaKH(newId);
	    
	    model.addAttribute("customer", customer);
	    return "admin/customer/add_customer";
	}
	    
	@PostMapping("/admin/save-customer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult,
			@RequestParam("accountName") String accountName,
			@RequestParam("password") String password,
			@RequestParam("accountId") int accountId,
			RedirectAttributes redirectAttrs,
			Model model) {
		if (bindingResult.hasErrors()) {
			if (accountId == -1) {
				return "admin/customer/add_customer";
			} else {
				model.addAttribute("accountId", accountId);
				model.addAttribute("customer", customer);
				model.addAttribute("account", this.accountService.getById(accountId));
			    return "admin/customer/update_customer";
			}
		}
		Account account = null;
		if (accountId != -1) {
			Set<Role> roles = new HashSet<>();
			roles.add(this.roleService.getById(4));
			account = this.accountService.getById(accountId);
			account.setTenTaiKhoan(accountName);
			account.setMatKhau(passwordEncoder.encode(password));
			account.setDsVT(roles);
		} else {
			Set<Role> roles = new HashSet<>();
			roles.add(this.roleService.getById(4));
			account = new Account(0, accountName, passwordEncoder.encode(password), roles);
		}
		this.accountService.saveAccount(account);
		
		if (customer.getMaKH() == null) {
			String newId = Helper.getNewID(this.customerService.getMaxId(), 2, 1, "KH");
		    customer.setMaKH(newId);
		}
		customer.setTaiKhoan(account);
		this.customerService.saveCustomer(customer);
		
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		return "redirect:/admin/customer";
	}
	
	@GetMapping("/admin/update-customer/{idKhachHang}")
	public String updateCustomerPage(@PathVariable(value="idKhachHang") int idKhachHang, Model model) {
		Customer customer = this.customerService.getCustomerById(idKhachHang);
	    
		model.addAttribute("accountId", customer.getTaiKhoan().getIdTaiKhoan());
		model.addAttribute("customer", customer);
		model.addAttribute("account", this.accountService.getById(customer.getTaiKhoan().getIdTaiKhoan()));
	    return "admin/customer/update_customer";
	}
	
	@GetMapping("/admin/delete-customer/{idKhachHang}")
	public String deleteCustomer(@PathVariable(value="idKhachHang") int idKhachHang, 
			RedirectAttributes redirectAttrs) {
		Customer customer = this.customerService.getCustomerById(idKhachHang);
		this.customerService.removeCustomerById(idKhachHang);
		this.accountService.removeAccountById(customer.getTaiKhoan().getIdTaiKhoan());
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
	    return "redirect:/admin/customer";
	}
}
