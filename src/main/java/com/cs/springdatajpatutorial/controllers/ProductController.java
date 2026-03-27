package com.cs.springdatajpatutorial.controllers;

import com.cs.springdatajpatutorial.entities.Product;
import com.cs.springdatajpatutorial.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/products")
    public List<Product> findByOrderByPriceDesc(){
        return productRepository.findByOrderByPriceDesc();
    }
}
