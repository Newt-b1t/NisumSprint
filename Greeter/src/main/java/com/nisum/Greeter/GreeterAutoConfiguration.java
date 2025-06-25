package com.nisum.Greeter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

@AutoConfiguration
@ConditionalOnMissingBean(Greeter.class)
public class GreeterAutoConfiguration {
    @Bean
    public Greeter autoConfiguredGreeter() {
        return new SimpleGreeter("Auto-configured");
    }
}