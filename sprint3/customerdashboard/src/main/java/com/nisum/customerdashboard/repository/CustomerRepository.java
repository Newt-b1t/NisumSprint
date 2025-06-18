package com.nisum.customerdashboard.repository;


import com.nisum.customerdashboard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContaining(String keyword);
    List<Customer> findByRegisteredDateAfter(LocalDate date);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByNameJPQL(String name);

    @Query(value = "SELECT * FROM customers WHERE name = :name", nativeQuery = true)
    List<Customer> findByNameNative(String name);
}
