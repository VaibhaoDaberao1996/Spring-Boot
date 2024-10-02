package com.shopify.main.service.implService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.main.Dto.RoleDto;
import com.shopify.main.Exception.ResourceNotFoundException;
import com.shopify.main.entities.Role;
import com.shopify.main.repository.RoleRepository;
import com.shopify.main.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository role_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	
	@Override
	public RoleDto createRole(RoleDto role) {
		Role createRole = this.model_conversion.map(role, Role.class);
		Role savedRole = this.role_repository.save(createRole);
		return this.model_conversion.map(savedRole, RoleDto.class);
	}

	@Override
	public RoleDto updateRole(RoleDto role, int roleId) {
		Role findRole = this.role_repository.findById(roleId).orElseThrow(
				()->new ResourceNotFoundException("Role","role id ", roleId));
		findRole.setName(role.getName());
		
		Role updateRole = this.role_repository.save(findRole);
		return model_conversion.map(updateRole, RoleDto.class);
	}

	@Override
	public void deleteRole(int roleId) {
	Role role =	this.role_repository.findById(roleId).orElseThrow(
				()->new ResourceNotFoundException("Role", "role id", roleId));
		
			this.role_repository.delete(role);
	}

	@Override
	public RoleDto getSingleRole(int roleId) {
	Role role =	this.role_repository.findById(roleId).orElseThrow(
				()->new ResourceNotFoundException("Role", "role id", roleId));
		
		return model_conversion.map(role, RoleDto.class);
	}

	@Override
	public List<RoleDto> getAllRole() {
		List<Role> roles = this.role_repository.findAll();
			
		List<RoleDto> dtoRoles = roles.stream().map(role->this.model_conversion.map(role, RoleDto.class)).toList();
		
		return dtoRoles;
	}

}
