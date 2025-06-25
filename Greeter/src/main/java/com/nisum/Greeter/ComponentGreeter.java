package com.nisum.Greeter;

import org.springframework.stereotype.Component;

@Component
public class ComponentGreeter implements Greeter {
    public String greet() {
        return "Component-scanned Greeter";
    }
}
