package com.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Integer employeeId;
	
	@NotNull
	@NotBlank
	@Pattern(regexp="^[a-zA-Z\\s]*$")
	private String employeeName;
	
	@NotNull
	@NotBlank
	@Pattern(regexp="^[789]\\d{9}$")
	private String mobileNumber;
	
	@NotNull
	@NotBlank
	private String address;
}
