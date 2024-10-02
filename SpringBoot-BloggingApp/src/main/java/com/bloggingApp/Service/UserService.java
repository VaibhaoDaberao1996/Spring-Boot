package com.bloggingApp.Service;

import java.util.List;

import com.bloggingApp.DtoLayers.UserDto;

public interface UserService {

	public UserDto createUser(UserDto userDto);
	
	public UserDto updateUser(UserDto userDto,long userDto_id);
	
	public UserDto get_SingleUser(long userDto_id);
	
	public List<UserDto> get_AllUser();
	
	public void deleteUser(long userDto_id);
}
