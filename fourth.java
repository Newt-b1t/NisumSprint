package com.avinash.sprint2;

public class fourth {
    public static void main(String[] args) {
        String storeId = "23";
        String padded = String.format("%4s", storeId).replace(' ', '0');
        System.out.println("Padded Store ID: " + padded);
    }
}
