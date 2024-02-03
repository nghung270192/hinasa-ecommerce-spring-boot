package com.angularspringbootecommerce.backend.dtos;

import com.angularspringbootecommerce.backend.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class UserLoginDto {

    @Setter
    private UUID id;
    private User user;
    private String jwt;

    public UserLoginDto() {
        super();
    }

    public UserLoginDto(UUID id, User user, String jwt) {
        this.id = id;
        this.user = user;
        this.jwt = jwt;
    }

}