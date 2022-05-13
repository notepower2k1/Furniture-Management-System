package com.thgroup.fms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Role;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.RoleService;
import com.thgroup.fms.utils.Helper;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
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
	    List<Account> accountsList = this.accountService.getAllAccounts();
	    List<Role> rolesList = this.roleService.getAllRoles();
	    
	    String newId = Helper.getNewID(this.customerService.getMaxId(), 2, 1, "KH");
	    customer.setMaKH(newId);
	    
	    model.addAttribute("accountsList", accountsList);
	    model.addAttribute("rolesList", rolesList);
	    model.addAttribute("customer", customer);
	    return "admin/customer/add_customer";
	}
	    
	@PostMapping("/admin/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, 
			@RequestParam("accountName") String accountName,
			@RequestParam("accountId") int accountId,
			@RequestParam("password") String password,
			@RequestParam(value="roles", required=false) Set<Role> roles,
			RedirectAttributes redirectAttrs) {
		
		Account account = null;
		if (accountId != -1 && roles == null) {
			account = this.accountService.getById(accountId);
			account.setTenTaiKhoan(accountName);
			account.setMatKhau(passwordEncoder.encode(password));
			account.setDsVT(roles);
		} else {
			account = new Account(0, accountName, passwordEncoder.encode(password), customer.getTaiKhoan().getDsVT());
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
		List<Account> accountsList = this.accountService.getAllAccounts();
		List<Role> rolesList = this.roleService.getAllRoles();
	    
	    model.addAttribute("rolesList", rolesList);
	    model.addAttribute("accountsList", accountsList);
		model.addAttribute("customer", customer);
	    return "admin/customer/update_Customer";
	}
	
	@GetMapping("/admin/delete-customer/{idKhachHang}")
	public String deleteCustomer(@PathVariable(value="idKhachHang") int idKhachHang, 
			RedirectAttributes redirectAttrs) {
		this.customerService.removeCustomerById(idKhachHang);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
	    return "redirect:/admin/customer";
	}
}
