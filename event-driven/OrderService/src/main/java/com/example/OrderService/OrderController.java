package com.example.OrderService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        orderProducer.publishOrderCreated(order);
        return "Order received and event published for orderId: " + order.getOrderId();
    }
}
