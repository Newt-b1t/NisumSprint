package com.avinash.sprint2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Address1 {
    private final String city;
    private final String country;

    Address1(String city, String country) {
        this.city = city;
        this.country = country;
    }

    String getCity() { return city; }
    String getCountry() { return country; }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Employee16 {
    private final String firstName;
    private final String lastName;
    private final Address1 address;

    Employee16(String firstName, String lastName, Address1 address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    String getFirstName() { return firstName; }
    String getLastName() { return lastName; }
    Address1 getAddress() { return address; }
}

public class eighteen {
    public static void main(String[] args) {
        List<Employee16> employees = List.of(
                new Employee16("John", "Doe", new Address1("New York", "USA")),
                new Employee16("Alice", "Smith", new Address1("London", "UK")),
                new Employee16("Bob", "Brown", new Address1("Paris", "France"))
        );

        Map<String, Address1> employeeAddressMap = employees.stream()
                .collect(Collectors.toMap(
                        e -> e.getFirstName() + e.getLastName(),
                        Employee16::getAddress
                ));

        employeeAddressMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
