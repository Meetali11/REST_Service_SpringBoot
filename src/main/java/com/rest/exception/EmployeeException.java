package com.rest.exception;

public class EmployeeException extends Exception{
		
  private String message;
  public EmployeeException() {
	this.message="";
  }

  public EmployeeException(String message) {
	this.message=message;
  }

  @Override
  public String toString() {
	return "Employee Not Found "+ this.message;
  }
		
}


