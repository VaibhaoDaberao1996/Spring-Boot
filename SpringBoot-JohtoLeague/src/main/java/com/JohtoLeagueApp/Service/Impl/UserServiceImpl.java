package com.JohtoLeagueApp.Service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JohtoLeagueApp.DtoLayers.UserRequest;
import com.JohtoLeagueApp.Entities.Address;
import com.JohtoLeagueApp.Entities.Pokemon;
import com.JohtoLeagueApp.Entities.User;
import com.JohtoLeagueApp.Exception.ResourceNotFoundException;
import com.JohtoLeagueApp.Repository.AddressRepository;
import com.JohtoLeagueApp.Repository.PokemonRepository;
import com.JohtoLeagueApp.Repository.UserRepository;
import com.JohtoLeagueApp.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AddressRepository addRepo;

	@Autowired
	private PokemonRepository pokRepo;

	@Autowired
	private ModelMapper modelConversion;

	// Saving UserReq
	@Override
	public User saveUser(UserRequest userReq) {

		User user = modelConversion.map(userReq, User.class);
		user.setInput_date(new Date());
		user.setStatus("Active");
		// saving address
		Address saveAddress = addRepo.save(userReq.getAddress());
		// saving pokemon
		Pokemon savePokemons = pokRepo.save(userReq.getPokemons());
		//saving user 
		User saveUser = userRepo.save(user);
		
		saveUser.setAddress(saveAddress);
		saveUser.setPokemons(savePokemons);
		return saveUser;
	}

	// getting user
	@Override
	public User getUser(String email) {

		return userRepo.findByEmail(email)
					   .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
	}

	// update user
	@Override
	public User updateUser(UserRequest userReq,String email) {
		// get user from database
		User user = getUser(email);
		user.setUpdate_date(new Date());
		user.setName(userReq.getName());
		user.setEmail(userReq.getEmail());
		user.setPassword(userReq.getPassword());
		user.setContact(userReq.getContact());
		user.setRole(userReq.getRole());
		user.setStatus(userReq.getStatus());
		// updating user in DB
		User updateUser = userRepo.save(user);

		// Getting address from user
		Address address = user.getAddress();
		address.setCity(userReq.getAddress().getCity());
		address.setState(userReq.getAddress().getState());
		address.setStreet(userReq.getAddress().getStreet());
		// updating address in DB
		Address updateAddress = addRepo.save(address);

		// Getting pokemons from user
		Pokemon pokemons = user.getPokemons();
		pokemons.setName(userReq.getPokemons().getName());
		pokemons.setType(userReq.getPokemons().getType());
		// updating pokemons in DB
		Pokemon updatePokemons = pokRepo.save(pokemons);

		// Setting updated address and pokemons back to users
		updateUser.setAddress(updateAddress);
		updateUser.setPokemons(updatePokemons);

		return updateUser;
	}

	// delete user
	@Override
	public String deleteUser(String email) {

		User user = getUser(email);
		user.setStatus("Deactive");
		user.setUpdate_date(new Date());
		userRepo.save(user);
		
		return "User with email: "+email+" is deleted succesfully ";

	}

	// get all users
	@Override
	public List<User> getAllUsers() {

		List<User> users =userRepo.findAll();
		
		return users.stream().filter(e->e.getStatus().equals("Active")).toList();

	}

}
