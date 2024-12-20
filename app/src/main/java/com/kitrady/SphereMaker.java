package com.kitrady;

import java.util.ArrayList;
import java.lang.Math;

public class SphereMaker {
    // array list where index represents row and value is number of stitches in row
    ArrayList<Integer> stitchesPerRow = new ArrayList<Integer>();

    private final double stRadius;
    private final double rowCircumference;
    private final double degreesPerRow;

    public SphereMaker(double stRadius, double rowCircumference) {
        this.stRadius = stRadius; // radius measured in stitches
        this.rowCircumference = rowCircumference;  // circumference measured in rows
        degreesPerRow = 360.0 / rowCircumference; // divides 360 degrees in circumference by rows in circumference to get degrees per row
    }

    private void generateRows() {
        // computes stitches per row, starting from top of sphere (aka 90 degrees) and ending at side of sphere (aka 0 degrees)
        // uses degrees per row to increment angle properly
        // no row can be at exact top, so starts with one row offset
        double angle;
        for (angle = (90 - degreesPerRow); angle >= 0; angle -= degreesPerRow) {
            double currentRadius = Math.cos(Math.toRadians(angle)) * stRadius; // finds radius associated with current row/angle using cosine
            double currentCircumference = 6.2831 * currentRadius; // finds circumference associated with current row/angle using circumference formula
            stitchesPerRow.add((int) Math.round(currentCircumference)); // expresses circumference as whole number of stitches and adds to list of stitches per row
        }

        int originalSize = stitchesPerRow.size();
        // if more than half of the angle increment was left, there is a "missing" row
        if (angle + degreesPerRow >= degreesPerRow / 2) {
            stitchesPerRow.add((int) Math.round(6.2831 * stRadius)); // adds "missing" row using an angle of zero, aka full radius
        }
        // since a sphere has identical hemispheres, reverse current stitch counts to get rest of sphere
        for (int i = 0; i < originalSize; i++) {
            stitchesPerRow.add(stitchesPerRow.get(originalSize - i - 1));
        }
    }

    public void printRows() {
        generateRows();
        for (int i = 0; i < stitchesPerRow.size(); i++) {
            System.out.print("\nRow " + (i + 1) + ": " + stitchesPerRow.get(i) + " stitches");
        }
    }

    public String toString() {
        return ("\n- Radius in stitches = " + stRadius +
                "\n- Circumference in rows = " + rowCircumference +
                "\n- Degrees per row = " + degreesPerRow);
    }
}
