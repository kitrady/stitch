package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;

public class SomeIncreases implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        int previousStitchTotal = info.getPreviousStitchTotal();
        int currentStitchTotal = info.getCurrentStitchTotal();
        int numSingleCrochetInSection = info.getNumSingleCrochetInSection();

        if (numSingleCrochetInSection == 0) {
            return new MostlyIncreases();
        } else if (currentStitchTotal > (previousStitchTotal * 2)) {
            return new SpecialIncreaseRound();
        } else {
            return new NormalOrAlternateRound();
        }
    }
}
