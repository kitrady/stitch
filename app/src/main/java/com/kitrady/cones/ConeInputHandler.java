package com.kitrady.cones;

import com.kitrady.InputHandler;
import com.kitrady.InputHelper;
import com.kitrady.ShapeMaker;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ConeInputHandler implements InputHandler {
    private final double diameter; // units are inches
    private final double length; // units are inches
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge; // units are rows per inch

    private final double radius; // units are inches
    private final double radiusInRounds;
    private final double lengthInRounds;
    private final double sideLengthInRounds;

    private final double radiusInStitches;
    private final double changeInRadiusPerOneRound;

    public ConeInputHandler(Scanner input) {
        diameter = abs(InputHelper.handleInput(input,
                "\nEnter the diameter, aka the maximum width, of your cone in inches: ",
                "\nPlease enter just a number that is the diameter/maximum width of your cone in inches: "));

        length = abs(InputHelper.handleInput(input,
                "\nEnter the length of your cone in inches: ",
                "\nPlease enter just a number that is the length of your come in inches: "));

        stitchGauge = InputHelper.handleStitchGaugeInput(input);

        roundGauge = InputHelper.handleRoundGaugeInput(input);

        radius = diameter / 2;
        radiusInRounds = radius * roundGauge;
        lengthInRounds = length * roundGauge;
        sideLengthInRounds = Math.sqrt(Math.pow(radiusInRounds, 2) + Math.pow(lengthInRounds, 2));

        radiusInStitches = radius * stitchGauge;
        changeInRadiusPerOneRound = radiusInStitches / sideLengthInRounds;
    }

    public ConeInputHandler(double diameter, double length, double stitchGauge, double roundGauge) {
        this.diameter = abs(diameter);
        this.length = abs(length);
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);

        radius = diameter / 2;
        radiusInRounds = radius * roundGauge;
        lengthInRounds = length * roundGauge;
        sideLengthInRounds = Math.sqrt(Math.pow(radiusInRounds, 2) + Math.pow(lengthInRounds, 2));

        radiusInStitches = radius * stitchGauge;
        changeInRadiusPerOneRound = radiusInStitches / sideLengthInRounds;

    }

    public ShapeMaker makeShapeMaker() {
        double lengthInStitches = length * stitchGauge;
        double changeInLengthPerOneRound = lengthInStitches / sideLengthInRounds;
        return new ConeMaker(radiusInStitches, changeInRadiusPerOneRound);
    }

    public double getDiameterInInches() {
        return diameter;
    }

    public double getLengthInInches() {
        return length;
    }

    public double getStitchGauge() {
        return stitchGauge;
    }

    public double getRoundGauge() {
        return roundGauge;
    }
}
