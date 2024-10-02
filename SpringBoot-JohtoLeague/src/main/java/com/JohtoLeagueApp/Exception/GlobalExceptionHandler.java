package com.JohtoLeagueApp.Exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> notValidHandler(MethodArgumentNotValidException valid) {
		Map<String, String> message = new HashMap<>();

		valid.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String fieldMessage = error.getDefaultMessage();
			message.put(fieldName, fieldMessage);
		});

		return new ResponseEntity<Map<String, String>>(message, HttpStatus.NOT_ACCEPTABLE);
	}

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> notFoundHandler(ResourceNotFoundException resource) {

		String message = resource.getMessage();

		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<String> handleSQLIntegrityConstraintViolationException(
			SQLIntegrityConstraintViolationException ex) {
		// You can customize the message here
		String message = "Integrity constraint violation: " + getCustomMessage(ex);
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	// Optional: Custom logic for specific cases of constraint violations
	private String getCustomMessage(SQLIntegrityConstraintViolationException ex) {
		// Example: You can check the exception message and return custom messages based
		// on it
		if (ex.getMessage().contains("Duplicate entry")) {
			return "A record with this value already exists.";
		} else if (ex.getMessage().contains("FOREIGN KEY")) {
			return "There is a related record, which prevents this operation.";
		}
		return "Database integrity violation occurred.";
	}
}
