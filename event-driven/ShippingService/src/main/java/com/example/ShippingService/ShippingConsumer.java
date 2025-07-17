package com.example.ShippingService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ShippingConsumer {

    @KafkaListener(topics = "order.created", groupId = "shipping-service", containerFactory = "orderKafkaListenerContainerFactory")
    public void processOrder(Order order) {
        // Simulate reserving stock and shipping logic
        System.out.println("ShippingService: Received order " + order.getOrderId());
        System.out.println("Reserving stock for item: " + order.getItem() + ", quantity: " + order.getQuantity());
        System.out.println("Shipping confirmation: Order " + order.getOrderId() + " will be shipped.");
    }
}
