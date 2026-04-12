package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;

public class EndState implements ComponentMakerState {
    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        return this;
    }

    public boolean isEndState() {
        return true;
    }
}
