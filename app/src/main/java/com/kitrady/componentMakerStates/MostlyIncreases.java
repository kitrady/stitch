package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;

public class MostlyIncreases implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        int extraStitches = info.getExtraStitches();

        if (extraStitches == 0) {
            return new AllIncreases();
        } else {
            return new IncreasesAndExtraStitches();
        }
    }
}
