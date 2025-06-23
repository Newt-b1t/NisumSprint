package com.nisum.Question6;

import java.util.Arrays;

public class MergeSortMain {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 8, 1, 4, 7, 6, 3, 0};

        int mid = array.length / 2;

        SortTask t1 = new SortTask(array, 0, mid);
        SortTask t2 = new SortTask(array, mid, array.length);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Merge sorted halves
        int[] sorted = merge(array, 0, mid, array.length);

        System.out.println("Sorted Array (Multi-threaded): " + Arrays.toString(sorted));
    }

    private static int[] merge(int[] arr, int left, int mid, int right) {
        int[] merged = new int[right - left];
        int i = left, j = mid, k = 0;

        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i < mid) {
            merged[k++] = arr[i++];
        }

        while (j < right) {
            merged[k++] = arr[j++];
        }

        return merged;
    }
}
