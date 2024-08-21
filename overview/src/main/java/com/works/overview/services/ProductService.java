package com.works.overview.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Product;
import com.works.overview.repositories.ProductRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public ResponseEntity save(Product product) {
        productRepository.save(product);
        return Util.ok(product);
    }

    public ResponseEntity list() {
        return Util.ok(productRepository.findAll());
    }

    
}
