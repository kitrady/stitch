package com.kitrady;

import java.util.Scanner;

public class InputGetter {
    private double radius; // radius of desired sphere in inches
    private double gauge; // gauge of crocheter in stitches per inch
    private double vertGauge; // vertical gauge of crocheter in rows per inch

    public InputGetter(Scanner input) {
        radius = handleRadiusInput(input);
        input.nextLine();
        gauge = handleGaugeInput(input);
        input.nextLine();
        vertGauge = handleVertGaugeInput(input);
        input.nextLine();
    }

    public InputGetter(double radius, double gauge, double vertGauge) {
        this.radius = radius;
        this.gauge = gauge;
        this.vertGauge = vertGauge;
    }

    private double handleRadiusInput(Scanner input) {
        // will loop until input for radius is correct type
        while (true) {
            System.out.print("\nEnter the radius of your sphere in inches: ");

            // logic to ensure input that is received is an int or double but no other type
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine(); // clearing buffer so if statements evaluate properly on subsequent loops

            // further instructions if the received input is incorrect type
            System.out.print("\nPlease enter just a number that is the radius of your sphere in inches.");
        }
    }

    private double handleGaugeInput(Scanner input) {
        // will loop until input for gauge is correct type
        while (true) {
            System.out.print("\nEnter your crochet gauge in stitches per inch: ");

            // logic to ensure input that is received is an int or double but no other type
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine(); // clearing buffer so if statements evaluate properly on subsequent loops

            // further instructions if the received input is incorrect type
            System.out.print("\nPlease enter just a number that is your crochet gauge in stitches per inch.");
        }
    }

    private double handleVertGaugeInput(Scanner input) {
        // will loop until input for vertical gauge is correct type
        while (true) {
            System.out.print("\nEnter your vertical crochet gauge in rows per inch: ");

            // logic to ensure input that is received is an int or double but no other type
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine(); // clearing buffer so if statements evaluate properly on subsequent loops

            // further instructions if the recieved input is incorrect type
            System.out.print("\nPlease enter just a number that is your vertical crochet gauge in stitches per inch.");
        }
    }

    public double getRadius() {
        return radius;
    }

    public double getGauge() {
        return gauge;
    }

    public double getVertGauge() {
        return vertGauge;
    }

    public String toString() {
        return ("\n- Radius = " + radius +
                "\n- Gauge = " + gauge +
                "\n- Vertical gauge = " + vertGauge);
    }
}
