package com.shopwave.dto;

import java.math.BigDecimal;

// Student Number: ATE-3156-14
public record ProductDTO(
    Long id, 
    String name, 
    String description, 
    BigDecimal price, 
    Integer stock, 
    String categoryName
) {}