package com.nisum.CalculatorProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(2, -3));
        assertNotEquals(10, calculator.add(3, 4)); // 3+4=7 ≠10 → valid
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
        assertEquals(-5, calculator.subtract(2, 7));
        // Fixed: Changed to valid negative case
        assertNotEquals(10, calculator.subtract(15, 6)); // 15-6=9 ≠10
    }

    @Test
    void testMultiply() {
        assertEquals(12, calculator.multiply(3, 4));
        assertEquals(-8, calculator.multiply(2, -4));
        assertNotEquals(20, calculator.multiply(3, 5)); // 3*5=15 ≠20 → valid
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-4, calculator.divide(-8, 2));
        // Fixed: Changed to valid negative case
        assertNotEquals(3, calculator.divide(10, 4)); // 10/4=2 (int div) ≠3
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(5, 0)
        );
        assertEquals("Division by zero", exception.getMessage());
    }
}
