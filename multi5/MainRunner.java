package com.nisum.Question5;

import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Run which version? (1 = Unsynchronized, 2 = Synchronized): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            UnsyncCounter counter = new UnsyncCounter();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            };

            Thread t1 = new CounterTask(task);
            Thread t2 = new CounterTask(task);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("❌ Final count (unsynchronized): " + counter.getValue());
        }

        else if (choice == 2) {
            SyncCounter counter = new SyncCounter();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            };

            Thread t1 = new CounterTask(task);
            Thread t2 = new CounterTask(task);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("✅ Final count (synchronized): " + counter.getValue());
        }

        else {
            System.out.println("Invalid choice! Please enter 1 or 2.");
        }
    }
}

