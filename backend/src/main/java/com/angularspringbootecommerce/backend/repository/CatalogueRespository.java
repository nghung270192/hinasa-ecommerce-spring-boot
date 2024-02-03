package com.angularspringbootecommerce.backend.repository;

import com.angularspringbootecommerce.backend.models.CatalogueEntity;
import com.angularspringbootecommerce.backend.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatalogueRespository extends JpaRepository<CatalogueEntity, UUID> {
}