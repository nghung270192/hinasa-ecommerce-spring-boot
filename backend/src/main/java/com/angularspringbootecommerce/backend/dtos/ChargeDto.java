package com.angularspringbootecommerce.backend.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ChargeDto {
    private UUID id;
    private Long amount;
    private String currency;
    private String status;

    public ChargeDto(UUID id, Long amount, String currency, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }
}
