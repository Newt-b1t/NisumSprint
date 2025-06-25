package com.nisum.Greeter;

public class SimpleGreeter implements Greeter {
    private final String source;

    public SimpleGreeter(String source) {
        this.source = source;
    }

    @Override
    public String greet() {
        return "Hello from " + source + "!";
    }
}
