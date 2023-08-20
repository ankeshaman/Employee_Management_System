package com.project.departmentservice.converter;

import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;

public class DepartmentConverter {

    public static Department convertDtoToEntity(DepartmentDto departmentDto){
        return Department.builder().id(departmentDto.getId()).departmentName(departmentDto.getDepartmentName())
                         .departmentDescription(departmentDto.getDepartmentDescription())
                         .departmentCode(departmentDto.getDepartmentCode()).build();
    }

    public static DepartmentDto convertEntityToDto(Department department){
        return DepartmentDto.builder().id(department.getId()).departmentName(department.getDepartmentName())
                            .departmentDescription(department.getDepartmentDescription())
                            .departmentCode(department.getDepartmentCode()).build();
    }

}
