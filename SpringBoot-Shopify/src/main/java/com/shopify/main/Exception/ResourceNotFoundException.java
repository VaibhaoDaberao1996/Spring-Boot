package com.shopify.main.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public String entity;
	
	public String FieldId;
	
	public long fieldValue;

	public ResourceNotFoundException(String entity, String fieldId, long fieldValue) {
		super(String.format("%s is not found with %s : %d",entity,fieldId,fieldValue));
		
		this.entity = entity;
		this.FieldId = fieldId;
		this.fieldValue = fieldValue;
	}

	
	
	
}
