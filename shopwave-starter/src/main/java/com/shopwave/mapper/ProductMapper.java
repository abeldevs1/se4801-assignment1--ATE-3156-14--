package com.shopwave.mapper;

import com.shopwave.dto.ProductDTO;
import com.shopwave.model.Product;

// Student Number: ATE-3156-14
public class ProductMapper {
    
    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;
        
        String categoryName = (product.getCategory() != null) ? product.getCategory().getName() : "Uncategorized";
        
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            categoryName
        );
    }
}