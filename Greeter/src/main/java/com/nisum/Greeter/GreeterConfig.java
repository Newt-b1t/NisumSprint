package com.nisum.Greeter;

import org.springframework.context.annotation.*;

@Configuration
public class GreeterConfig {
    @Bean
    public Greeter javaConfigGreeter() {
        return new SimpleGreeter("Java Config");
    }
}
