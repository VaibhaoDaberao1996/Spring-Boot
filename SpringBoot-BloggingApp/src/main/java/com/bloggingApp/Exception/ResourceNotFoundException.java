package com.bloggingApp.Exception;

public class ResourceNotFoundException extends RuntimeException {

	public String resourceName;
	public String fieldName;
	public long field_id;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long field_id) {
		super(String.format("%s is not found with %s : %d",resourceName, fieldName,field_id));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.field_id = field_id;
	}
	
	
	
	
}
