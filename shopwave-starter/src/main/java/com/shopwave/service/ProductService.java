package com.shopwave.service;

import com.shopwave.exception.ProductNotFoundException;
import com.shopwave.model.Product;
import com.shopwave.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Student Number: ATE-3156-14
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Dependency Injection (IoC) via Constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Retrieve a single product by ID or throw our custom 404 exception
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    // Save a new product
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = getProductById(id); // Reuses the method above to check if it exists

        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setStock(productDetails.getStock());
        existingProduct.setCategory(productDetails.getCategory());

        return productRepository.save(existingProduct);
    }

    // Delete a product
    @Transactional
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}