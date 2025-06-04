package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class IncreasesAndExtraStitches implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int numIncreases = info.getNumIncreases();
        int extraStitches = info.getExtraStitches();

        roundComponents.add(new RoundComponent(numIncreases, ComponentType.INCREASE));
        return new ExtraStitches();
    }
}
