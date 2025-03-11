package com.kitrady.circles;

import java.util.ArrayList;
import java.util.List;

public class CircleMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInRounds;
    private final double roundLengthInStitches;

    public CircleMaker(double radiusInRounds, double roundLengthInStitches) {
        this.radiusInRounds = radiusInRounds;
        this.roundLengthInStitches = roundLengthInStitches;
    }

    private void generateStitchTotals() {
        for (int currentRadiusInRounds = 1; currentRadiusInRounds <= radiusInRounds; currentRadiusInRounds++) {
            double currentRadiusInStitches = roundLengthInStitches * currentRadiusInRounds;
            double currentRoundCircumferenceInStitches = (2 * Math.PI * currentRadiusInStitches);
            stitchesPerRound.add((int) Math.round(currentRoundCircumferenceInStitches));
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public double getRadiusInRounds() {
        return radiusInRounds;
    }

    public double getRoundLengthInStitches() {
        return roundLengthInStitches;
    }
}
