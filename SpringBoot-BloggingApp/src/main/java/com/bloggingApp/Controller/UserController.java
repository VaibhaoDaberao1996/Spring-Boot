package com.bloggingApp.Controller;

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

import com.bloggingApp.DtoLayers.UserDto;
import com.bloggingApp.Response.ApiResponse;
import com.bloggingApp.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService user_service;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> add_User(@Valid @RequestBody  UserDto userDto) {
		UserDto created_user=this.user_service.createUser(userDto);
	
		return new ResponseEntity<>(created_user,HttpStatus.CREATED);
	}
	
	/*path variable id should be SAME to userDto CLASS variable id 
	 * as well as URI dynamic variable id i.e. (userDto_id)*/
	@GetMapping("/users/{user_id}")
	public ResponseEntity<UserDto> show_singleUser(@PathVariable long user_id) {
		return ResponseEntity.ok(user_service.get_SingleUser(user_id));
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> show_allUser(){
		return ResponseEntity.ok(user_service.get_AllUser()) ;
	}
	
	@PutMapping("/users/{user_id}")
	public UserDto update_user(@Valid @RequestBody UserDto userDto,@PathVariable long user_id) {
		return user_service.updateUser(userDto, user_id);
	}
	
	@DeleteMapping("/users/{user_id}")
	public ResponseEntity<ApiResponse> delete_user(@PathVariable long user_id) {
		 this.user_service.deleteUser(user_id);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Succesfully",true),HttpStatus.OK);
	}
	
	
}
