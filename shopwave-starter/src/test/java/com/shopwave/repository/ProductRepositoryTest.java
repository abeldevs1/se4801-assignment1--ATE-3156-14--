package com.shopwave.repository;

import com.shopwave.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

// Student Number: ATE-3156-14
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        // Clear database before each test to ensure isolation
        productRepository.deleteAll();

        Product p1 = new Product();
        p1.setName("Mechanical Keyboard");
        p1.setPrice(BigDecimal.valueOf(150.00));
        p1.setStock(20);

        Product p2 = new Product();
        p2.setName("Gaming Mouse");
        p2.setPrice(BigDecimal.valueOf(80.00));
        p2.setStock(50);

        productRepository.saveAll(List.of(p1, p2));
    }

    @Test
    void testFindByNameContainingIgnoreCase() {
        List<Product> results = productRepository.findByNameContainingIgnoreCase("mechanic");
        assertEquals(1, results.size());
        assertEquals("Mechanical Keyboard", results.get(0).getName());
    }

    @Test
    void testFindByPriceLessThanEqual() {
        List<Product> results = productRepository.findByPriceLessThanEqual(BigDecimal.valueOf(100.00));
        assertEquals(1, results.size());
        assertEquals("Gaming Mouse", results.get(0).getName());
    }
}
