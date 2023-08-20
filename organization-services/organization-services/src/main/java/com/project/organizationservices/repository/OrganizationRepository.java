package com.project.organizationservices.repository;

import com.project.organizationservices.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Organization findByOrganizationCode(String organizationCode);

}
