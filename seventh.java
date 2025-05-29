package com.avinash.sprint2;
import java.util.*;

class Employee6 {
    private int empId;
    private String name;

    public Employee6(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (ID: " + empId + ")";
    }
}

public class seventh {
    public static void main(String[] args) {
        List<Employee6> employees = List.of(
                new Employee6(102, "Avinash"),
                new Employee6(110, "Ashwini"),
                new Employee6(101, "Gupta babu")
        );

        Employee6 maxEmp = employees.stream()
                .max(Comparator.comparingInt(Employee6::getEmpId))
                .orElse(null);

        System.out.println("Employee with highest empId: " + maxEmp);
    }
}
