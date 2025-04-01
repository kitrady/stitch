package com.kitrady;

import java.util.Scanner;

public class InputHelper {
    public static double handleInput(Scanner input, String message, String correctingMessage) {
        double inputVal = 0;
        System.out.print(message);

        while (true) {
            if (input.hasNextDouble()) { // this should prompt the scanner to wait for user input, as there should be nothing ahead of the scanner
                inputVal = input.nextDouble(); // gets the double character from the scanner, leaving the newline character ahead of the scanner
                input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
                return inputVal;
            }

            input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
            System.out.print(correctingMessage);
        }
    }

    public static double handleInputGreaterThanValue(Scanner input, String message, String correctingMessage, double comparisonValue) {
        double inputVal = 0;
        System.out.print(message);

        while (true) {
            if (input.hasNextDouble()) { // this should prompt the scanner to wait for user input, as there should be nothing ahead of the scanner
                inputVal = input.nextDouble(); // gets the double character from the scanner, leaving the newline character ahead of the scanner
            }
            if (Math.abs(inputVal) > comparisonValue) {
                input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
                return inputVal;
            }

            input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
            System.out.print(correctingMessage);
        }
    }
}
