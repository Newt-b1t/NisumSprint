package com.nisum.Question8;

import java.util.Scanner;

public class PrimeSumMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the upper limit (N): ");
        int N = scanner.nextInt();

        System.out.print("Enter number of threads: ");
        int threadCount = scanner.nextInt();

        PrimeSum[] tasks = new PrimeSum[threadCount];
        int rangeSize = N / threadCount;
        int start = 1;

        for (int i = 0; i < threadCount; i++) {
            int end = (i == threadCount - 1) ? N : start + rangeSize - 1;
            tasks[i] = new PrimeSum(start, end);
            tasks[i].start();
            start = end + 1;
        }

        long totalSum = 0;
        for (PrimeSum task : tasks) {
            try {
                task.join();
                totalSum += task.getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum of prime numbers up to " + N + " is: " + totalSum);
    }
}

