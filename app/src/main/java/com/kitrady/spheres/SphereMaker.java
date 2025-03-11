package com.kitrady.spheres;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

public class SphereMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double circumferenceInRounds;
    private final double degreesPerRound;

    public SphereMaker(double radiusInStitches, double circumferenceInRounds) {
        this.radiusInStitches = radiusInStitches;
        this.circumferenceInRounds = circumferenceInRounds;
        degreesPerRound = 360.0 / circumferenceInRounds;
    }

    private void generateStitchTotals() {
        double angle;
        for (angle = (90 - degreesPerRound); angle >= 0; angle -= degreesPerRound) {
            double currentRoundRadiusInStitches = Math.cos(Math.toRadians(angle)) * radiusInStitches;
            double currentRoundCircumferenceInStitches = 6.2831 * currentRoundRadiusInStitches;
            stitchesPerRound.add((int) Math.round(currentRoundCircumferenceInStitches));
        }

        int originalSize = stitchesPerRound.size();
        if (angle + degreesPerRound >= degreesPerRound / 2) {
            stitchesPerRound.add((int) Math.round(6.2831 * radiusInStitches));
        }

        for (int i = 0; i < originalSize; i++) {
            stitchesPerRound.add(stitchesPerRound.get(originalSize - i - 1));
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public double getRadiusInStitches() {
        return radiusInStitches;
    }

    public double getCircumferenceInRounds() {
        return circumferenceInRounds;
    }

    public double getDegreesPerRound() {
        return degreesPerRound;
    }

    public String toString() {
        return ("\n- Radius in stitches = " + radiusInStitches +
                "\n- Circumference in rows = " + circumferenceInRounds +
                "\n- Degrees per round = " + degreesPerRound);
    }
}
