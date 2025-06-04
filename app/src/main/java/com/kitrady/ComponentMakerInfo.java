package com.kitrady;

import java.util.ArrayList;
import java.util.List;

public class ComponentMakerInfo {
    private List<RoundComponent> roundComponents = new ArrayList<>();
    private int roundNumber;
    private int numIncreases;
    private int numStitchesInSection;
    private int numSingleCrochetInSection;
    private int extraStitches;
    private int numSpecialIncreasesNeeded;
    private int numNormalIncreases;

    public ComponentMakerInfo(int roundNumber, int previousStitchTotal, int currentStitchTotal) {
        this.roundNumber = roundNumber;
        numIncreases = currentStitchTotal - previousStitchTotal;

        if (numIncreases != 0) {
            numStitchesInSection = currentStitchTotal / numIncreases;
        }
        numSingleCrochetInSection = numStitchesInSection - 2;

        extraStitches = 0;
        if (numStitchesInSection * numIncreases != currentStitchTotal) {
            extraStitches = currentStitchTotal - (numStitchesInSection * numIncreases);
        }

        numSpecialIncreasesNeeded = currentStitchTotal - (previousStitchTotal * 2);
        numNormalIncreases = previousStitchTotal - numSpecialIncreasesNeeded;
    }

    public int getRoundNumber
}
