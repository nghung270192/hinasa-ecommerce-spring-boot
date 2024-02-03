package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.models.Product;
import com.angularspringbootecommerce.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(UUID productId) {
        return productRepository.findById(productId);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }
}
