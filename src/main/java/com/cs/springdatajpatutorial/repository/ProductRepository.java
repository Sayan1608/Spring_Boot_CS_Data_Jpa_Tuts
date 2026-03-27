package com.cs.springdatajpatutorial.repository;

import com.cs.springdatajpatutorial.dto.CProductInfo;
import com.cs.springdatajpatutorial.dto.IProductInfo;
import com.cs.springdatajpatutorial.dto.MinMaxStats;
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

    @Query("Select p.id as id, p.title as title, p.price as price from Product p")
    List<IProductInfo> getProductInfo();

    @Query("Select new com.cs.springdatajpatutorial.dto.CProductInfo(p.id, p.title,p.quantity, p.price) from Product p")
    List<CProductInfo> getProductInfoConcrete();

    @Query("Select new com.cs.springdatajpatutorial.dto.MinMaxStats(max(p.price), min(p.price)) from Product p")
    MinMaxStats getMinMaxPrice();
}
