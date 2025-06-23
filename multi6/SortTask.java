package com.nisum.Question6;

import java.util.Arrays;

public class SortTask extends Thread {
    private final int[] array;
    private final int start;
    private final int end;

    public SortTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Arrays.sort(array, start, end);
    }
}

