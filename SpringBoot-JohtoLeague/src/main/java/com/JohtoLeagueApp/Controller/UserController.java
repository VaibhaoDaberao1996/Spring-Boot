package com.JohtoLeagueApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JohtoLeagueApp.DtoLayers.UserRequest;
import com.JohtoLeagueApp.Entities.User;
import com.JohtoLeagueApp.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/johtoleague/apis")
public class UserController {

	@Autowired
	private UserService userService;
	
	//create User
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest user){
	   
		User createUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(createUser,HttpStatus.CREATED);
	}
	
	//update user
	@PatchMapping("/users/{email}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserRequest userReq,@PathVariable String email){
		
		User updateUser = userService.updateUser(userReq, email);
		
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	
	//fetch user
	@GetMapping("/users/{email}")
	public ResponseEntity<User> showUser(@PathVariable String email){
		
		User user = userService.getUser(email);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//Delete user by diabling the status.In real time application its not good practice to delete
	@PatchMapping("/users")
	public ResponseEntity<String> deleteUser(@RequestParam String email){
		
		String deleteUser = userService.deleteUser(email);
		
		return new ResponseEntity<String>(deleteUser,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> showAllUser(){
		
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	
}
