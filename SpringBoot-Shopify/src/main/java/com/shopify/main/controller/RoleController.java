package com.shopify.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopify.main.Dto.RoleDto;
import com.shopify.main.response.ApiResponse;
import com.shopify.main.service.RoleService;

@RestController
@RequestMapping("/shopify/admin/apis")
public class RoleController {

	@Autowired
	private RoleService role_service;
	
	//post
	@PostMapping("/roles")
	public ResponseEntity<RoleDto> addRole(@RequestBody RoleDto role){
		
		RoleDto addRole = this.role_service.createRole(role);
		
		return new ResponseEntity<RoleDto>(addRole,HttpStatus.CREATED);
	}
	
	//put
	@PutMapping("/roles/{roleId}")
	public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto role,
											  @PathVariable int roleId	){
		
		RoleDto updateRole = this.role_service.updateRole(role, roleId);
		
		return new ResponseEntity<RoleDto>(updateRole,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/roles/{roleId}")
	public ResponseEntity<ApiResponse> deleteRole(@PathVariable int roleId	){
												  
		this.role_service.getSingleRole(roleId);
			
		return new ResponseEntity<ApiResponse>(new ApiResponse("Role with id "+roleId+" deleted succesfully", true),
												HttpStatus.OK);
	}
	
	//Get
	@GetMapping("/roles/{roleId}")
	public ResponseEntity<RoleDto> showSingleRole(@PathVariable int roleId	){
											  
		
		RoleDto showRole = this.role_service.getSingleRole(roleId);
		
		return new ResponseEntity<RoleDto>(showRole,HttpStatus.FOUND);
	}
	
	//Get All
	@GetMapping("/roles")
	public ResponseEntity<List<RoleDto>> showAllRole(){
			
		List<RoleDto> showAllRole = this.role_service.getAllRole();
			
		return new ResponseEntity<List<RoleDto>>(showAllRole,HttpStatus.FOUND);
	}
}
