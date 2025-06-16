package com.avinash.sprint3;

import java.util.ArrayList;
import java.util.List;

// 4️⃣ Validator Utility Class
public class Validator<T> {
    private final List<ValidationRule<T>> rules = new ArrayList<>();

    public Validator<T> addRule(ValidationRule<T> rule) {
        rules.add(rule);
        return this;
    }

    public void validate(T object) {
        List<ValidationError> errors = new ArrayList<>();
        for (ValidationRule<T> rule : rules) {
            ValidationError error = rule.validate(object);
            if (error != null) {
                errors.add(error);
            }
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
