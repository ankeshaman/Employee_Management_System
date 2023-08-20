package com.project.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

}
