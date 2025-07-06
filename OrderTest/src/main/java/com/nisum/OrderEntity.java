package com.nisum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;
    private double amount;
    public OrderEntity() {}
    public OrderEntity(double amount) { this.amount = amount; }
}
