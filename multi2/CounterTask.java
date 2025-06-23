package com.nisum.Question2;

public class CounterTask extends Thread {
    private final Counter counter;
    private final boolean useSync;

    public CounterTask(Counter counter, boolean useSync) {
        this.counter = counter;
        this.useSync = useSync;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (useSync) {
                counter.synchronizedIncrement();
            } else {
                counter.increment();
            }
        }
    }
}

