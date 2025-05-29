package com.avinash.sprint2;

import java.util.List;
import java.util.Optional;

class Employee8 {
    String firstName;
    String lastName;
    String department;

    Employee8(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    String getFirstName() { return firstName; }
    String getLastName() { return lastName; }
    String getDepartment() { return department; }
}

public class nine {
    public static void main(String[] args) {
        List<Employee8> employees = List.of(
                new Employee8("John", "Doe", "HR"),
                new Employee8("Jane", "Smith", "Finance"),
                new Employee8("Alice", "Brown", "IT"),
                new Employee8("Bob", "White", "Marketing"),
                new Employee8("Carol", "Green", "Sales"),
                new Employee8("David", "Black", "IT"),
                new Employee8("Eva", "Blue", "HR"),
                new Employee8("Frank", "Yellow", "Finance"),
                new Employee8("Grace", "Pink", "IT"),
                new Employee8("Henry", "Orange", "Marketing")
        );

        Optional<Employee8> eighthEmployee = employees.stream()
                .skip(7)
                .findFirst();

        if (eighthEmployee.isPresent()) {
            Employee8 e = eighthEmployee.get();
            String fullName = e.getFirstName() + " " + e.getLastName();
            System.out.println("Full Name: " + fullName);
            System.out.println("Department: " + e.getDepartment());
        } else {
            System.out.println("No 8th employee found.");
        }
    }
}
