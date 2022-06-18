package com.thgroup.fms.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.thgroup.fms.entity.Employee;
import com.thgroup.fms.entity.Role;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.EmployeeService;
import com.thgroup.fms.service.RoleService;
import com.thgroup.fms.utils.Helper;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public EmployeeController(EmployeeService employeeService, AccountService accountService) {
		super();
		this.employeeService = employeeService;
		this.accountService = accountService;
	}
	
	@GetMapping("/admin/employee")
	public String employeesListPage(Model model) {
		model.addAttribute("employeesList", this.employeeService.getAllEmployees());
		return "admin/employee/index";
	}
	
	@GetMapping("/admin/detail-employee/{idNhanVien}")
	public String furnitureDetailPage(@PathVariable(value="idNhanVien") int idNhanVien, Model model) {
		Employee employee = this.employeeService.getEmployeeById(idNhanVien);
		model.addAttribute("employee", employee);
		return "admin/employee/detail";
	}
	    
	@GetMapping("/admin/create-employee")
	public String createEmployeePage(Model model) {
		Employee employee = new Employee();
		String newId = Helper.getNewID(this.employeeService.getMaxId(), 2, 1, "NV");
		List<Role> rolesList = this.roleService.getAllRoles();
		
		employee.setMaNV(newId);
		
	    model.addAttribute("employee", employee);
	    model.addAttribute("rolesList", rolesList);
	    return "admin/employee/add_employee";
	}
	    
	@PostMapping("/admin/add-employee")
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult,
			@RequestParam("accountName") String accountName,
			@RequestParam("accountId") int accountId,
			@RequestParam("password") String password,
			@RequestParam(value = "roles") Set<Role> roles,
			RedirectAttributes redirectAttrs,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			List<Role> rolesList = this.roleService.getAllRoles();
			if (accountId == -1) {
				model.addAttribute("rolesList", rolesList);
				return "admin/employee/add_employee";
			} else {
				model.addAttribute("rolesList", rolesList);
				model.addAttribute("accountId", accountId);
				model.addAttribute("customer", employee);
				model.addAttribute("account", this.accountService.getById(accountId));
			    return "admin/employee/update_employee";
			}
		} else {
			Account account = null;
			if (accountId != -1) {
				account = this.accountService.getById(accountId);
				account.setTenTaiKhoan(accountName);
				account.setMatKhau(passwordEncoder.encode(password));
				account.setDsVT(roles);
			} else if (accountId == -1) {
				account = new Account(0, accountName, passwordEncoder.encode(password), roles);
			}
			
			Account exist_accout = this.accountService.findTopByTenTaiKhoan(accountName);
			
			if(exist_accout != null)
			{
				redirectAttrs.addFlashAttribute("alertType", "danger");
				redirectAttrs.addFlashAttribute("alertText", "Tài khoản đã tồn tại");
				return "redirect:/admin/create-employee";

			}
			else {
				this.accountService.saveAccount(account);
				if (employee.getMaNV() == null) {
					String newId = Helper.getNewID(this.employeeService.getMaxId(), 2, 1, "NV");
					employee.setMaNV(newId);
				}
				employee.setTaiKhoan(account);
				this.employeeService.saveEmployee(employee);
				redirectAttrs.addFlashAttribute("alertType", "success");
				redirectAttrs.addFlashAttribute("alertText", "Thành công");
				return "redirect:/admin/employee";
			}
		
		}
	}
	
	@PostMapping("/admin/save-employee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult,
			@RequestParam("accountName") String accountName,
			@RequestParam("accountId") int accountId,
			@RequestParam("password") String password,
			@RequestParam(value = "roles") Set<Role> roles,
			RedirectAttributes redirectAttrs,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			List<Role> rolesList = this.roleService.getAllRoles();
			if (accountId == -1) {
				model.addAttribute("rolesList", rolesList);
				return "admin/employee/add_employee";
			} else {
				model.addAttribute("rolesList", rolesList);
				model.addAttribute("accountId", accountId);
				model.addAttribute("customer", employee);
				model.addAttribute("account", this.accountService.getById(accountId));
			    return "admin/employee/update_employee";
			}
		} else {
			Account account = null;
			if (accountId != -1) {
				account = this.accountService.getById(accountId);
				account.setTenTaiKhoan(accountName);
				account.setMatKhau(passwordEncoder.encode(password));
				account.setDsVT(roles);
			} else if (accountId == -1) {
				account = new Account(0, accountName, passwordEncoder.encode(password), roles);
			}
			
			Account exist_accout = this.accountService.findTopByTenTaiKhoan(accountName);
			
			
			
		
				this.accountService.saveAccount(account);
				if (employee.getMaNV() == null) {
					String newId = Helper.getNewID(this.employeeService.getMaxId(), 2, 1, "NV");
					employee.setMaNV(newId);
				}
				employee.setTaiKhoan(account);
				this.employeeService.saveEmployee(employee);
				redirectAttrs.addFlashAttribute("alertType", "success");
				redirectAttrs.addFlashAttribute("alertText", "Thành công");
				return "redirect:/admin/employee";
			
		
		}
	}
	@GetMapping("/admin/update-employee/{idNhanVien}")
	public String updateEmployeePage(@PathVariable(value="idNhanVien") int idNhanVien, Model model) {
		Employee employee = this.employeeService.getEmployeeById(idNhanVien);
	    List<Role> rolesList = this.roleService.getAllRoles();
	    
	    model.addAttribute("accountId", employee.getTaiKhoan().getIdTaiKhoan());
		model.addAttribute("employee", employee);
		model.addAttribute("account", this.accountService.getById(employee.getTaiKhoan().getIdTaiKhoan()));
	    model.addAttribute("rolesList", rolesList);
	    return "admin/employee/update_employee";
	}
	
	@GetMapping("/admin/delete-employee/{idNhanVien}")
	public String deleteEmployee(@PathVariable(value="idNhanVien") int idNhanVien,
			RedirectAttributes redirectAttrs) {
		Employee employee = this.employeeService.getEmployeeById(idNhanVien);
		this.employeeService.removeEmployeeById(idNhanVien);
		this.accountService.removeAccountById(employee.getTaiKhoan().getIdTaiKhoan());
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
	    return "redirect:/admin/employee";
	}
}
