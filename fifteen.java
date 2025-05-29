package com.avinash.sprint2;

import java.util.List;
import java.util.Optional;

class Employee14 {
    private final int id;
    private final String name;
    private final Optional<String> address;

    Employee14(int id, String name, Optional<String> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    int getId() { return id; }
    String getName() { return name; }
    Optional<String> getAddress() { return address; }
}

public class fifteen {
    public static void main(String[] args) {
        List<Employee14> employees = List.of(
                new Employee14(1, "John", Optional.of("123 Main St")),
                new Employee14(2, "Alice", Optional.empty()),
                new Employee14(3, "Bob", Optional.of("456 Oak Ave")),
                new Employee14(4, "Lily", Optional.empty())
        );

        for (Employee14 emp : employees) {
            String address = emp.getAddress().orElse("No Address Provided");

            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Address: " + address);
            System.out.println("-----");
        }
    }
}
