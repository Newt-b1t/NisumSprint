package com.avinash.sprint2;

import java.util.*;
import java.util.stream.*;

class Employee5 {
    private String firstName;

    public Employee5(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() { return firstName; }

    @Override
    public String toString() {
        return firstName;
    }
}

public class sixth {
    public static void main(String[] args) {
        List<Employee5> employees = List.of(
                new Employee5("Avinash"),
                new Employee5("Sahil"),
                new Employee5("Biswas")
        );

        List<Employee5> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee5::getFirstName))
                .toList();

        System.out.println("Sorted by first name: " + sorted);
    }
}
