package com.thgroup.fms.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	    
	@PostMapping("/admin/save-employee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
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
			account = new Account(0, accountName, passwordEncoder.encode(password), employee.getTaiKhoan().getDsVT());
		}
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
	
	@GetMapping("/admin/update-employee/{idNoiThat}")
	public String updateEmployeePage(@PathVariable(value="idNoiThat") int idNoiThat, Model model) {
		Employee employee = this.employeeService.getEmployeeById(idNoiThat);
	    List<Role> rolesList = this.roleService.getAllRoles();
	    
		model.addAttribute("accountId", employee.getTaiKhoan().getIdTaiKhoan());
	    model.addAttribute("employee", employee);
	    model.addAttribute("rolesList", rolesList);
	    return "admin/employee/update_employee";
	}
	
	@GetMapping("/admin/delete-employee/{idNhanVien}")
	public String deleteEmployee(@PathVariable(value="idNhanVien") int idNhanVien,
			RedirectAttributes redirectAttrs) {
		this.employeeService.removeEmployeeById(idNhanVien);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Xóa thành công");
	    return "redirect:/admin/employee";
	}
}
