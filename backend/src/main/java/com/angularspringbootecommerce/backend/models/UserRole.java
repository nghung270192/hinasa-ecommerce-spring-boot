package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Data
@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "role_id")
    private UUID id;
    private String authority;

    public UserRole() {
        super();
    }

    public UserRole(String authority) {
        this.authority = authority;
    }

    public UserRole(UUID id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
