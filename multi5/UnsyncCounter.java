package com.nisum.Question5;

public class UnsyncCounter {
    public int count = 0;

    public void increment() {
        count++; // No synchronization
    }

//    public void increment() {
//        int temp = count;
//        try {
//            Thread.sleep(1); //simulate delay
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        count = temp + 1;
//    }


    public int getValue() {
        return count;
    }
}
