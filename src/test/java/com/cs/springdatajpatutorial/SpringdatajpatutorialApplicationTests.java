package com.cs.springdatajpatutorial;

import com.cs.springdatajpatutorial.entities.Product;
import com.cs.springdatajpatutorial.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class SpringdatajpatutorialApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateProduct(){
        Product product = Product.builder()
        .sku("PROD-001")
        .title("Product 1")
        .price(BigDecimal.valueOf(100))
        .quantity(2)
        .build();

        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);
    }

    @Test
    void getProductTest(){
        productRepository.findById(1L).ifPresent(System.out::println);
    }

    @Test
    void testFindProductByTitle(){
//        List<Product> productList = productRepository.findByTitle("Product 1");
//        System.out.println(productList);

//        List<Product> productList =
//                productRepository.findBySkuContainingAndPriceBetween("arle", BigDecimal.valueOf(5), BigDecimal.valueOf(20));
//        System.out.println(productList);

        productRepository.findProductsWithPriceGreaterThan(BigDecimal.valueOf(15)).forEach(System.out::println);
    }

}
