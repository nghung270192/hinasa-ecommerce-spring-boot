package com.angularspringbootecommerce.backend.dtos;

import com.angularspringbootecommerce.backend.models.CatalogueEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogueDto {

    private UUID id;
    private String name;
    private String iconUrl;
    private String description;


    public CatalogueEntity toEntity() {
        CatalogueEntity entity = new CatalogueEntity();
        entity.setId(id);
        entity.setDescription(description);
        entity.setIconUrl(iconUrl);
        entity.setName(name);
        return entity;
    }
}
