package com.shopify.main.response;

public class ApiResponse {

	public String message;
	
	public boolean status;

	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	
}
