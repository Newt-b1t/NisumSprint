//8
package com.avinash.sprint3;
import java.util.concurrent.Callable;

public class RetryUtility {

    public static <T> T retry(Callable<T> operation, int maxRetries, long initialDelayMillis) throws Exception {
        int attempts = 0;
        long delay = initialDelayMillis;

        while (true) {
            try {
                return operation.call();
            } catch (Exception e) {
                attempts++;
                if (attempts > maxRetries) {
                    throw new Exception("Operation failed after " + maxRetries + " retries", e);
                }
                System.out.println("Attempt " + attempts + " failed: " + e.getMessage());
                System.out.println("Retrying in " + delay + " milliseconds...");
                Thread.sleep(delay);
                delay *= 2;  // Exponential backoff
            }
        }
    }

    public static void main(String[] args) {
        Callable<String> networkCall = () -> {
            if (Math.random() < 0.7) {  // 70% failure chance
                throw new RuntimeException("Network error");
            }
            return "Success!";
        };

        try {
            String result = retry(networkCall, 5, 1000);
            System.out.println("Operation result: " + result);
        } catch (Exception e) {
            System.out.println("Operation ultimately failed: " + e.getMessage());
        }
    }
}

