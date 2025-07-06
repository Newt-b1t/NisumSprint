package com.nisum;

public class PriceCalculator {
    // Heavy private method
    public double calculateTax(double base) {
        // Simulate a heavy calculation
        return base * 0.2;
    }

    public double getTotalPrice(double base) {
        // Do NOT catch exceptions here; let them propagate to the facade
        double tax = calculateTax(base);
        return base + tax;
    }
}
