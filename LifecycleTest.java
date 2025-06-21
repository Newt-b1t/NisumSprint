package com.nisum.CalculatorProject;

import org.junit.jupiter.api.*;

public class LifecycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll - Runs once before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach - Runs before each test");
    }

    @Test
    void test1() {
        System.out.println("@Test - Test method 1");
    }

    @Test
    void test2() {
        System.out.println("@Test - Test method 2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach - Runs after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll - Runs once after all tests");
    }
}
