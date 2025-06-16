//3
package com.avinash.sprint3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class InvalidAgeException1 extends RuntimeException {
    public InvalidAgeException1(String message) {
        super(message);
    }
}

public class AgeValidatorNew {
    public static void main(String[] args) {
        validateAge(5);
        validateAge(0);
        validateAge(-5);
    }

    public static void validateAge(int age) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("age_validation.txt", true))) {
            if (age <= 0) {
                throw new InvalidAgeException1("Invalid age: Age must be positive");
            }
            writer.println("Valid age: " + age);
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException1 ex) {
            System.out.println("InvalidAgeException caught: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException caught: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Other exception caught: " + ex.getMessage());
        }
        System.out.println("End of the program");
    }
}
