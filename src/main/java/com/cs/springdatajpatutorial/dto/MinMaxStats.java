package com.cs.springdatajpatutorial.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MinMaxStats {
    private final BigDecimal maxPrice;
    private final BigDecimal minPrice;
}
