package com.example.KafkaDemo;

import lombok.Data;

@Data
public class UserEvent {
    private String userId;
    private String action;

    public UserEvent() {
    }
    public UserEvent(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }

}