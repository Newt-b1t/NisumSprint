package com.nisum.customerdashboard;

import com.nisum.customerdashboard.entity.Customer;
import com.nisum.customerdashboard.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testFindByEmailContaining() {
		Customer c = new Customer();
		c.setName("Alice");
		c.setEmail("alice@example.com");
		c.setRegisteredDate(LocalDate.now());
		customerRepository.save(c);

		List<Customer> result = customerRepository.findByEmailContaining("alice");
		assertThat(result).isNotEmpty();
	}

	@Test
	public void testFindByRegisteredDateAfter() {
		Customer c = new Customer();
		c.setName("Bob");
		c.setEmail("bob@example.com");
		c.setRegisteredDate(LocalDate.now().minusDays(1));
		customerRepository.save(c);

		List<Customer> result = customerRepository.findByRegisteredDateAfter(LocalDate.now().minusDays(2));
		assertThat(result).isNotEmpty();
	}

	@Test
	public void testFindByNameJPQL() {
		Customer c = new Customer();
		c.setName("Charlie");
		c.setEmail("charlie@example.com");
		c.setRegisteredDate(LocalDate.now());
		customerRepository.save(c);

		List<Customer> result = customerRepository.findByNameJPQL("Charlie");
		assertThat(result).isNotEmpty();
	}
}
