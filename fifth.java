package com.avinash.sprint2;

import java.util.*;
import java.util.stream.*;

class Employee4 {
    private String name;
    private String department;

    public Employee4(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() { return department; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class fifth {
    public static void main(String[] args) {
        List<Employee4> employees = List.of(
                new Employee4("Avinash", "IT"),
                new Employee4("Biswas", "HR"),
                new Employee4("Ashwini", "Sales")
        );

        String excludeDept = "HR";
        List<Employee4> filtered = employees.stream()
                .filter(e -> !e.getDepartment().equalsIgnoreCase(excludeDept))
                .toList();

        System.out.println("Employees NOT in " + excludeDept + ": " + filtered);
    }
}
