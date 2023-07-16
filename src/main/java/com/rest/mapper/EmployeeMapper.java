package com.rest.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.rest.dto.EmployeeDTO;
import com.rest.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
	Employee employeeDTOToEmployee(EmployeeDTO employee);
	
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	List<EmployeeDTO> employeeListToEmployeeDTOList(List<Employee> employeeDetails);
}
