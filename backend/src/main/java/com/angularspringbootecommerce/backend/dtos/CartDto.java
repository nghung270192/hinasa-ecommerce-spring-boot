package com.angularspringbootecommerce.backend.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class CartDto {
    private UUID id;
    private UUID userId;
    private BigDecimal totalPrice;
    private List<CartItemDto> cartItems;
}