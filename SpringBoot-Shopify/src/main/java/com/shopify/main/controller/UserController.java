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

import com.shopify.main.Dto.UserDto;
import com.shopify.main.response.ApiResponse;
import com.shopify.main.service.UserService;

@RestController
@RequestMapping("/shopify/apis")
public class UserController {
	
	@Autowired
	private UserService user_service;
	
	//Post
	@PostMapping("/users")
	public ResponseEntity<UserDto> add_User(@RequestBody UserDto user){
		
		UserDto addUser = this.user_service.createUser(user);
		
		return new ResponseEntity<UserDto>(addUser,HttpStatus.CREATED);
	}
	
	//Put
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserDto> update_User(@RequestBody UserDto user,
											   @PathVariable long userId){
		
		UserDto updateUser = this.user_service.updateUser(user, userId);
		
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ApiResponse> delete_User(@PathVariable long userId){
		
		this.user_service.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User with id "+userId+" deleted successfully", true),
											       HttpStatus.OK);
	}
	
	//Get
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> showSingleUser(@PathVariable long userId){
		
		UserDto showUser = this.user_service.getSingleUser(userId);
		
		return new ResponseEntity<UserDto>(showUser,HttpStatus.FOUND);
	}
	
	
	//Get all
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> showSingleUser(){
		
		List<UserDto> showAllUsers = this.user_service.getAllUsers();
		
		return new ResponseEntity<List<UserDto>>(showAllUsers,HttpStatus.FOUND);
	}
	
}
