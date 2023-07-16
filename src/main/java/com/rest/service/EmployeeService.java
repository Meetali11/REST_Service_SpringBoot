package com.rest.service;

import java.util.List;
import com.rest.dto.EmployeeDTO;
import com.rest.exception.EmployeeException;

public interface EmployeeService {
	
	public EmployeeDTO addEmployee(EmployeeDTO employee);

	public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employee) throws EmployeeException;

	public List<EmployeeDTO> getAllEmployees();

	public EmployeeDTO getEmployeeDetailsById(Integer employeeId) throws EmployeeException;

	public String deleteEmployeeDetails(Integer employeeId) throws EmployeeException;

}
