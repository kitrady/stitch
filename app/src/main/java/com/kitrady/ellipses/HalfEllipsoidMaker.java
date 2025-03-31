package com.kitrady.ellipses;

import com.kitrady.ShapeMaker;

import java.util.ArrayList;
import java.util.List;

public class HalfEllipsoidMaker implements ShapeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double heightInStitches;
    private final double roundHeightInStitches;

    public HalfEllipsoidMaker(double radiusInStitches, double heightInStitches, double roundHeightInStitches) {
        this.radiusInStitches = radiusInStitches;
        this.heightInStitches = heightInStitches;
        this.roundHeightInStitches = roundHeightInStitches;
    }

    // old to-do: this currently assumes the half ellipsoid is taller than it is wide (aka assumes height is major axis and radius is minor)
    public void generateStitchTotals() {
        // due to how elliptic integrals work, must generate largest round with largest x value first, then work inward
        // hence why currentRoundRadiusInStitches is set to the overall radius, and while loop goes until current radius is zero
        double currentRoundRadiusInStitches = radiusInStitches;
        int count = 1;
        while (currentRoundRadiusInStitches > 0) {
            currentRoundRadiusInStitches = findXForGivenArcLength(roundHeightInStitches * count, currentRoundRadiusInStitches, heightInStitches, radiusInStitches);
//            double currentRoundHeightInStitches = heightInStitches * Math.sqrt(1 - Math.pow(currentRoundRadiusInStitches / radiusInStitches, 2));
//            System.out.println("yVal: " + currentRoundHeightInStitches);
            double currentRoundCircumferenceInStitches = 2 * Math.PI * currentRoundRadiusInStitches;
            stitchesPerRound.add((int) Math.round(currentRoundCircumferenceInStitches));
            count++;
        }
    }

    // old to-do: handle case when no x value found
    // takes given arc length and finds corresponding x value, starting from given x value
    public double findXForGivenArcLength(double arcLength, double startingX, double semiMajorAxis, double semiMinorAxis) {
        // since integral starts at angle = 0, x therefore starts at radius and decreases until calculated arc length matches given arc length
        for (double x = startingX; x > 0; x -= 0.01) { // chosen increment is 0.01
            double angle = findAngleForGivenX(x);
            double calcArcLength = EllipticIntegrals.calculateArcLengthOfEllipse(angle, semiMajorAxis, semiMinorAxis);
            double diff = arcLength - calcArcLength;
            if (Math.abs(diff) < 0.05) { // chosen tolerance for arc length is 0.05
//                System.out.println("xVal: " + x);
                return x;
            }
        }
//        throw new RuntimeException("Couldn't find xval for arc length");
        return 0; // return zero if no value found
    }

    // uses tan(theta) = y / x and y = h (1 - (x/r)^2)^1/2 to find angle from x val and radius and height stored in instance variables
    public double findAngleForGivenX(double x) {
        return Math.atan(heightInStitches * Math.sqrt(1 - Math.pow(x / radiusInStitches, 2)) / x);
    }

    public void printPattern() {
        generateStitchTotals();
        for (int total : stitchesPerRound) {
            System.out.println(total);
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public double getRadiusInStitches() {
        return radiusInStitches;
    }

    public double getHeightInStitches() {
        return heightInStitches;
    }
}
