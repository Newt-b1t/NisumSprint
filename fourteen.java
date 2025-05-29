package com.avinash.sprint2;



import java.util.List;
import java.util.Optional;

class Employee13 {
    private final int id;
    private final String name;
    private final Optional<String> email;
    private final Optional<String> department;

    Employee13(int id, String name, Optional<String> email, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    Optional<String> getEmail() {
        return email;
    }
    Optional<String> getDepartment() {
        return department;
    }
}

public class fourteen{
    public static void main(String[] args) {
        List<Employee13> employees = List.of(
                new Employee13(1, "John", Optional.of("john@example.com"), Optional.of("IT")),
                new Employee13(2, "Alice", Optional.empty(), Optional.of("HR")),
                new Employee13(3, "Bob", Optional.of("bob@example.com"), Optional.empty()),
                new Employee13(4, "Lily", Optional.empty(), Optional.empty())
        );

        for (Employee13 emp : employees) {
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());

            emp.getEmail().ifPresentOrElse(
                    email -> System.out.println("Email: " + email),
                    () -> System.out.println("Email: Not provided")
            );

            emp.getDepartment().ifPresentOrElse(
                    dept -> System.out.println("Department: " + dept),
                    () -> System.out.println("Department: Not assigned")
            );

            System.out.println("-----");
        }
    }
}
