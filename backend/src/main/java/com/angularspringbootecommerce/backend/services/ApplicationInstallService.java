package com.angularspringbootecommerce.backend.services;

import com.angularspringbootecommerce.backend.dtos.CatalogueDto;
import com.angularspringbootecommerce.backend.dtos.ProductDto;
import com.angularspringbootecommerce.backend.exceptions.ErrorResponse;
import com.angularspringbootecommerce.backend.models.CatalogueEntity;
import com.angularspringbootecommerce.backend.models.Product;
import com.angularspringbootecommerce.backend.models.UserRole;
import com.angularspringbootecommerce.backend.repository.CatalogueRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Slf4j
@Service
@Profile("install")
public class ApplicationInstallService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    ProductService productService;

    @Autowired
    CatalogueService catalogueService;


    public void createUserRole() {
        UserRole userRole = new UserRole(UUID.randomUUID(), "USER");
        userRoleService.add(userRole);
        UserRole userRole1 = new UserRole(UUID.randomUUID(), "ADMIN");
        UserRole result = userRoleService.add(userRole1);
        log.info(result.toString());
    }

    public void createProductList() {
        ProductDto productDto = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        ProductDto productDto1 = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        ProductDto productDto2 = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        ProductDto productDto3 = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        ProductDto productDto4 = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        ProductDto productDto5 = new ProductDto(null,
                "RADAR SENSOR",
                "asdf",
                new BigDecimal(10),
                "https://www.slentech.com.au/wp-content/uploads/2018/09/25-1.png");
        productService.add(productDto.toEntity());
        productService.add(productDto1.toEntity());
        productService.add(productDto2.toEntity());
        productService.add(productDto3.toEntity());
        productService.add(productDto4.toEntity());
        productService.add(productDto5.toEntity());
    }

    public void createCatalogue() {
        CatalogueDto catalogue = new CatalogueDto(
                UUID.randomUUID(), "De Go 16 mau", "asdfasdf", "asdfasdfasd"
        );
        catalogueService.add(catalogue.toEntity());
    }


    public void performInstall() {
//        System.out.println("Installation starting");
        createUserRole();
        createProductList();
        createCatalogue();
        try {
//            System.out.println("Installation finished successfully!");
            log.info("Installation finished successfully!");
        } catch (Exception e) {
            log.error("Unexpected error during ThingsBoard installation!", e);
            ErrorResponse errorResponse = new ErrorResponse("asdfasdf");

        } finally {
            SpringApplication.exit(context);

        }
    }
}
