package com.nisum.Question7;

public class MatrixMultiplication {

    static class MultiplyTask extends Thread {
        private final int[][] A, B, C;
        private final int row;

        public MultiplyTask(int[][] A, int[][] B, int[][] C, int row) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.row = row;
        }

        @Override
        public void run() {
            int colsB = B[0].length;
            int colsA = A[0].length;

            for (int j = 0; j < colsB; j++) {
                C[row][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    C[row][j] += A[row][k] * B[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        // Input matrices
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        int rowsA = A.length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

     
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new MultiplyTask(A, B, result, i);
            threads[i].start();
        }

        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}

