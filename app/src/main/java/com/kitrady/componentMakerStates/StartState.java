package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class StartState implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int roundNumber = info.getRoundNumber();
        int numIncreases = info.getNumIncreases();

        roundComponents.add(new RoundComponent(roundNumber, ComponentType.ROUND_NUMBER));

        if (numIncreases == 0) {
            return new AllSingleCrochets();
        } else {
            return new SomeIncreases();
        }
    }
}
