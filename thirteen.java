package com.avinash.sprint2;

import java.util.List;
import java.util.Comparator;

class Employee12 {
    String firstName;
    double salary;

    Employee12(String firstName, double salary) {
        this.firstName = firstName;
        this.salary = salary;
    }

    String getFirstName() {
        return firstName;
    }
    double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return firstName + " " + salary;
    }
}

public class thirteen {
    public static void main(String[] args) {
        List<Employee12> employees = List.of(
                new Employee12("John", 55000),
                new Employee12("Alice", 48000),
                new Employee12("Mike", 62000),
                new Employee12("Lily", 50000)
        );

        List<Employee12> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee12::getSalary))
                .toList();

        sortedBySalary.forEach(System.out::println);
    }
}

