package com.avinash.sprint2;

import java.util.List;
import java.util.Comparator;

class Address {
    private final String city;
    private final String country;

    Address(String city, String country) {
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

public class seventeen {
    public static void main(String[] args) {
        List<Address> addresses = List.of(
                new Address("New York", "USA"),
                new Address("Paris", "France"),
                new Address("Berlin", "Germany"),
                new Address("Paris", "USA"),
                new Address("Berlin", "France")
        );

        addresses.stream()
                .sorted(
                        Comparator.comparing(Address::getCity)
                                .thenComparing(Address::getCountry)
                )
                .forEach(System.out::println);
    }
}

