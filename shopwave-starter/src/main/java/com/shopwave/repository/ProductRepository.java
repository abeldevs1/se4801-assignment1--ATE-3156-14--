package com.shopwave.repository;

import com.shopwave.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

// Student Number: ATE-3156-14
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Finds all products belonging to a specific category ID
    List<Product> findByCategoryId(Long categoryId);
    
    // Finds products equal to or cheaper than a given price
    List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);
    
    // Allows searching for products by name, ignoring upper/lower case
    List<Product> findByNameContainingIgnoreCase(String keyword);
    
    // Finds the single most expensive product in the database
    Optional<Product> findTopByOrderByPriceDesc();
}