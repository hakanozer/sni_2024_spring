package com.works.overview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.works.overview.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
