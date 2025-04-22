package com.kitrady.spheres;

import com.kitrady.ShapeMaker;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

public class SphereMaker implements ShapeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double degreesPerRound;

    public SphereMaker(double radiusInStitches, double degreesPerRound) {
        this.radiusInStitches = radiusInStitches;
        this.degreesPerRound = degreesPerRound;
    }

    public void generateStitchTotals() {
        double angle;
        for (angle = (90 - degreesPerRound); angle >= 0; angle -= degreesPerRound) {
            double height = radiusInStitches * Math.sin(Math.toRadians(angle));
            double currentRoundRadiusInStitches = Math.cos(Math.toRadians(angle)) * radiusInStitches;
            double currentRoundCircumferenceInStitches = 2 * Math.PI * currentRoundRadiusInStitches;
            // System.out.println("height: " + height + ", stitches: " + (int) Math.round(currentRoundCircumferenceInStitches));
            stitchesPerRound.add((int) Math.round(currentRoundCircumferenceInStitches));
        }

        int originalSize = stitchesPerRound.size();
        if (angle + degreesPerRound >= degreesPerRound / 2) {
            stitchesPerRound.add((int) Math.round(2 * Math.PI * radiusInStitches));
        }

        for (int i = 0; i < originalSize; i++) {
            stitchesPerRound.add(stitchesPerRound.get(originalSize - i - 1));
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public String toString() {
        return ("\n- Radius in stitches: " + radiusInStitches +
                "\n- Degrees per round: " + degreesPerRound +
                "\n- Stitches per round: " + stitchesPerRound);
    }
}
