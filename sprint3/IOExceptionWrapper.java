//4
package com.avinash.sprint3;

import java.io.IOException;
import java.io.UncheckedIOException;

public class IOExceptionWrapper {

    @FunctionalInterface
    public interface IOConsumer<T> {
        void accept(T t) throws IOException;
    }

    public static <T> void wrapIOConsumer(T input, IOConsumer<T> consumer) {
        try {
            consumer.accept(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        wrapIOConsumer("some input", input -> {
            // Imagine this is a legacy API call that can throw IOException
            if (input.equals("some input")) {
                throw new IOException("Legacy API error");
            }
            System.out.println("Processed input: " + input);
        });

        System.out.println("Program completed successfully.");
    }
}
