package com.avinash.sprint2;

import java.util.List;
import java.util.stream.Collectors;

class Employee7 {
    String firstName;
    String lastName;

    Employee7(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() { return firstName; }
    String getLastName() { return lastName; }
}

public class eight {
    public static void main(String[] args) {
        List<Employee7> employees = List.of(
                new Employee7("Avinash", "Rath"),
                new Employee7("Ashwini", "Tripathy"),
                new Employee7("Biswas", "Gupta")
        );

        String result = employees.stream()
                .map(e -> e.getFirstName() + e.getLastName())
                .collect(Collectors.joining("|"));

        System.out.println(result);
    }
}
