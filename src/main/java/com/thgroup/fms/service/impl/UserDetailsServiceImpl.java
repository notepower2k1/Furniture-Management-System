package com.thgroup.fms.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thgroup.fms.entity.Account;
import com.thgroup.fms.entity.Role;
import com.thgroup.fms.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = this.accountRepository.findByTenTaiKhoan(username);
		if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Role> roles = account.getDsVT();
		for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getTenVT()));
        }
		return new org.springframework.security.core.userdetails.User(
				account.getTenTaiKhoan(), account.getMatKhau(), grantedAuthorities);
	}

}
