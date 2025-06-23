package com.nisum.Question5;

public class CounterTask extends Thread {
    private final Runnable action;

    public CounterTask(Runnable action) {
        this.action = action;
    }

    @Override
    public void run() {
        action.run();
    }
}

