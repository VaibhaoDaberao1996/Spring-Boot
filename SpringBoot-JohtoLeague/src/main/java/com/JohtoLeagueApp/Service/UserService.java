package com.JohtoLeagueApp.Service;

import java.util.List;

import com.JohtoLeagueApp.DtoLayers.UserRequest;
import com.JohtoLeagueApp.Entities.User;

public interface UserService {
	
	//Write
	public User saveUser(UserRequest user);
	
	public User updateUser(UserRequest user ,String email);
	
	//Fetch
	public String deleteUser(String email);
	
	public User getUser(String email);
	
	public List<User> getAllUsers();

	
}
