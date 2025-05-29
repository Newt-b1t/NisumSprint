package com.avinash.sprint2;

import java.util.*;
import java.util.stream.*;

class Employee1 {
    private String firstName;
    private String department;

    public Employee1(String firstName, String department) {
        this.firstName = firstName;
        this.department = department;
    }

    public String getDepartment() { return department; }
}

public class second {
    public static void main(String[] args) {
        List<Employee1> employees = List.of(
                new Employee1("Avinash", "IT"),
                new Employee1("Biswas", "HR"),
                new Employee1("Ashwini", "IT"),
                new Employee1("Arnab", "HR"),
                new Employee1("Sahil", "Sales")
        );

        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));

        System.out.println("Department wise employee count: " + deptCount);
    }
}
