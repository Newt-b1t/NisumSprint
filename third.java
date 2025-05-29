package com.avinash.sprint2;

import java.util.*;
import java.util.stream.*;

class Employee3 {
    private String firstName;
    private String lastName;

    public Employee3(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class third {
    public static void main(String[] args) {
        Map<String, List<Employee3>> departmentEmployees = new HashMap<>();

        departmentEmployees.put("IT", List.of(
                new Employee3("Avinash", "Rath"),
                new Employee3("Ashwini", "Tripathy")
        ));

        departmentEmployees.put("HR", List.of(
                new Employee3("Avisek", "Rath"),
                new Employee3("Biswas", "Gupta")
        ));

        String search = "avi";

        List<Employee3> matchedEmployees = departmentEmployees.values().stream()
                .flatMap(List::stream)
                .filter(e -> (e.getFirstName() + e.getLastName()).toLowerCase().contains(search.toLowerCase()))
                .toList();

        System.out.println("Matched Employees: " + matchedEmployees);
    }
}
