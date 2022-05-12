package com.thgroup.fms.service;

import java.util.List;

import com.thgroup.fms.entity.Role;

public interface RoleService {
	List<Role> getAllRoles();
	Role findById(int id);
}
