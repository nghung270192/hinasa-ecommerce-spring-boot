package com.angularspringbootecommerce.backend.controllers;


import com.angularspringbootecommerce.backend.dtos.UserDto;
import com.angularspringbootecommerce.backend.models.User;
import com.angularspringbootecommerce.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId, Authentication authentication) {
        return userService.getUserById(UUID.fromString(userId), authentication);
    }

    @PutMapping("/update/{userId}")
    public User updateUserById(@PathVariable String userId, @RequestBody UserDto userDto, Authentication authentication) {
        return userService.updateUserById(UUID.fromString(userId), userDto, authentication);
    }
}
