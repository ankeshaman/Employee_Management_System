package com.project.employeeservice.service.Impl;

import com.project.employeeservice.Dto.APIResponseDto;
import com.project.employeeservice.Dto.DepartmentDto;
import com.project.employeeservice.Dto.EmployeeDto;
import com.project.employeeservice.Dto.OrganizationDto;
import com.project.employeeservice.converter.EmployeeConverter;
import com.project.employeeservice.entity.Employee;
import com.project.employeeservice.repository.EmployeeRepository;
import com.project.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    RestTemplate restTemplate;

    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeConverter.convertDtoToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeConverter.convertEntityToDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        /*Method 1 : calling api of department from employee service class using RestTemplate
        ResponseEntity<DepartmentDto> responseDto = restTemplate.getForEntity("http://localhost:8076/api/departments/"+
                        employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseDto.getBody();*/

        //Method 2 : calling api of department from employee service class using WebClient
        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8076/api/departments/"+employee.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class).block();

        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8078/api/organizations/"+employee.getOrganizationCode())
                .retrieve().bodyToMono(OrganizationDto.class).block();

        EmployeeDto employeeDto = EmployeeConverter.convertEntityToDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception) {

        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development");

        EmployeeDto employeeDto = EmployeeConverter.convertEntityToDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }

}
