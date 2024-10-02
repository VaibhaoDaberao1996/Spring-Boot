package com.JohtoLeagueApp.DtoLayers;

import com.JohtoLeagueApp.Entities.Address;
import com.JohtoLeagueApp.Entities.Pokemon;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserRequest {
	
	@NotEmpty(message = "User name should not be empty")
	private String name;
	
	@NotEmpty(message = "Email address should not be empty")
	@Email(message = "Please insert valid email syntax")
	private String email;
	
	@NotEmpty(message = "Password should not be empty")
	private String password;
	
	@NotEmpty(message = "Please insert user contact")
	private String contact;
	
	@NotEmpty(message = "Please insert user Role")
	private String role;
	
	private String status;
	
	private Address address;
	
	private Pokemon pokemons;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Pokemon getPokemons() {
		return pokemons;
	}

	public void setPokemons(Pokemon pokemons) {
		this.pokemons = pokemons;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact
				+ ", role=" + role + ", address=" + address + ", pokemons=" + pokemons + "]";
	}

	
}
