package com.shopwave.service;

import com.shopwave.dto.CreateProductRequest;
import com.shopwave.dto.ProductDTO;
import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.mapper.ProductMapper;
import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

// Student Number: 
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductMapper::toDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return ProductMapper.toDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> searchProducts(String keyword, BigDecimal maxPrice) {
        List<Product> results;
        if (keyword != null && !keyword.isBlank()) {
            results = productRepository.findByNameContainingIgnoreCase(keyword);
        } else if (maxPrice != null) {
            results = productRepository.findByPriceLessThanEqual(maxPrice);
        } else {
            results = productRepository.findAll();
        }
        return results.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }

    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock() != null ? request.stock() : 0);
        // Note: For a real app, you'd fetch the Category from a CategoryRepository here using request.categoryId()
        
        Product saved = productRepository.save(product);
        return ProductMapper.toDTO(saved);
    }

    public ProductDTO updateStock(Long id, int delta) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        
        int newStock = product.getStock() + delta;
        if (newStock < 0) {
            throw new IllegalArgumentException("Final stock cannot be negative");
        }
        
        product.setStock(newStock);
        return ProductMapper.toDTO(productRepository.save(product));
    }
}