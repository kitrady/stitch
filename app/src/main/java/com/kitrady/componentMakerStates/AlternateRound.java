package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;

public class AlternateRound implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        int numIncreases = info.getNumIncreases();

        if (numIncreases > 1) {
            return new AlternateRoundMultipleIncreases();
        } else {
            return new AlternateRoundOneIncrease();
        }
    }
}
