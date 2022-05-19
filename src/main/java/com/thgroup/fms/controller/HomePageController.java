package com.thgroup.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Category;
import com.thgroup.fms.entity.Customer;
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.entity.Furniture;
import com.thgroup.fms.entity.Order;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.CategoryService;
import com.thgroup.fms.service.CustomerService;
import com.thgroup.fms.service.EmployeeService;
import com.thgroup.fms.service.FurnitureService;
import com.thgroup.fms.service.OrderService;
import com.thgroup.fms.service.ShoppingCartService;
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
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(value = {"/", "/home"})
	public String homePage(Model model) {
		List<Category> categories = this.categoryService.getAllCategories();
		int itemCount = 0;
		if (cartService.getCount() > 0){
			itemCount = cartService.getCount();
		}
		model.addAttribute("furnituresList", this.furnitureService.getAllFurnitures());
		model.addAttribute("categoriesList", categories);
		model.addAttribute("cartItem",cartService.getAllItem());
		model.addAttribute("itemTotal",cartService.getTotal());
		model.addAttribute("itemCount",itemCount);
		
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
	@GetMapping("/order-history")
	public String orderHistory(Model model) {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);
		}
		if (account.getDsVT().size() == 1) {
			Customer customer = customerService.getByAccount(account);	
			model.addAttribute("phoneNumber",customer.getSdt());


		} else if (account.getDsVT().size() > 1) {
			Employee employee = employeeService.getByAccount(account);	
			model.addAttribute("phoneNumber",employee.getSdt());

		}
		List<Order> orderlist = this.orderService.findOrder(account.getIdTaiKhoan());	
		model.addAttribute("orderList",orderlist);
		
		return "user/home/order_history";
	}
	
	
	@GetMapping("/account")
	public String account(Model model) {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);
		}
		if (account.getDsVT().size() == 1) {
			Customer customer = customerService.getByAccount(account);	
			model.addAttribute("user", customer);
		} else if (account.getDsVT().size() > 1) {
			Employee employee = employeeService.getByAccount(account);	
			model.addAttribute("user", employee);
		}
		
		return "user/account/account";
		
	}
	
	@GetMapping("/account/update-info")
	public String updateInfoPage(Model model) {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);
		}
		if (account.getDsVT().size() == 1) {
			Customer customer = customerService.getByAccount(account);	
			model.addAttribute("user", customer);
			model.addAttribute("isCustomer", true);
		} else if (account.getDsVT().size() > 1) {
			Employee employee = employeeService.getByAccount(account);	
			model.addAttribute("user", employee);
			model.addAttribute("isCustomer", false);
		}
		return "user/account/update_info";
	}
	
	@PostMapping("/account/save-info")
	public String saveInfo(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
			@RequestParam("phone") String phone,
			@RequestParam("isCustomer") boolean isCustomer) {
		
		if (isCustomer == true) {
			Customer customer = this.customerService.getCustomerById(id);
			customer.setHoTen(name);
			customer.setDiaChi(address);
			customer.setSdt(phone);
			customer.setEmail(email);
			this.customerService.saveCustomer(customer);
		} else {
			Employee employee = this.employeeService.getEmployeeById(id);
			employee.setHoTen(name);
			employee.setDiaChi(address);
			employee.setSdt(phone);
			employee.setEmail(email);
			this.employeeService.saveEmployee(employee);
		}
		
		return "redirect:/account";
	}

	@GetMapping("/account/update-account")
	public String updateAccountPage(Model model) {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    account = accountService.getByUsername(currentUserName);
		}
		
		model.addAttribute("account", account);
		model.addAttribute("accountId", account.getIdTaiKhoan());
		return "user/account/update_account";
	}
	@PostMapping("/account/update-account")
	public String updateAccount(@RequestParam("accountId") int accountId,		
			@RequestParam("password") String password) {
		
		Account account = this.accountService.getById(accountId);
		account.setMatKhau(passwordEncoder.encode(password));
		this.accountService.saveAccount(account);
		
		return "redirect:/logout";
	}
	@GetMapping("/about")
	public String aboutPage(Model model) {
		List<Category> categories = this.categoryService.getAllCategories();
		model.addAttribute("categoriesList", categories);

		return "user/home/about";
	}
	
	@GetMapping("/contact")
	public String contactPage(Model model) {
		List<Category> categories = this.categoryService.getAllCategories();
		model.addAttribute("categoriesList", categories);
		return "user/home/contact";
	}
	
	@GetMapping("/category-page/{idloai}")
	public String categoryPage(@PathVariable(value="idloai") int idloai, Model model) {
	    List<Category> categories = this.categoryService.getAllCategories();
		model.addAttribute("furnituresList", this.furnitureService.searchid_loai(idloai));
	    model.addAttribute("categoriesList", categories);
		return "user/home/categoryPage";
	}
	
	@GetMapping("/search-page")
	public String searchPage(String tenNT, Model model) {
	    List<Category> categories = this.categoryService.getAllCategories();
	    model.addAttribute("categoriesList", categories);

	    List<Furniture> dsSP = this.furnitureService.findbyTenNT(tenNT);
	    if (dsSP.size()!=0) {
			model.addAttribute("furnituresList", dsSP);
			model.addAttribute("searchtext",tenNT);
			model.addAttribute("totalItem",dsSP.size());
			return "user/home/searchpage";
	    }
	    else {
			return "user/home/product-not-found";
	    }
	}
}
