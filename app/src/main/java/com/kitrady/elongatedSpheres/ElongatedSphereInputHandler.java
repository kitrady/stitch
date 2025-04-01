package com.kitrady.elongatedSpheres;

import com.kitrady.InputHandler;
import com.kitrady.InputHelper;
import com.kitrady.ShapeMaker;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ElongatedSphereInputHandler implements InputHandler {
    private final double diameter;
    private final double length;
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge;

    private final double radius;
    private final double radiusInRounds;
    private final double circumferenceInRounds;
    private final double cylinderLength;

    private final double radiusInStitches;
    private final double degreesPerRound;
    private final double cylinderLengthInRounds;

    public ElongatedSphereInputHandler(Scanner input) {
        diameter = abs(InputHelper.handleInput(input,
                "\nEnter the diameter, aka the maximum width, of your elongated sphere in inches: ",
                "\nPlease enter just a number that is the diameter/maximum width of your elongated sphere in inches: "));

        length = abs(InputHelper.handleInputGreaterThanValue(input,
                "\nEnter the total length of your elongated sphere in inches (must be larger than the diameter): ",
                "\nPlease enter just a number that is the total length of your elongated sphere in inches and is larger than the diameter you entered: ",
                diameter));

        stitchGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet stitch gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet stitch gauge in stitches per inch: "));

        roundGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet round gauge in rounds per inch: ",
                "\nPlease enter just a number that is your crochet round gauge in rounds per inch: "));

        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        circumferenceInRounds = 2 * Math.PI * radiusInRounds;
        degreesPerRound = 360.0 / circumferenceInRounds;
        cylinderLength = length - diameter;
        cylinderLengthInRounds = cylinderLength * roundGauge;
    }

    public ElongatedSphereInputHandler(double diameter, double length, double stitchGauge, double roundGauge) {
        this.diameter = abs(diameter);
        this.length = abs(length);
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);
        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        circumferenceInRounds = 2 * Math.PI * radiusInRounds;
        degreesPerRound = 360.0 / circumferenceInRounds;
        cylinderLength = length - diameter;
        cylinderLengthInRounds = cylinderLength * roundGauge;
    }

    public ShapeMaker makeShapeMaker() {
        return new ElongatedSphereMaker(radiusInStitches, degreesPerRound, cylinderLengthInRounds);
    }

    public double getDiameter() {
        return diameter;
    }

    public double getLength() {
        return length;
    }

    public double getStitchGauge() {
        return stitchGauge;
    }

    public double getRoundGauge() {
        return roundGauge;
    }
}
