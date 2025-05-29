package com.avinash.sprint2;

import java.util.List;
import java.util.Optional;

class Employee17 {
    private final int id;
    private final String name;

    Employee17(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() { return id; }
    String getName() { return name; }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class nineteen {
    public static void main(String[] args) {
        List<Employee17> employees = List.of(
                new Employee17(1, "John"),
                new Employee17(2, "Alice"),
                new Employee17(3, "Bob"),
                new Employee17(4, "Lily")
        );

        Optional<Employee17> firstEmployee = employees.stream().findFirst();
        firstEmployee.ifPresent(e -> System.out.println("First employee: " + e));

        Optional<Employee17> anyEmployee = employees.stream().findAny();
        anyEmployee.ifPresent(e -> System.out.println("Any employee: " + e));
    }
}
