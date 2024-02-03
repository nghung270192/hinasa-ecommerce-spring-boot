package com.angularspringbootecommerce.backend.dtos;

import com.angularspringbootecommerce.backend.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;


    public Product toEntity() {
        Product product = new Product();
        product.setId(id);
        product.setPrice(price);
        product.setName(name);
        product.setImgUrl(imgUrl);
        return product;
    }
}
