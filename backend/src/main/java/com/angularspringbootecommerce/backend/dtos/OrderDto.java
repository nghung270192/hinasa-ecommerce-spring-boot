package com.angularspringbootecommerce.backend.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    private String dateCreated;
    private BigDecimal total;
}