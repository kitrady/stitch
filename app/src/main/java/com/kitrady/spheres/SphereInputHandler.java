package com.kitrady.spheres;

import com.kitrady.InputHandler;
import com.kitrady.InputHelper;
import com.kitrady.ShapeMaker;

import java.util.Scanner;

import static java.lang.Math.*;

public class SphereInputHandler implements InputHandler {
    private final double diameter; // units are inches
    private final double radius; // units are inches
    private final double stitchGauge; // units are stitches per inch
    private final double roundGauge; // units are rows per inch
    private final double radiusInStitches; // units are stitches
    private final double radiusInRounds; // units are rounds
    private final double circumferenceInRounds; // units are rounds
    private final double degreesPerRound;

    public SphereInputHandler(Scanner input) {
        diameter = abs(InputHelper.handleInput(input,
                "\nEnter the diameter of your sphere in inches: ",
                "\nPlease enter just a number that is the diameter of your sphere in inches: "));

        stitchGauge = InputHelper.handleStitchGaugeInput(input);

        roundGauge = InputHelper.handleRoundGaugeInput(input);

        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        circumferenceInRounds = 2 * Math.PI * radiusInRounds;
        degreesPerRound = 360.0 / circumferenceInRounds;
    }

    public SphereInputHandler(double diameter, double stitchGauge, double roundGauge) {
        this.diameter = abs(diameter);
        this.radius = this.diameter / 2;
        this.stitchGauge = abs(stitchGauge);
        this.roundGauge = abs(roundGauge);
        radiusInStitches = radius * stitchGauge;
        radiusInRounds = radius * roundGauge;
        circumferenceInRounds = 2 * Math.PI * radiusInRounds;
        degreesPerRound = 360.0 / circumferenceInRounds;
    }

    public ShapeMaker makeShapeMaker() {
        return new SphereMaker(radiusInStitches, degreesPerRound);
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
}
