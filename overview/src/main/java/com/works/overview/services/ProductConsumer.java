package com.works.overview.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.works.overview.entities.Product;
import com.works.overview.models.ModelProduct;
import com.works.overview.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductConsumer {

    final ProductRepository productRepository;

    @Transactional
    @RabbitListener(queues = "queuename")
    public void handleMessage( ModelProduct product ) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        Product pro = new Product();
        pro.setTitle(product.getTitle());
        pro.setPrice(product.getPrice());
        productRepository.save(pro);
        System.out.println("Pull Data:" + pro);
    }

    
}
