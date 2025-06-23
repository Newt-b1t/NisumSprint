package com.nisum.Question8;

public class PrimeSum extends Thread {
    private final int start;
    private final int end;
    private long partialSum = 0;

    public PrimeSum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (PrimeUtils.isPrime(i)) {
                partialSum += i;
            }
        }
    }
}

