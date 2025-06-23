package com.nisum.Question2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Use synchronized increment? (yes/no): ");
        boolean useSync = scanner.nextLine().equalsIgnoreCase("yes");

        Counter counter = new Counter();

        Thread t1 = new CounterTask(counter, useSync);
        Thread t2 = new CounterTask(counter, useSync);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("Threads interrupted");
        }

        System.out.println("Final Counter Value: " + counter.count);
    }
}

