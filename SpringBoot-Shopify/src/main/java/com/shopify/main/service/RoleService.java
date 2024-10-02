package com.shopify.main.service;

import java.util.List;

import com.shopify.main.Dto.RoleDto;

public interface RoleService {

	RoleDto createRole(RoleDto role);
	
	RoleDto updateRole(RoleDto role,int roleId);
	
	void deleteRole(int roleId);
	
	RoleDto getSingleRole(int roleId);
	
	List<RoleDto> getAllRole();
}
