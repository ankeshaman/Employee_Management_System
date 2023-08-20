package com.project.employeeservice.converter;

import com.project.employeeservice.Dto.EmployeeDto;
import com.project.employeeservice.entity.Employee;

public class EmployeeConverter {

    public static Employee convertDtoToEntity(EmployeeDto employeeDto){
        return Employee.builder().id(employeeDto.getId()).firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName()).email(employeeDto.getEmail())
                .organizationCode(employeeDto.getOrganizationCode())
                .departmentCode(employeeDto.getDepartmentCode()).build();
    }

    public static EmployeeDto convertEntityToDto(Employee employee){
        return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName())
                          .lastName(employee.getLastName()).email(employee.getEmail())
                          .organizationCode((employee.getOrganizationCode()))
                          .departmentCode(employee.getDepartmentCode()).build();
    }

}
