//2
package com.avinash.sprint3;

class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        validateAge(5);
        validateAge(0);
        validateAge(-5);
    }

    public static void validateAge(int age) {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Invalid age: Age must be positive");
            }
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException ex) {
            System.out.println("InvalidAgeException caught: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Other exception caught: " + ex.getMessage());
        }
        System.out.println("End of the program");
    }
}
