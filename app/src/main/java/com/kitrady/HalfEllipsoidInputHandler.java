package com.kitrady;

import java.util.Scanner;

import static java.lang.Math.abs;

public class HalfEllipsoidInputHandler {
    private final double diameterInInches;
    private final double radiusInInches;
    private final double heightInInches;
    private final double stitchGauge;
    private final double roundGauge;
    private final double radiusInStitches;
    private final double radiusInRounds;
    private final double heightInStitches;
    private final double heightInRounds;
    private final double roundHeightInStitches;

    // old to-do: double check that messages are clear
    HalfEllipsoidInputHandler(Scanner input) {
        diameterInInches = abs(handleInput(input,
                "\nEnter the diameter of your half of an ellipsoid in inches: ",
                "\nPlease enter just a number that is the diameter of your half an ellipsoid in inches."));
        input.nextLine();

        heightInInches = abs(handleInput(input,
                "\nEnter the height of your half of an ellipsoid in inches: ",
                "\nPlease enter just a number that is the height of your half an ellipsoid in inches."));
        input.nextLine();

        stitchGauge = abs(handleInput(input,
                "\nEnter your crochet stitch gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet gauge in stitches per inch."));
        input.nextLine();

        roundGauge = abs(handleInput(input,
                "\nEnter your crochet round gauge in rows per inch: ",
                "\nPlease enter just a number that is your crochet round gauge in stitches per inch."));
        input.nextLine();

        radiusInInches = diameterInInches / 2;
        radiusInStitches = radiusInInches * stitchGauge;
        radiusInRounds = radiusInInches * roundGauge;
        heightInStitches = heightInInches * stitchGauge;
        heightInRounds = heightInInches * roundGauge;
        roundHeightInStitches = radiusInStitches / radiusInRounds;
    }

    HalfEllipsoidInputHandler(double diameterInInches, double heightInInches, double stitchGauge, double roundGauge) {
        this.diameterInInches = abs(diameterInInches);
        this.radiusInInches = diameterInInches / 2;
        this.heightInInches = abs(heightInInches);
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);
        radiusInStitches = radiusInInches * stitchGauge;
        radiusInRounds = radiusInInches * roundGauge;
        heightInStitches = heightInInches * stitchGauge;
        heightInRounds = heightInInches * roundGauge;
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

    double getDiameterInInches() {
        return diameterInInches;
    }

    double getHeightInInches() {
        return heightInInches;
    }

    double getStitchGauge() {
        return stitchGauge;
    }

    double getRoundGauge() {
        return roundGauge;
    }

    public double getRadiusInStitches() {
        return radiusInStitches;
    }

    public double getHeightInStitches() {
        return heightInStitches;
    }

    public double getRoundHeightInStitches() {
        return roundHeightInStitches;
    }
}
