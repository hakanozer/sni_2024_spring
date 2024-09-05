package com.works.overview.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Product;
import com.works.overview.models.ModelProduct;
import com.works.overview.producers.ProductProducer;
import com.works.overview.repositories.ProductRepository;
import com.works.overview.utils.Util;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final ProductProducer productProducer;

    public ResponseEntity save(ModelProduct product) {
        productProducer.sendToQueue(product);
        //productRepository.save(product);
        return Util.ok("Success");
    }

    public ResponseEntity list() {
        return Util.ok(productRepository.findAll());
    }

    public void saveMessage( Product product ) {
        productRepository.save(product);
    }

    
}
