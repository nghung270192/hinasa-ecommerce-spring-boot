package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
//    private BigDecimal quantityTotal;
//    private BigDecimal quantitySold;
//    private UUID catalogueId;
}
