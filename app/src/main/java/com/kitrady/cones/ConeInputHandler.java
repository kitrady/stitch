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

    private final double radius;

    private final double radiusInStitches;
    private final double lengthInRounds;

    public ConeInputHandler(Scanner input) {
        diameter = abs(InputHelper.handleInput(input,
                "\nEnter the diameter, aka the maximum width of your cone in inches: ",
                "\nPlease enter just a number that is the diameter/maximum width of your cone in inches: "));

        length = abs(InputHelper.handleInput(input,
                "\nEnter the length of your cone in inches: ",
                "\nPlease enter just a number that is the length of your come in inches: "));

        stitchGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet stitch gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet stitch gauge in stitches per inch: "));

        roundGauge = abs(InputHelper.handleInput(input,
                "\nEnter your crochet round gauge in rounds per inch: ",
                "\nPlease enter just a number that is your crochet round gauge in rounds per inch: "));

        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        lengthInRounds = length * roundGauge;
    }

    public ConeInputHandler(double diameter, double length, double stitchGauge, double roundGauge) {
        this.diameter = diameter;
        this.length = length;
        this.stitchGauge = stitchGauge;
        this.roundGauge = roundGauge;

        radius = diameter / 2;
        radiusInStitches = radius * stitchGauge;
        lengthInRounds = length * roundGauge;
    }

    public ShapeMaker makeShapeMaker() {

    }
}
