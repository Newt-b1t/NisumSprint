package com.nisum.Question5;

public class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++; // Thread-safe
    }

    public int getValue() {
        return count;
    }
}

