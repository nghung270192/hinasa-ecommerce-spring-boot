package com.angularspringbootecommerce.backend.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CartItemDto {
    private UUID productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;
    private ProductDto product;
}