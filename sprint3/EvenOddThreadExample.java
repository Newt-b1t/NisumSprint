//21
package com.avinash.sprint3;

public class EvenOddThreadExample {

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("Even Thread: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("Even Thread Interrupted");
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd Thread: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("Odd Thread Interrupted");
                    }
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
