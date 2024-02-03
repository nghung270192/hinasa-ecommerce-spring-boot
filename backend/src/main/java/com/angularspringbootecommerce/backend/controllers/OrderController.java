package com.angularspringbootecommerce.backend.controllers;

import com.angularspringbootecommerce.backend.dtos.CartDto;
import com.angularspringbootecommerce.backend.dtos.OrderDto;
import com.angularspringbootecommerce.backend.dtos.PaymentDto;
import com.angularspringbootecommerce.backend.models.Order;
import com.angularspringbootecommerce.backend.services.CartService;
import com.angularspringbootecommerce.backend.services.OrderService;
import com.angularspringbootecommerce.backend.services.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    private final PaymentService paymentService;

    @GetMapping("/{userId}")
    public List<OrderDto> getOrdersByUserId(@PathVariable UUID userId, Authentication authentication) {
        return orderService.getOrdersByUserId(userId, authentication);
    }

    @PostMapping("/{userId}/checkout")
    public ResponseEntity<PaymentDto> checkout(@PathVariable String userId, Authentication authentication) throws StripeException {
        CartDto cart = cartService.getCartByUserId(UUID.fromString(userId));
        BigDecimal totalPrice = cart.getTotalPrice();
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(totalPrice);

        Order createdOrder = orderService.createOrderFromCart(cart, UUID.fromString(userId), authentication);

        cartService.clearCart(UUID.fromString(userId));

        PaymentDto paymentDto = new PaymentDto(paymentIntent.getClientSecret(), totalPrice, "usd", createdOrder.getId());

        return ResponseEntity.ok().body(paymentDto);
    }
}
