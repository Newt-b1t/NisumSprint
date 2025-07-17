package com.example.KafkaDemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class UserEventController {
    private final UserEventProducer producer;

    public UserEventController(UserEventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String publishUserEvent(@RequestBody String eventJson) {
        producer.sendEvent(eventJson);
        return "Event published";
    }
}
