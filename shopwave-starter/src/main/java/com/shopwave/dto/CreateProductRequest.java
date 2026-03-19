package com.shopwave.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

// Student Number: ATE-3156-14
public record CreateProductRequest(
    @NotBlank(message = "Name is required") String name,
    String description,
    @Positive(message = "Price must be positive") BigDecimal price,
    @Min(value = 0, message = "Stock cannot be negative") Integer stock,
    Long categoryId
) {}