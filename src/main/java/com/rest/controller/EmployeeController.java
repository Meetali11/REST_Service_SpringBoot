package com.rest.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rest.dto.EmployeeDTO;
import com.rest.exception.EmployeeException;
import com.rest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/employee")
	public EmployeeDTO addEmployeee(@Valid @RequestBody EmployeeDTO employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping(value="/employee/{employeeId}")
	public EmployeeDTO updateEmployee(@PathVariable("employeeId") int employeeId, @Valid @RequestBody EmployeeDTO employee) throws EmployeeException {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@GetMapping(value="/employee")
	public List<EmployeeDTO> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value="/employee/{employeeId}")
	public EmployeeDTO getEmployeeDetailsById(@PathVariable("employeeId") int employeeId) throws EmployeeException{
		return employeeService.getEmployeeDetailsById(employeeId);
	}
	
	@DeleteMapping(value="/employee/{employeeId}")
	public String deleteEmployeeDetails(@PathVariable("employeeId") int employeeId) throws EmployeeException {
		return employeeService.deleteEmployeeDetails(employeeId);
	}
}
