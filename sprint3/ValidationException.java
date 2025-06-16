package com.avinash.sprint3;

import java.util.List;

// 2️⃣ Custom ValidationException that holds multiple errors
public class ValidationException extends RuntimeException {
    private final List<ValidationError> errors;

    public ValidationException(List<ValidationError> errors) {
        super("Validation failed with " + errors.size() + " error(s).");
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
