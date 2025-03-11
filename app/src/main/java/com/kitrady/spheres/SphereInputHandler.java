package com.kitrady.spheres;

import java.util.Scanner;

import static java.lang.Math.*;

public class SphereInputHandler {
    private final double diameter; // units are inches
    private final double radius; // units are inches
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge; // units are rows per inch
    private final double radiusInStitches; // units are stitches
    private final double radiusInRounds; // units are rounds
    private final double circumferenceInRounds; // units are rounds

    public SphereInputHandler(Scanner input) {
        diameter = abs(handleInput(input,
                "\nEnter the diameter of your sphere in inches: ",
                "\nPlease enter just a number that is the diameter of your sphere in inches."));
        input.nextLine();

        stitchGauge = abs(handleInput(input,
                "\nEnter your crochet gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet gauge in stitches per inch."));
        input.nextLine();

        roundGauge = abs(handleInput(input,
                "\nEnter your vertical crochet gauge in rows per inch: ",
                "\nPlease enter just a number that is your vertical crochet gauge in stitches per inch."));
        input.nextLine();

        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        circumferenceInRounds = 6.2831 * radiusInRounds;
    }

    public SphereInputHandler(double diameter, double stitchGauge, double roundGauge) {
        this.diameter = abs(diameter);
        this.radius = this.diameter / 2;
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
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

    public double getRadius() {
        return radius;
    }

    public double getStitchGauge() {
        return stitchGauge;
    }

    public double getRoundGauge() {
        return roundGauge;
    }

    public double getRadiusInStitches() {
        return radiusInStitches;
    }

    public double getCircumferenceInRounds() {
        return circumferenceInRounds;
    }

    public String toString() {
        return ("\n- Radius = " + radius +
                "\n- Gauge = " + stitchGauge +
                "\n- Vertical gauge = " + roundGauge +
                "\n- Radius in stitches = " + radiusInStitches +
                "\n- Radius in rows = " + radiusInRounds +
                "\n- Circumference in rows = " + circumferenceInRounds);
    }
}
