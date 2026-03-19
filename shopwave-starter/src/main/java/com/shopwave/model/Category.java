package com.shopwave.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

// Student Number: ATE-3156-14
@Entity
@Table(name = "categories")
@Getter @Setter @NoArgsConstructor
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-incrementing ID

    @NotBlank(message = "Category name cannot be blank")
    @Column(nullable = false)
    private String name;

    private String description;
}

