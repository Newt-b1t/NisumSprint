package com.nisum.Question10;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockExample {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    static class CounterTask extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new CounterTask();
        Thread t2 = new CounterTask();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
    }
}

