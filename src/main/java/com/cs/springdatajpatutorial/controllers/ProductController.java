package com.cs.springdatajpatutorial.controllers;

import com.cs.springdatajpatutorial.entities.Product;
import com.cs.springdatajpatutorial.repository.ProductRepository;
import org.springframework.data.domain.Sort;
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
    public List<Product> findBy(@RequestParam(name = "sortBy", required = false, defaultValue = "price")
                                                    String sortBy){
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"title","quantity"));
//        return productRepository.findBy(Sort.by(sortBy).ascending());
    }
}
