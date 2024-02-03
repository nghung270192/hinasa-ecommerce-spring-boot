package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.models.CatalogueEntity;
import com.angularspringbootecommerce.backend.models.UserRole;
import com.angularspringbootecommerce.backend.repository.CatalogueRespository;
import com.angularspringbootecommerce.backend.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService {
    @Autowired
    CatalogueRespository catalogueRespository;

    public CatalogueEntity add(CatalogueEntity catalogueEntity) {
        return catalogueRespository.save(catalogueEntity);
    }
}
