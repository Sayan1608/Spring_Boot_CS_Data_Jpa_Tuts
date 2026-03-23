package com.cs.springdatajpatutorial.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "product_details_table",
uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique_constraint", columnNames = {"sku"}),
        @UniqueConstraint(name = "title_price_unique_constraint", columnNames = {"product_name", "price"})
},
indexes = {
        @Index(name = "idx_sku", columnList = "sku"),
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sku;

    @Column(name = "product_name", nullable = false)
    private String title;

    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private  LocalDateTime updatedAt;
}
