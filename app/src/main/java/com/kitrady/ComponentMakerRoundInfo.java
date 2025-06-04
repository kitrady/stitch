package com.kitrady;

import java.util.ArrayList;
import java.util.List;

public class ComponentMakerRoundInfo {
    private List<RoundComponent> roundComponents = new ArrayList<>();
    private int roundNumber;
    private int previousStitchTotal;
    private int currentStitchTotal;
    private int numIncreases;
    private int numStitchesInSection;
    private int numSingleCrochetInSection;
    private int extraStitches;
    private int alternateRoundToPreventBubblesCounter;

    public ComponentMakerRoundInfo(int roundNumber, int previousStitchTotal, int currentStitchTotal, int alternateRoundToPreventBubblesCounter) {
        this.roundNumber = roundNumber;
        this.previousStitchTotal = previousStitchTotal;
        this.currentStitchTotal = currentStitchTotal;
        numIncreases = currentStitchTotal - previousStitchTotal;

        if (numIncreases != 0) {
            numStitchesInSection = currentStitchTotal / numIncreases;
        }
        numSingleCrochetInSection = numStitchesInSection - 2;

        extraStitches = 0;
        if (numStitchesInSection * numIncreases != currentStitchTotal) {
            extraStitches = currentStitchTotal - (numStitchesInSection * numIncreases);
        }

        this.alternateRoundToPreventBubblesCounter = alternateRoundToPreventBubblesCounter;
    }

    public List<RoundComponent> getRoundComponents() {
        return roundComponents;
    }

    public int getPreviousStitchTotal(){
        return previousStitchTotal;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getCurrentStitchTotal() {
        return currentStitchTotal;
    }

    public int getNumIncreases() {
        return numIncreases;
    }

    public int getNumStitchesInSection() {
        return numStitchesInSection;
    }

    public int getNumSingleCrochetInSection() {
        return numSingleCrochetInSection;
    }

    public int getExtraStitches() {
        return extraStitches;
    }

    public int getAlternateRoundToPreventBubblesCounter() {
        return alternateRoundToPreventBubblesCounter;
    }

    public void incrementAlternateRoundToPreventBubblesCounter() {
        alternateRoundToPreventBubblesCounter++;
    }
}
