package com.example.KafkaDemo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "user-events";

    public UserEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String eventJson) {
        kafkaTemplate.send(TOPIC, eventJson);
    }
}
