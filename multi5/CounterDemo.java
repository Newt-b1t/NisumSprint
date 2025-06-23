package com.nisum.Question5;

import java.util.Scanner;

public class CounterDemo {
    static int counter = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which case to run? (1 = No sync, 2 = With sync): ");
        int choice = sc.nextInt();

        Runnable task;
        if (choice == 1) {
            // No sync
            task = () -> {
                for (int i = 0; i < 1000; i++) {
                    counter++; // race condition
                }
            };
        } else {
            // With sync
            task = () -> {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock) {
                        counter++; // thread-safe
                    }
                }
            };
        }

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal counter value: " + counter +
                (choice == 1 ? " ❌ (No sync)" : " ✅ (With sync)"));
    }
}

