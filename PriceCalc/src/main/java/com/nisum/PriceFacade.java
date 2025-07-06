package com.nisum;

public class PriceFacade {
    private final PriceCalculator calculator = new PriceCalculator();

    public double getPrice(double base) {
        try {
            return calculator.getTotalPrice(base);
        } catch (ArithmeticException e) {
            return getDefaultPrice();
        }
    }

    public double getDefaultPrice() {
        return 42.0;
    }
}
