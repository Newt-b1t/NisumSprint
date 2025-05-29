package com.avinash.sprint2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee11 {
    String firstName;
    String gender;

    Employee11(String firstName, String gender) {
        this.firstName = firstName;
        this.gender = gender;
    }

    String getFirstName() { return firstName; }
    String getGender() { return gender; }
}

public class twelve {
    public static void main(String[] args) {
        List<Employee11> employees = List.of(
                new Employee11("John", "Male"),
                new Employee11("Mike", "Male"),
                new Employee11("Alice", "Female"),
                new Employee11("Lily", "Female")
        );

        Map<String, String> groupedNames = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getGender().toUpperCase(),
                        Collectors.mapping(
                                Employee11::getFirstName,
                                Collectors.joining("-")
                        )
                ));

        String result = String.format("MALE: [%s], FEMALE: [%s]",
                groupedNames.getOrDefault("MALE", ""),
                groupedNames.getOrDefault("FEMALE", "")
        );

        System.out.println(result);
    }
}

