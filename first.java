package com.avinash.sprint2;
import java.util.*;
import java.util.stream.*;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

public class first {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Avinash", "Rath"),
                new Employee("Avisek", "Rath")
        );

        String fullName = employees.stream()
                .findFirst()
                .map(e -> e.getFirstName() + " " + e.getLastName())
                .orElse("No employee found");

        System.out.println("First employee full name: " + fullName);
    }
}
