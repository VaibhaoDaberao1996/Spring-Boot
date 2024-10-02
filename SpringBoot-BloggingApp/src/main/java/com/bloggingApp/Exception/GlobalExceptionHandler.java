package com.bloggingApp.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.bloggingApp.Response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/*If the reponseNotException occurs in runtime
	 * then below method is executed by exceptionHandler*/
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> notFoundExceptionHandler(ResourceNotFoundException resource){
		
		//below String collect the message from ResourceNot...
		String message=resource.getMessage();
		
		ApiResponse response = new ApiResponse(message,false);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> notValidExceptionHandler(MethodArgumentNotValidException valid){
		
		Map<String,String> response=new HashMap<>();
		
		valid.getBindingResult().getAllErrors().forEach((error)->{
					String fieldName = ((FieldError)error).getField();
					String errorMessage = error.getDefaultMessage();
					response.put(fieldName, errorMessage);
		});
		
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse> methodArgu(){
		
		String message ="Please check your URL arguments which you have passed";
		
		ApiResponse response = new ApiResponse(message,false);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
