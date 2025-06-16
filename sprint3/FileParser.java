//5
package com.avinash.sprint3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    public static void main(String[] args) {
        String filePath = "numbers.txt"; // specify your file name here
        parseIntegersFromFile(filePath);
    }

    public static void parseIntegersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                System.out.println("Parsed integer: " + number);
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("An error occurred while reading or parsing the file: " + ex.getMessage());
        }

        System.out.println("End of program.");
    }
}
