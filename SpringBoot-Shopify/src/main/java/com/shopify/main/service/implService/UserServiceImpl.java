package com.shopify.main.service.implService;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopify.main.Dto.UserDto;
import com.shopify.main.Exception.ResourceNotFoundException;
import com.shopify.main.entities.User;
import com.shopify.main.repository.UserRepository;
import com.shopify.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private ModelMapper model_conversion;
	
	
	@Override
	public UserDto createUser(UserDto user) {
		User createUser = this.model_conversion.map(user, User.class);
		
		User saveUser = this.user_repository.save(createUser);
		
		return this.model_conversion.map(saveUser, UserDto.class);
	}

	@Override
	public void deleteUser(long userId) {
		User user =this.user_repository.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("User","userId",userId));
		
		this.user_repository.delete(user);
		
	}

	@Override
	public UserDto updateUser(UserDto user, long userId) {
		
	User findUser = this.user_repository.findById(userId).orElseThrow(
			()->new ResourceNotFoundException("User","userId", userId));
	
		findUser.setName(user.getName());
		findUser.setEmail(user.getEmail());
		findUser.setPassword(user.getPassword());
	
		User saveUser = this.user_repository.save(findUser);
		return model_conversion.map(saveUser, UserDto.class);
	}

	@Override
	public UserDto getSingleUser(long userId) {
		User user = this.user_repository.findById(userId).orElseThrow(
				()->new ResourceNotFoundException("User", "userId", userId));
		
		return model_conversion.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
	 List<User> users = this.user_repository.findAll();
	 
	 List<UserDto> usersDto = users.stream().map(user->this.model_conversion.map(user, UserDto.class)).toList();
		
	 return usersDto;
	}
	
	

}
