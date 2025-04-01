package com.kitrady.circles;

import com.kitrady.InputHandler;
import com.kitrady.InputHelper;
import com.kitrady.ShapeMaker;
import java.util.Scanner;
import static java.lang.Math.abs;

public class CircleInputHandler implements InputHandler {
    private final double diameter; // units are inches
    private final double radius; // units are inches
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge; // units are rows per inch
    private final double radiusInStitches; // units are stitches
    private final double radiusInRounds; // units are rounds
    private final double roundHeightInStitches;

    public CircleInputHandler(Scanner input) {
        diameter = abs(InputHelper.handleInput(input,
                "\nEnter the diameter of your circle in inches: ",
                "\nPlease enter just a number that is the diameter of your circle in inches: "));

        stitchGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet stitch gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet stitch gauge in stitches per inch: "));

        roundGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet round gauge in rounds per inch: ",
                "\nPlease enter just a number that is your crochet round gauge in rounds per inch: "));

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

    public ShapeMaker makeShapeMaker() {
        return new CircleMaker(radiusInRounds, roundHeightInStitches);
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
