package com.JohtoLeagueApp.Exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Below Instance variable controls the serialization process
	 * manually without depending on JVM ,If the current class is change
	 * according to requirement then, below UID try to compare a version 
	 * of class means it will serialize the class into new one
	 */
	private static final long serialVersionUID = 1L;
	
	private String class_name;
	
	private String field_name;
	
	private long field_value;
	
	private String stringField_value;

	public ResourceNotFoundException(String class_name, String field_name, long field_value) {
		super(String.format("%s is not found with %s : %d",class_name,field_name,field_value));
		this.class_name = class_name;
		this.field_name = field_name;
		this.field_value = field_value;
	}

	public ResourceNotFoundException(String class_name, String field_name, String stringField_value) {
		super(String.format("%s is not found with %s : %d",class_name,field_name,stringField_value));
		this.class_name = class_name;
		this.field_name = field_name;
		this.stringField_value = stringField_value;
	}
}
