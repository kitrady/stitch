package com.kitrady.cones;

import java.util.ArrayList;
import java.util.List;

public class ConeMaker {
    private final List<Integer> stitchesPerRound = new ArrayList<>();
    private final double radiusInStitches;
    private final double lengthInRounds;
    private final double slope;
    private final int totalRounds;

    public ConeMaker(double radiusInStitches, double lengthInRounds) {
        this.radiusInStitches = radiusInStitches;
        this.lengthInRounds = lengthInRounds;
        slope = (int) Math.round(radiusInStitches / lengthInRounds);
        totalRounds = 0; // should be hypotenuse in rounds
        int change  = 0; // need to find change in radius for one round along hypotenuse
    }

    public void generateStitchTotals() {
        // loop should go in reverse, then flip, so know how many stitches are at start based on end
        for (int currentRound = 1; currentRound <= totalRounds; currentRound++) {
            // start with max radius
            // then subtract change in each loop
            // to get current radius, which gives number of stitches
            // until number of rounds has been satified?
            // or I guess could find radius for first round and work in the normal direction
            // which should give the right sized cone if the change is right?
        }
    }
}
