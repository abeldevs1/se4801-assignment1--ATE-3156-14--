package com.shopwave.service;

import com.shopwave.dto.ProductDTO;
import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Student Number: ATE-3156-14
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        // We create a fake product to use in our tests
        product = new Product();
        product.setId(1L);
        product.setName("Test Laptop");
        product.setPrice(BigDecimal.valueOf(999.99));
        product.setStock(10);
    }

    @Test
    void testGetProductById_Success() {
        // Arrange: Tell the mock database to return our fake product when asked for ID 1
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Act: Actually call the service method
        ProductDTO result = productService.getProductById(1L);

        // Assert: Verify the result is exactly what we expect
        assertNotNull(result);
        assertEquals("Test Laptop", result.name());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetProductById_NotFound() {
        // Arrange: Tell the mock database to return empty when asked for an ID that doesn't exist
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert: Verify that asking for ID 99 throws our custom 404 exception
        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(99L);
        });
    }
}