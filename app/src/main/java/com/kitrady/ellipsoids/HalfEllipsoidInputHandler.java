package com.kitrady.ellipsoids;

import com.kitrady.InputHandler;
import com.kitrady.InputHelper;
import com.kitrady.ShapeMaker;

import java.util.Scanner;

import static java.lang.Math.abs;

public class HalfEllipsoidInputHandler implements InputHandler {
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
    public HalfEllipsoidInputHandler(Scanner input) {
        diameterInInches = abs(InputHelper.handleInput(input,
                "\nEnter the diameter of your half of an ellipsoid in inches: ",
                "\nPlease enter just a number that is the diameter of your half an ellipsoid in inches."));
        input.nextLine();

        heightInInches = abs(InputHelper.handleInput(input,
                "\nEnter the height of your half of an ellipsoid in inches: ",
                "\nPlease enter just a number that is the height of your half an ellipsoid in inches."));
        input.nextLine();

        stitchGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet stitch gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet gauge in stitches per inch."));
        input.nextLine();

        roundGauge = abs(InputHelper.handleInput(input,
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

    public HalfEllipsoidInputHandler(double diameterInInches, double heightInInches, double stitchGauge, double roundGauge) {
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

    public ShapeMaker makeShapeMaker() {
        return new HalfEllipsoidMaker(radiusInStitches, heightInStitches, roundHeightInStitches);
    }

    public double getDiameterInInches() {
        return diameterInInches;
    }

    public double getHeightInInches() {
        return heightInInches;
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

    public double getHeightInStitches() {
        return heightInStitches;
    }

    public double getRoundHeightInStitches() {
        return roundHeightInStitches;
    }
}
