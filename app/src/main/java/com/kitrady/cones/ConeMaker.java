package com.kitrady.cones;

import com.kitrady.ShapeMaker;

import java.util.ArrayList;
import java.util.List;

public class ConeMaker implements ShapeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double changeInRadiusPerOneRound;

    public ConeMaker(double radiusInStitches, double changeInRadiusPerOneRound) {
        this.radiusInStitches = radiusInStitches;
        this.changeInRadiusPerOneRound = changeInRadiusPerOneRound;
    }

    public void generateStitchTotals() {
        for (double currentRadius = changeInRadiusPerOneRound; currentRadius <= radiusInStitches; currentRadius += changeInRadiusPerOneRound) {
            int currentCircumferenceInStitches = (int) Math.round(2 * Math.PI * currentRadius);
            stitchesPerRound.add(currentCircumferenceInStitches);
        }
    }
}
