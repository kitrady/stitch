package com.kitrady.cones;

import com.kitrady.ShapeMaker;

import java.util.ArrayList;
import java.util.List;

public class ConeMaker implements ShapeMaker {
    private List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double changeInRadiusPerOneRound;

    public ConeMaker(double radiusInStitches, double changeInRadiusPerOneRound) {
        this.radiusInStitches = radiusInStitches;
        this.changeInRadiusPerOneRound = changeInRadiusPerOneRound;
    }

    public void generateStitchTotals() {
        for (double currentRadius = radiusInStitches; currentRadius >= 4 / (2 * Math.PI); currentRadius -= changeInRadiusPerOneRound) {
            int currentCircumferenceInStitches = (int) Math.round(2 * Math.PI * currentRadius);
            stitchesPerRound.add(currentCircumferenceInStitches);
        }

        stitchesPerRound = stitchesPerRound.reversed();
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public String toString() {
        return ("\n- Radius in stitches: " + radiusInStitches +
                "\n- Change in radius per one round: " + changeInRadiusPerOneRound +
                "\n- stitches per round: " + stitchesPerRound);
    }
}
