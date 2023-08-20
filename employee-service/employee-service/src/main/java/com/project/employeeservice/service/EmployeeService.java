package com.project.employeeservice.service;

import com.project.employeeservice.Dto.APIResponseDto;
import com.project.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public APIResponseDto getEmployeeById(Long employeeId);

}
