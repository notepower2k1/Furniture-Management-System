package com.thgroup.fms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Role;
import com.thgroup.fms.service.AccountService;
import com.thgroup.fms.service.RoleService;

@Controller
public class SecurityController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("/admin/login") 
    public String adminLoginPage(RedirectAttributes redirectAttrs) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        	return "admin/security/login";
        }
        redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Đăng nhập thành công");
        return "redirect:/admin";
    }
	@PostMapping("/admin/logout")
    public String adminLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/admin/login";
    }
	@GetMapping("/admin/error") 
    public String adminErrorPage() {
        return "admin/security/error";
    }
	
	@GetMapping("/admin/create-account")
	public String createAccountPage(Model model) {
		List<Role> rolesList = this.roleService.getAllRoles();
		Account account = new Account();
		model.addAttribute("rolesList", rolesList);
		model.addAttribute("account", account);
		return "admin/security/add_account";
	}
	@PostMapping("/admin/save-account")
	public String saveAccount(@ModelAttribute("account") Account account,
			RedirectAttributes redirectAttrs) {
		account.setMatKhau(passwordEncoder.encode(account.getMatKhau()));
		this.accountService.saveAccount(account);
		redirectAttrs.addFlashAttribute("alertType", "success");
		redirectAttrs.addFlashAttribute("alertText", "Thành công");
		return "redirect:/admin";
	}
	
	@GetMapping("/login")
	public String userLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        	return "user/security/login";
        }
        return "redirect:/";
	}
	@GetMapping("/register")
	public String userRegisterPage() {
		
		return "";
	}
	@PostMapping("/logout")
    public String userLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
    }
	
}


