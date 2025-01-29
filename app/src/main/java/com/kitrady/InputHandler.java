package com.kitrady;

import java.util.Scanner;

import static java.lang.Math.*;

public class InputHandler {
    private final double radius; // radius of desired sphere in inches
    private final double gauge; // gauge of crocheter in stitches per inch
    private final double vertGauge; // vertical gauge of crocheter in rows per inch
    private final double stRadius; // converts the radius from inches to stitches using gauge
    private final double rowRadius; // creates a vertical radius measured in rows using radius in inches and vertical gauge in rows per inch
    private final double rowCircumference; // creates a vertical circumference measured in rows using vertical radius measured in rows

    public InputHandler(Scanner input) {
        radius = abs(handleInput(input,
                "\nEnter the radius of your sphere in inches: ",
                "\nPlease enter just a number that is the radius of your sphere in inches."));
        input.nextLine();

        gauge = abs(handleInput(input,
                "\nEnter your crochet gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet gauge in stitches per inch."));
        input.nextLine();

        vertGauge = abs(handleInput(input,
                "\nEnter your vertical crochet gauge in rows per inch: ",
                "\nPlease enter just a number that is your vertical crochet gauge in stitches per inch."));
        input.nextLine();

        stRadius = radius * gauge;
        rowRadius = radius * vertGauge;
        rowCircumference = 6.2831 * rowRadius;
    }

    public InputHandler(double radius, double gauge, double vertGauge) {
        this.radius = abs(radius);
        this.gauge = abs(gauge);
        this.vertGauge = abs(vertGauge);
        stRadius = radius * gauge;
        rowRadius = radius * vertGauge;
        rowCircumference = 6.2831 * rowRadius;
    }

    private double handleInput(Scanner input, String message, String correctingMessage) {
        // will loop until input is correct type
        while (true) {
            System.out.print(message);

            // logic to ensure input that is received is an int or double but no other type
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine(); // clearing buffer so if statements evaluate properly on subsequent loops

            // further instructions if the received input is incorrect type
            System.out.print(correctingMessage);
        }
    }

    double getRadius() {
        return radius;
    }

    double getGauge() {
        return gauge;
    }

    double getVertGauge() {
        return vertGauge;
    }

    public double getStRadius() {
        return stRadius;
    }

    public double getRdCircumference() {
        return rowCircumference;
    }

    public String toString() {
        return ("\n- Radius = " + radius +
                "\n- Gauge = " + gauge +
                "\n- Vertical gauge = " + vertGauge +
                "\n- Radius in stitches = " + stRadius +
                "\n- Radius in rows = " + rowRadius +
                "\n- Circumference in rows = " + rowCircumference);
    }
}
