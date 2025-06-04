package com.kitrady.circles;

import com.kitrady.ShapeMaker;

import java.util.ArrayList;
import java.util.List;

public class CircleMaker implements ShapeMaker {
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

    public String toString() {
        return ("\n- Radius in rounds: " + radiusInRounds +
                "\n- Round length in stitches: " + roundLengthInStitches +
                "\n- Stitches per round: " + stitchesPerRound);
    }
}
