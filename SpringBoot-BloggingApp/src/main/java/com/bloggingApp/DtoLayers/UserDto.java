package com.bloggingApp.DtoLayers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {

	private long user_id;
	
	@NotEmpty
	@Size(min = 5,message = "Username must contains 5 characters")
	private String user_name;
	
	@Email(message = "Email address is not valid, please check again!")
	private String user_email;
	
	@NotEmpty
	@Size(min = 5,max = 10,message = "Password must be min of 5 char and max 10 char")
	private String user_password;
	
	@NotEmpty(message = "please tell something about yourself, its cannot be empty")
	private String user_about;

	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(long user_id, String user_name, String user_email, String user_password,
			String user_about) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_about = user_about;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_about() {
		return user_about;
	}

	public void setUser_about(String user_about) {
		this.user_about = user_about;
	}

	
	
}
