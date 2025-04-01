package com.kitrady.elongatedSpheres;

import com.kitrady.ShapeMaker;
import com.kitrady.spheres.SphereMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElongatedSphereMaker implements ShapeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double degreesPerRound;
    private final double cylinderLengthInRounds;

    public ElongatedSphereMaker(double radiusInStitches, double degreesPerRound, double cylinderLengthInRounds) {
        this.radiusInStitches = radiusInStitches;
        this.degreesPerRound = degreesPerRound;
        this.cylinderLengthInRounds = cylinderLengthInRounds;
    }

    public void generateStitchTotals() {
        ShapeMaker sphereMaker = new SphereMaker(radiusInStitches, degreesPerRound);
        stitchesPerRound.addAll(sphereMaker.getStitchesPerRound());

        int maxStitchTotal = Collections.max(stitchesPerRound);
        int startingIndex = stitchesPerRound.lastIndexOf(maxStitchTotal) + 1;

        for (int count = 0; count < cylinderLengthInRounds; count++) {
            stitchesPerRound.add(startingIndex, maxStitchTotal);
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }

    public String toString() {
        return ("\n- Radius in stitches: " + radiusInStitches +
                "\n- Degrees per round: " + degreesPerRound +
                "\n- Cylinder length in rounds: " + cylinderLengthInRounds +
                "\n- Stitches per round: " + stitchesPerRound);
    }
}
