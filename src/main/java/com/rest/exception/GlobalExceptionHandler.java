package com.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice  // to handle exceptions globally
public class GlobalExceptionHandler{
	
	//EmployeeNotFoundException (custom exception) 
	@ExceptionHandler(value = { EmployeeException.class })
	public ResponseEntity<?> handleEmployeeException(EmployeeException ex, WebRequest request) {
	ErrorDetails errorDetails = new ErrorDetails("Empolyee Not Found", "Employee not exist");
	return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Global Exception
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
	ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
	return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
