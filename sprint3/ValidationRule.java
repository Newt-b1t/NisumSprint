package com.avinash.sprint3;

@FunctionalInterface
public interface ValidationRule<T> {
    ValidationError validate(T object);
}
