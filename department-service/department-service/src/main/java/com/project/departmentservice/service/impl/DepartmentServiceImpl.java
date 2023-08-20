package com.project.departmentservice.service.impl;

import com.project.departmentservice.converter.DepartmentConverter;
import com.project.departmentservice.dto.DepartmentDto;
import com.project.departmentservice.entity.Department;
import com.project.departmentservice.repository.DepartmentRepository;
import com.project.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentConverter.convertDtoToEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentConverter.convertEntityToDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentConverter.convertEntityToDto(department);
        return departmentDto;
    }

}
