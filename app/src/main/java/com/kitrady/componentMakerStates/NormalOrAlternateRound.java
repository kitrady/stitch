package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;

public class NormalOrAlternateRound implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        int alternateRoundToPreventBubblesCounter = info.getAlternateRoundToPreventBubblesCounter();

        if (alternateRoundToPreventBubblesCounter % 2 == 0) {
            return new AlternateRound();
        } else {
            return new NormalRound();
        }
    }
}
