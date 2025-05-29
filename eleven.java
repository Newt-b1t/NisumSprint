package com.avinash.sprint2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee10 {
    String firstName;
    String gender;

    Employee10(String firstName, String gender) {
        this.firstName = firstName;
        this.gender = gender;
    }

    String getFirstName() { return firstName; }
    String getGender() { return gender; }
}

public class eleven {
    public static void main(String[] args) {
        List<Employee10> employees = List.of(
                new Employee10("John", "Male"),
                new Employee10("Jane", "Female"),
                new Employee10("Bob", "Male"),
                new Employee10("Alice", "Female"),
                new Employee10("Eve", "Female")
        );

        Map<String, Long> genderCounts = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee10::getGender,
                        Collectors.counting()
                ));

        genderCounts.forEach((gender, count) ->
                System.out.println(gender + ": " + count));
    }
}
