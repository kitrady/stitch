package com.kitrady.cones;

import com.kitrady.ShapeMaker;
import java.util.ArrayList;
import java.util.List;

public class ConeMaker implements ShapeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double changeInRadiusPerOneRound;
    private final double changeInLengthPerOneRound;

    public ConeMaker(double radiusInStitches, double changeInRadiusPerOneRound, double changeInLengthPerOneRound) {
        this.radiusInStitches = radiusInStitches;
        this.changeInRadiusPerOneRound = changeInRadiusPerOneRound;
        this.changeInLengthPerOneRound = changeInLengthPerOneRound;

    }

    public void generateStitchTotals() {
        double height = changeInLengthPerOneRound;
        for (double currentRadius = changeInRadiusPerOneRound; currentRadius <= radiusInStitches; currentRadius += changeInRadiusPerOneRound) {
            System.out.println("Radius: " + currentRadius + ", Height: " + height);
            height += changeInLengthPerOneRound;
            int currentCircumferenceInStitches = (int) Math.round(2 * Math.PI * currentRadius);
            stitchesPerRound.add(currentCircumferenceInStitches);
        }
    }

    public List<Integer> getStitchesPerRound() {
        generateStitchTotals();
        return stitchesPerRound;
    }
}
