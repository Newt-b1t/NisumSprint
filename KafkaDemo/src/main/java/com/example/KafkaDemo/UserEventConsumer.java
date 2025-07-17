package com.example.KafkaDemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {
    @KafkaListener(topics = "user-events", groupId = "user-events-group")
    public void listen(String message) {
        System.out.println("Received user event: " + message);
    }
}

