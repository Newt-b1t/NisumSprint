//1
package com.avinash.sprint3;

public class DiviEx {
    public static void main(String[] args) {
        // Test cases
        divide(2, 2);
        divide(5, 0);
        divide(15, 3);
    }

    public static void divide(int n, int d) {
        try {
            if (d == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            int result = n / d;
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
        System.out.println("End of the program");
    }
}
