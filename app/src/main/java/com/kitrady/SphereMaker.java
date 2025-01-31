package com.kitrady;

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

public class SphereMaker {
    private final List<Integer> stitchesPerRd = new ArrayList<>();
    private final double radiusInStitches;
    private final double circumferenceInRounds;
    private final double degreesPerRound;

    public SphereMaker(double stRadius, double rowCircumference) {
        this.radiusInStitches = stRadius; // units are stitches
        this.circumferenceInRounds = rowCircumference;  // units are rows
        degreesPerRound = 360.0 / rowCircumference;
    }

    private void generateRounds() {
        // computes stitches per round, starting from top of sphere (aka 90 degrees) and ending at side of sphere (aka 0 degrees)
        // uses degrees per round to increment angle properly
        // no round can be at exact top, so starts with one round offset
        double angle;
        for (angle = (90 - degreesPerRound); angle >= 0; angle -= degreesPerRound) {
            double currentRadius = Math.cos(Math.toRadians(angle)) * radiusInStitches; // finds radius associated with current round/angle using cosine
            double currentCircumference = 6.2831 * currentRadius; // finds circumference associated with current round/angle using circumference formula
            stitchesPerRd.add((int) Math.round(currentCircumference)); // expresses circumference as whole number of stitches and adds to list of stitches per round
        }

        int originalSize = stitchesPerRd.size();
        // if more than half of the angle increment was left, there is a "missing" round
        if (angle + degreesPerRound >= degreesPerRound / 2) {
            stitchesPerRd.add((int) Math.round(6.2831 * radiusInStitches)); // adds "missing" round using an angle of zero, aka full radius
        }
        // since a sphere has identical hemispheres, reverse current stitch counts to get rest of sphere
        for (int i = 0; i < originalSize; i++) {
            stitchesPerRd.add(stitchesPerRd.get(originalSize - i - 1));
        }
    }

    public List<Integer> getStitchesPerRd() {
        generateRounds();
        return stitchesPerRd;
    }

    double getRadiusInStitches() {
        return radiusInStitches;
    }

    double getCircumferenceInRounds() {
        return circumferenceInRounds;
    }

    double getDegreesPerRound() {
        return degreesPerRound;
    }

    public String toString() {
        return ("\n- Radius in stitches = " + radiusInStitches +
                "\n- Circumference in rows = " + circumferenceInRounds +
                "\n- Degrees per round = " + degreesPerRound);
    }
}
