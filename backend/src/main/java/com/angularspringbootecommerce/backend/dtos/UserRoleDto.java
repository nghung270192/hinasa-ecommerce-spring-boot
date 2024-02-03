package com.angularspringbootecommerce.backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    private UUID id;
    private String authority;

}
