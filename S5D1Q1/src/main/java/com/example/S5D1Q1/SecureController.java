package com.example.S5D1Q1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/api/secure")
    public String secureEndpoint() {
        return "This is a secured endpoint!";
    }
}

