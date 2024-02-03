package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.dtos.UserRoleDto;
import com.angularspringbootecommerce.backend.models.UserRole;
import com.angularspringbootecommerce.backend.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public UserRole add(UserRole userRole) {
        System.out.println(userRole);
        return userRoleRepository.save(userRole);
    }
}
