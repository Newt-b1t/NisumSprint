package com.example.OrderService;

import lombok.Data;

@Data
public class Order {
    private String orderId;
    private String item;
    private int quantity;

    public Order() {
    }
    public Order(String orderId, String item, int quantity) {
        this.orderId = orderId;
        this.item = item;
        this.quantity = quantity;
    }

}
