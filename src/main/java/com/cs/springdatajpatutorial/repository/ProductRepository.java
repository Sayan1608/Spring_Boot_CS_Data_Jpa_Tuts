package com.cs.springdatajpatutorial.repository;

import com.cs.springdatajpatutorial.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBy(Sort sortBy);

    List<Product> findByOrderByPriceDesc();

    List<Product> findByTitle(String s);

    List<Product> findBySkuContainingAndPriceBetween(String sku, BigDecimal startingPrice, BigDecimal endingPrice);

    @Query("Select p from Product p where p.price > :price")
    List<Product> findProductsWithPriceGreaterThan(BigDecimal price);
}
