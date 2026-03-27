package com.cs.springdatajpatutorial.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CProductInfo {
    private final Long id;
    private final String title;
    private final Integer quantity;
    private final BigDecimal price;
}
