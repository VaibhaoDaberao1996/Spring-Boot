package com.shopify.main.service;

import java.util.List;

import com.shopify.main.Dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	
	void deleteUser(long userId);
	
	UserDto updateUser(UserDto user,long userId);
	
    UserDto getSingleUser(long userId);
	
    List<UserDto> getAllUsers();
		
	
}
