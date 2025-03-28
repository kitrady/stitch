package com.kitrady.circles;

import java.util.Scanner;

import static java.lang.Math.abs;

public class CircleInputHandler {
    private final double diameter; // units are inches
    private final double radius; // units are inches
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge; // units are rows per inch
    private final double radiusInStitches; // units are stitches
    private final double radiusInRounds; // units are rounds
    private final double roundHeightInStitches;

    public CircleInputHandler(Scanner input) {
        diameter = abs(handleInput(input,
                "\nEnter the diameter of your circle in inches: ",
                "\nPlease enter just a number that is the diameter of your circle in inches."));
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
        roundHeightInStitches = radiusInStitches / radiusInRounds;
    }

    public CircleInputHandler(double diameter, double stitchGauge, double roundGauge) {
        this.diameter = abs(diameter);
        this.radius = this.diameter / 2;
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        roundHeightInStitches = radiusInStitches / radiusInRounds;
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

    public double getDiameterInInches() {
        return diameter;
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

    public double getRoundHeightInStitches() {
        return roundHeightInStitches;
    }
}
