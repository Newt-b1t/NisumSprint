package com.avinash.sprint2;

import java.util.List;
import java.util.Optional;

class Employee15 {
    private final int id;
    private final String name;
    private double salary;
    private final Optional<String> department;

    Employee15(int id, String name, double salary, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    double getSalary() {
        return salary;
    }
    Optional<String> getDepartment() {
        return department;
    }

    void increaseSalary(double amount) {
        this.salary += amount;
    }

    @Override
    public String toString() {
        return name + " | Salary: " + salary + " | Department: " + department.orElse("N/A");
    }
}

public class sixteen {
    public static void main(String[] args) {
        List<Employee15> employees = List.of(
                new Employee15(1, "John", 50000, Optional.of("IT")),
                new Employee15(2, "Alice", 48000, Optional.of("HR")),
                new Employee15(3, "Bob", 52000, Optional.of("IT")),
                new Employee15(4, "Lily", 47000, Optional.empty())
        );

        employees.forEach(emp -> emp.getDepartment().ifPresent(dept -> {
            if (dept.equalsIgnoreCase("IT")) {
                emp.increaseSalary(1000);
            }
        }));

        employees.forEach(System.out::println);
    }
}
