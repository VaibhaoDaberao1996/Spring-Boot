package com.bloggingApp.Response;

public class ApiResponse {

	private String message;
	private boolean status;
	
	public ApiResponse() { 
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getName() {
		return message;
	}

	public void setName(String name) {
		this.message = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
