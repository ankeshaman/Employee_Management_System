package com.project.employeeservice.controller;

import com.project.employeeservice.Dto.APIResponseDto;
import com.project.employeeservice.Dto.EmployeeDto;
import com.project.employeeservice.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    //RequestBody internally contain Http message converter which convert JSON obj to Java obj
    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployees(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeServiceImpl.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    //Here we have to bind the id value coming from ui to employeeId variable ,so we have given "id" inside pathvariable
    //annotation . If we dont want to do this then replace the id inside getmapping by employeeId varibale or viceversa
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeServiceImpl.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
