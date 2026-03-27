package com.cs.springdatajpatutorial.dto;

import java.math.BigDecimal;

public interface IProductInfo {
    Long getId();
    String getTitle();
    BigDecimal getPrice();
}
