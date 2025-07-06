package com.nisum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {

    @Spy
    private PriceFacade priceFacade;

    @Test
    public void testGetPrice_FallbackOnExceptionAndResetSpy() throws Exception {
        double base = 100.0;

        // Spy on the underlying PriceCalculator
        PriceCalculator calculatorSpy = spy(new PriceCalculator());

        // Use reflection to inject the spy into the facade
        java.lang.reflect.Field field = PriceFacade.class.getDeclaredField("calculator");
        field.setAccessible(true);
        field.set(priceFacade, calculatorSpy);

        // Stub calculateTax to throw ArithmeticException
        doThrow(new ArithmeticException("forced")).when(calculatorSpy).calculateTax(anyDouble());

        // First call: should throw, so facade returns default price (42.0)
        double result = priceFacade.getPrice(base);
        assertEquals(42.0, result, 0.01);

        // Reset the spy so real method is called next
        reset(calculatorSpy);

        // Now real calculateTax will be called, so get real price
        double expected = base + base * 0.2;
        double result2 = priceFacade.getPrice(base);
        assertEquals(expected, result2, 0.01);
    }
}
