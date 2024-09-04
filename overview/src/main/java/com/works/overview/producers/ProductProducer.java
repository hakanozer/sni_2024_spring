package com.works.overview.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.works.overview.entities.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductProducer {

    final RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sp.rabbit.exchange.name}")
    private String exchangeName;

    public void sendToQueue(Product product) {
        System.out.println("sendToQueue Product: " + product);
        rabbitTemplate.convertAndSend(exchangeName, routingName, product);
    }
    
}
