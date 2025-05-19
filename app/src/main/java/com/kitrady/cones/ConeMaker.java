package com.kitrady.cones;

import com.kitrady.ShapeMaker;
import java.util.ArrayList;
import java.util.List;

public class ConeMaker implements ShapeMaker {
    private List<Integer> stitchesPerRound = new ArrayList<>();
    private final boolean startFromSmallEnd;
    private final double radiusInStitches;
    private final double changeInRadiusPerOneRound;

    public ConeMaker(boolean startFromSmallEnd, double radiusInStitches, double changeInRadiusPerOneRound) {
        this.startFromSmallEnd = startFromSmallEnd;
        this.radiusInStitches = radiusInStitches;
        this.changeInRadiusPerOneRound = changeInRadiusPerOneRound;
    }

    public void generateStitchTotals() {
        for (double currentRadius = radiusInStitches; currentRadius >= 4 / (2 * Math.PI); currentRadius -= changeInRadiusPerOneRound) {
            int currentCircumferenceInStitches = (int) Math.round(2 * Math.PI * currentRadius);
            if (currentCircumferenceInStitches > 4) {
                stitchesPerRound.add(currentCircumferenceInStitches);
            }
        }

        if (startFromSmallEnd) {
            stitchesPerRound = stitchesPerRound.reversed();
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public String toString() {
        return ("\n- Start from small end: " + startFromSmallEnd +
                "\n- Radius in stitches: " + radiusInStitches +
                "\n- Change in radius per one round: " + changeInRadiusPerOneRound +
                "\n- stitches per round: " + stitchesPerRound);
    }
}
