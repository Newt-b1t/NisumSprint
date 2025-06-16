package com.avinash.sprint3;
//9
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// 5️⃣ Example Usage with a User object
public class ValidationFrameworkExample {

    public static void main(String[] args) {
        // Sample object
        User user = new User("", -5, "invalid_email");

        // Create a validator and add rules
        Validator<User> userValidator = new Validator<User>()
                .addRule(u -> u.name() == null || u.name().isBlank()
                        ? new ValidationError("name", "Name cannot be empty or blank.")
                        : null)
                .addRule(u -> u.age() <= 0
                        ? new ValidationError("age", "Age must be positive.")
                        : null)
                .addRule(u -> !u.email().contains("@")
                        ? new ValidationError("email", "Email must contain '@'.")
                        : null);

        // Run validation
        try {
            userValidator.validate(user);
            System.out.println("Validation passed.");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            e.getErrors().forEach(err ->
                    System.out.println("Field: " + err.fieldName() + ", Error: " + err.errorMessage()));
        }
    }

    // Sample record for User
    public record User(String name, int age, String email) {}
}
