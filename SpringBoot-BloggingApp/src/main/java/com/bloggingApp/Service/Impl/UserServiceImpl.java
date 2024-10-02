package com.bloggingApp.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.DtoLayers.UserDto;
import com.bloggingApp.Entities.User;
import com.bloggingApp.Exception.ResourceNotFoundException;
import com.bloggingApp.Repository.UserRepository;
import com.bloggingApp.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository user_repo;
	
	@Autowired
	private ModelMapper model_conversion;

	//This method is injecting userDto data into user, for use database operation
	public User dto_to_user(UserDto userDto) {
		User dtoToUser =this.model_conversion.map(userDto, User.class);
		
		/*
		 * dtoToUser.setUser_id(userDto.getUser_id());
		 * dtoToUser.setUser_name(userDto.getUser_name());
		 * dtoToUser.setUser_email(userDto.getUser_email());
		 * dtoToUser.setUser_password(userDto.getUser_password());
		 * dtoToUser.setUser_about(userDto.getUser_about());
		 */
		 
		return dtoToUser;
	}
	
	//This method is converting user data into userDto for Controller view
	public UserDto user_to_Dto(User user) {
		UserDto userToDto =this.model_conversion.map(user, UserDto.class);
		
		/*
		 * userToDto.setUser_id(user.getUser_id());
		 * userToDto.setUser_name(user.getUser_name());
		 * userToDto.setUser_email(user.getUser_email());
		 * userToDto.setUser_password(user.getUser_password());
		 * userToDto.setUser_about(user.getUser_about());
		 */
		return userToDto;
		
	}
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User createUser = this.dto_to_user(userDto);
		this.user_repo.save(createUser);
		return user_to_Dto(createUser);
	
	}

	@Override
	public UserDto updateUser(UserDto userDto, long userDto_id) {
		User user = this.user_repo.findById(userDto_id).
				orElseThrow(()->new ResourceNotFoundException("User","user_id",userDto_id));
		user.setUser_name(userDto.getUser_name());
		user.setUser_email(userDto.getUser_email());
		user.setUser_password(userDto.getUser_password());
		user.setUser_about(userDto.getUser_about());
		
		User update_user =this.user_repo.save(user);
		return user_to_Dto(update_user);
	}

	@Override
	public UserDto get_SingleUser(long userDto_id) {
		User getUser = this.user_repo.findById(userDto_id).
				orElseThrow(()->new ResourceNotFoundException("User","user_id",userDto_id));
		
		return user_to_Dto(getUser);
	}

	@Override
	public List<UserDto> get_AllUser() {
		List<User> users = this.user_repo.findAll();
		List<UserDto> usersAll = users.stream().map(user->this.user_to_Dto(user)).collect(Collectors.toList());
		return usersAll;
	}

	@Override
	public void deleteUser(long userDto_id) {
		User user =this.user_repo.findById(userDto_id).
				orElseThrow(()->new ResourceNotFoundException("USER", "USER_ID", userDto_id));
		this.user_repo.delete(user);
		
		
	}
	
}
