package com.kitrady;

import java.util.Scanner;

import static java.lang.Math.*;

public class InputHandler {
    private final double radius; // units are inches
    private final double gauge; // units are stitches per inch
    private final double vertGauge; // units are rows per inch
    private final double radiusInStitches; // units are stitches
    private final double radiusInRounds; // units are rounds
    private final double circumferenceInRounds; // units are rounds

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

        radiusInStitches = radius * gauge;
        radiusInRounds = radius * vertGauge;
        circumferenceInRounds = 6.2831 * radiusInRounds;
    }

    public InputHandler(double radius, double gauge, double vertGauge) {
        this.radius = abs(radius);
        this.gauge = abs(gauge);
        this.vertGauge = abs(vertGauge);
        radiusInStitches = radius * gauge;
        radiusInRounds = radius * vertGauge;
        circumferenceInRounds = 6.2831 * radiusInRounds;
    }

    private double handleInput(Scanner input, String message, String correctingMessage) {
        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine();

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

    public double getRadiusInStitches() {
        return radiusInStitches;
    }

    public double getCircumferenceInRounds() {
        return circumferenceInRounds;
    }

    public String toString() {
        return ("\n- Radius = " + radius +
                "\n- Gauge = " + gauge +
                "\n- Vertical gauge = " + vertGauge +
                "\n- Radius in stitches = " + radiusInStitches +
                "\n- Radius in rows = " + radiusInRounds +
                "\n- Circumference in rows = " + circumferenceInRounds);
    }
}
