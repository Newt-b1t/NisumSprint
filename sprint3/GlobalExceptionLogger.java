//7

package com.avinash.sprint3;

public class GlobalExceptionLogger {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logException(e);
            }
        });

        System.out.println("Program started");
        throw new RuntimeException("Exception");
    }

    private static void logException(Throwable e) {
        System.out.println("Unhandled Exception: " + e);
        for (StackTraceElement element : e.getStackTrace()) {
            System.out.println("\tat " + element);
        }
    }
}
