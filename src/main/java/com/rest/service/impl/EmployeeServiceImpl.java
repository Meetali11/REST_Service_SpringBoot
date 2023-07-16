package com.rest.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.dto.EmployeeDTO;
import com.rest.entity.Employee;
import com.rest.exception.EmployeeException;
import com.rest.mapper.EmployeeMapper;
import com.rest.repository.EmployeeRepository;
import com.rest.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employee) {
		
		Employee employeeDetails = employeeRepository.save(employeeMapper.employeeDTOToEmployee(employee));
		log.info("Employee Details: "+ employeeDetails);
		return employeeMapper.employeeToEmployeeDTO(employeeDetails);
	}

	@Override
	public EmployeeDTO updateEmployee(Integer employeeId, EmployeeDTO employee) throws EmployeeException {
		
		Employee employeeData = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new EmployeeException("Employee not found"));
		
		Employee employeeDetails = employeeMapper.employeeDTOToEmployee(employee);
		
		employeeData.setEmployeeName(employeeDetails.getEmployeeName());
		employeeData.setMobileNumber(employeeDetails.getMobileNumber());
		employeeData.setAddress(employeeDetails.getAddress());
		
		Employee updatedEmployeeDetails = employeeRepository.save(employeeData);
		log.info("Employee Details: "+ updatedEmployeeDetails);
		return employeeMapper.employeeToEmployeeDTO(updatedEmployeeDetails);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> employeesData = employeeRepository.findAll();
		List<EmployeeDTO> employeesDetail = null;
		if(!employeesData.isEmpty()) 
			employeesDetail = employeeMapper.employeeListToEmployeeDTOList(employeesData);
		log.info("Employee Details: "+ employeesDetail);
		return employeesDetail;
	}

	@Override
	public EmployeeDTO getEmployeeDetailsById(Integer employeeId) throws EmployeeException {
		
		Employee employeeData = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new EmployeeException("Employee not found"));
		log.info("Employee Details: "+ employeeData);
		return employeeMapper.employeeToEmployeeDTO(employeeData);
	}

	@Override
	public String deleteEmployeeDetails(Integer employeeId) throws EmployeeException {
		
		String msg = null;
		Employee employeeData = employeeRepository.findById(employeeId)
				.orElseThrow(()-> new EmployeeException("Employee not found"));
		employeeRepository.deleteById(employeeData.getEmployeeId());
		Optional<Employee> employeeDetail = employeeRepository.findById(employeeId);
		if(employeeDetail.isEmpty())
			msg = "Employee Details Deleted Successfully!!";
		return msg;
	}

}
