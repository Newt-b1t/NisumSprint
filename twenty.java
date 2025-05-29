package com.avinash.sprint2;

import java.util.List;
import java.util.Optional;

class Employee18 {
    private final String name;
    private final Optional<String> email;
    private final Optional<String> department;

    Employee18(String name, Optional<String> email, Optional<String> department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    String getName() { return name; }
    Optional<String> getEmail() { return email; }
    Optional<String> getDepartment() { return department; }
}

public class twenty {
    public static void main(String[] args) {
        List<Employee18> employees = List.of(
                new Employee18("John", Optional.of("john@example.com"), Optional.of("IT")),
                new Employee18("Alice", Optional.of("alice@example.com"), Optional.of("HR")),
                new Employee18("Bob", Optional.empty(), Optional.of("Finance")),
                new Employee18("Lily", Optional.of("lily@example.com"), Optional.empty())
        );

        boolean anyFromHR = employees.stream()
                .anyMatch(e -> e.getDepartment().map(d -> d.equalsIgnoreCase("HR")).orElse(false));
        System.out.println("Any employee from HR? " + anyFromHR);

        boolean allHaveEmail = employees.stream()
                .allMatch(e -> e.getEmail().isPresent());
        System.out.println("All employees have email? " + allHaveEmail);

        boolean noneHasNullName = employees.stream()
                .noneMatch(e -> e.getName() == null);
        System.out.println("No employee has null name? " + noneHasNullName);
    }
}
