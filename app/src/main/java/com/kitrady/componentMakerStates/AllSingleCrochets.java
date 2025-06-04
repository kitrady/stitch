package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class AllSingleCrochets implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();

        roundComponents.add(new RoundComponent(0, ComponentType.ALL_SINGLE_CROCHET));
        return new StitchTotal();
    }
}
