package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class ExtraStitches implements ComponentMakerState {
    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int extraStitches = info.getExtraStitches();

        roundComponents.add(new RoundComponent(extraStitches, ComponentType.SINGLE_CROCHET));
        return new StitchTotal();
    }
}
