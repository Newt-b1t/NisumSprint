package com.avinash.sprint2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Employee9 {
    int id;
    String firstName;
    String lastName;

    Employee9(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    int getId() { return id; }
    String getFirstName() { return firstName; }
    String getLastName() { return lastName; }

    @Override
    public String toString() {
        return "Employee9{id=" + id + ", name=" + firstName + " " + lastName + "}";
    }
}

public class ten {
    public static void main(String[] args) {
        List<Employee9> allEmployees = List.of(
                new Employee9(1, "John", "Doe"),
                new Employee9(2, "Jane", "Smith"),
                new Employee9(3, "Alice", "Brown"),
                new Employee9(4, "Bob", "White"),
                new Employee9(5, "Carol", "Green")
        );

        List<Integer> employeeIdsToFind = List.of(2, 4);

        Set<Integer> idSet = Set.copyOf(employeeIdsToFind);

        List<Employee9> matchingEmployees = allEmployees.stream()
                .filter(e -> idSet.contains(e.getId()))
                .toList();

        matchingEmployees.forEach(System.out::println);
    }
}
