package com.avinash.sprint3;

//public class CounterExample {
//
//    static int counter = 0;
//
//    public static void main(String[] args) {
//        Runnable incrementTask = () -> {
//            for (int i = 0; i < 1000; i++) {
//                counter++;
//            }
//        };
//
//        Thread t1 = new Thread(incrementTask);
//        Thread t2 = new Thread(incrementTask);
//
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join(); // wait for t1 to finish
//            t2.join(); // wait for t2 to finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Counter without synchronization: " + counter);
//    }
//}
public class CounterExampleSync {

    static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        try {
            t1.join(); // wait for t1 to finish
            t2.join(); // wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter with synchronization: " + counter);
    }
}
