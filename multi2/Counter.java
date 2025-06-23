package com.nisum.Question2;

public class Counter {
    public int count = 0;

    public void increment() {
        count++; 
    }

    public synchronized void synchronizedIncrement() {
        count++; 
    }
}

