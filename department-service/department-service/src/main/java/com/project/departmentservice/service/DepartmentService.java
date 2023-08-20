package com.project.departmentservice.service;

import com.project.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartmentByCode(String departmentCode);

}
