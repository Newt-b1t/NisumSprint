package com.nisum;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentGatewayClient paymentGatewayClient;
    private final OrderRepository orderRepository;
    public OrderService(PaymentGatewayClient paymentGatewayClient, OrderRepository orderRepository) {
        this.paymentGatewayClient = paymentGatewayClient;
        this.orderRepository = orderRepository;
    }
    public void placeOrder(OrderRequest request) {
        paymentGatewayClient.charge(request.getAmount());
        orderRepository.save(new OrderEntity(request.getAmount()));
    }
}

