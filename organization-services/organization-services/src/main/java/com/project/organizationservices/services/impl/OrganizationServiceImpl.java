package com.project.organizationservices.services.impl;

import com.project.organizationservices.coverter.OrganizationConverter;
import com.project.organizationservices.dto.OrganizationDto;
import com.project.organizationservices.entity.Organization;
import com.project.organizationservices.repository.OrganizationRepository;
import com.project.organizationservices.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationConverter.convertDtoToEntity(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationConverter.convertEntityToDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto = OrganizationConverter.convertEntityToDto(organization);
        return organizationDto;
    }
}
