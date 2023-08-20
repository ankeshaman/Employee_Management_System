package com.project.organizationservices.coverter;

import com.project.organizationservices.dto.OrganizationDto;
import com.project.organizationservices.entity.Organization;

public class OrganizationConverter {

    public static Organization convertDtoToEntity(OrganizationDto organizationDto){
        return Organization.builder().id(organizationDto.getId()).organizationName(organizationDto.getOrganizationName())
                .organizationDescription(organizationDto.getOrganizationDescription())
                .organizationCode(organizationDto.getOrganizationCode())
                .createdDate(organizationDto.getCreatedDate()).build();
    }

    public static OrganizationDto convertEntityToDto(Organization organization){
        return OrganizationDto.builder().id(organization.getId()).organizationName(organization.getOrganizationName())
                .organizationDescription(organization.getOrganizationDescription())
                .organizationCode(organization.getOrganizationCode())
                .createdDate(organization.getCreatedDate()).build();
    }

}
