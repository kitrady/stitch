package com.kitrady;

import java.util.Scanner;

public class InputHelper {
    public static double handleInput(Scanner input, String message, String correctingMessage) {
        System.out.print(message);

        while (true) {
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }

            System.out.print(correctingMessage);

            input.nextLine();
            input.nextLine();
        }
    }
}
