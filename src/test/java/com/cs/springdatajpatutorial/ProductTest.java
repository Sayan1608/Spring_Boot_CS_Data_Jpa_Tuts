package com.cs.springdatajpatutorial;

import com.cs.springdatajpatutorial.dto.CProductInfo;
import com.cs.springdatajpatutorial.dto.IProductInfo;
import com.cs.springdatajpatutorial.dto.MinMaxStats;
import com.cs.springdatajpatutorial.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProductInfoProjection(){
//        List<IProductInfo> productInfo = productRepository.getProductInfo();
//
//        for (IProductInfo product : productInfo){
//            System.out.println(product.getTitle() + " - " + product.getPrice());
//        }

        List<CProductInfo> productInfo = productRepository.getProductInfoConcrete();

        productInfo.forEach(System.out::println);

        MinMaxStats minMaxPrice = productRepository.getMinMaxPrice();
        System.out.println("Min Price: " + minMaxPrice);
    }
}
