package com.kitrady;

import java.util.ArrayList;
import java.util.List;

public class HalfEllipsoidMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double heightInStitches;
    private final double roundHeightInStitches;

    public HalfEllipsoidMaker(double radiusInStitches, double heightInStitches, double roundHeightInStitches) {
        this.radiusInStitches = radiusInStitches;
        this.heightInStitches = heightInStitches;
        this.roundHeightInStitches = roundHeightInStitches;
    }

    // TODO this currently assumes the half ellipsoid is taller than it is wide (aka assumes height is major axis and radius is minor)
    private void generateStitchTotals() {
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

    // TODO handle case when no x value found
    public double findXForGivenArcLength(double arcLength, double startingX, double semiMajorAxis, double semiMinorAxis) {
        for (double x = startingX; x > 0; x -= 0.01) {
            double angle = findAngleForGivenX(x);
            double calcArcLength = EllipticIntegrals.calculateArcLengthOfEllipse(angle, semiMajorAxis, semiMinorAxis);
            double diff = arcLength - calcArcLength;
            if (Math.abs(diff) < 0.05) {
//                System.out.println("xVal: " + x);
                return x;
            }
        }
//        throw new RuntimeException("Couldn't find xval for arc length");
        return 0;
    }

    public double findAngleForGivenX(double x) {
        return Math.atan(heightInStitches * Math.sqrt(1 - Math.pow(x / radiusInStitches, 2)) / x);
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    double getRadiusInStitches() {
        return radiusInStitches;
    }

    double getHeightInStitches() {
        return heightInStitches;
    }
}
