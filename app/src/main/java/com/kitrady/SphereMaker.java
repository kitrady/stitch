package com.kitrady;

import java.util.ArrayList;
import java.lang.Math;

public class SphereMaker {
    private ArrayList<Integer> stitchesPerRd = new ArrayList<Integer>(); // array list where index represents round and value is number of stitches in round
    private final double stRadius;
    private final double rowCircumference;
    private final double degreesPerRd;

    public SphereMaker(double stRadius, double rowCircumference) {
        this.stRadius = stRadius; // radius measured in stitches
        this.rowCircumference = rowCircumference;  // circumference measured in rows
        degreesPerRd = 360.0 / rowCircumference; // divides 360 degrees in circumference by rows in circumference to get degrees per row
    }

    private void generateRounds() {
        // computes stitches per round, starting from top of sphere (aka 90 degrees) and ending at side of sphere (aka 0 degrees)
        // uses degrees per round to increment angle properly
        // no round can be at exact top, so starts with one round offset
        double angle;
        for (angle = (90 - degreesPerRd); angle >= 0; angle -= degreesPerRd) {
            double currentRadius = Math.cos(Math.toRadians(angle)) * stRadius; // finds radius associated with current round/angle using cosine
            double currentCircumference = 6.2831 * currentRadius; // finds circumference associated with current round/angle using circumference formula
            stitchesPerRd.add((int) Math.round(currentCircumference)); // expresses circumference as whole number of stitches and adds to list of stitches per round
        }

        int originalSize = stitchesPerRd.size();
        // if more than half of the angle increment was left, there is a "missing" round
        if (angle + degreesPerRd >= degreesPerRd / 2) {
            stitchesPerRd.add((int) Math.round(6.2831 * stRadius)); // adds "missing" round using an angle of zero, aka full radius
        }
        // since a sphere has identical hemispheres, reverse current stitch counts to get rest of sphere
        for (int i = 0; i < originalSize; i++) {
            stitchesPerRd.add(stitchesPerRd.get(originalSize - i - 1));
        }
    }

    public ArrayList<Integer> getStitchesPerRd() {
        generateRounds();
        return stitchesPerRd;
    }

    public String toString() {
        return ("\n- Radius in stitches = " + stRadius +
                "\n- Circumference in rows = " + rowCircumference +
                "\n- Degrees per round = " + degreesPerRd);
    }
}
