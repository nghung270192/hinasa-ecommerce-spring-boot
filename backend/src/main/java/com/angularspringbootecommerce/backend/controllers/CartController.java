package com.angularspringbootecommerce.backend.controllers;

import com.angularspringbootecommerce.backend.dtos.CartDto;
import com.angularspringbootecommerce.backend.exceptions.AppException;
import com.angularspringbootecommerce.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getCartByUserId(@PathVariable String userId) {
        Map<String, Object> response = new HashMap<>();
        CartDto cartDto = cartService.getCartByUserId(UUID.fromString(userId));
        if (cartDto != null) {
            response.put("cart", cartDto);
            response.put("numberOfItemsInCart", cartService.getNumberOfItemsInCart(UUID.fromString(userId)));
            return ResponseEntity.ok().body(response);
        } else {
            throw new AppException("User's cart not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/{productId}/{quantity}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable String userId, @PathVariable String productId,
                                                 @PathVariable int quantity) {
        CartDto cartDto = cartService.addItemToCart(UUID.fromString(userId), UUID.fromString(productId), quantity);
        return ResponseEntity.ok().body(cartDto);
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable String userId, @PathVariable String productId) {
        CartDto cartDto = cartService.removeItemFromCart(UUID.fromString(userId), UUID.fromString(productId));
        return ResponseEntity.ok().body(cartDto);
    }
}
