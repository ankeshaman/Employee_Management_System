package com.project.employeeservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    EmployeeDto employeeDto;
    DepartmentDto departmentDto;
    OrganizationDto organizationDto;

}
