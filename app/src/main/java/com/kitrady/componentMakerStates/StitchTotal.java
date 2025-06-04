package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;
import java.util.List;

public class StitchTotal implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int currentStitchTotal = info.getCurrentStitchTotal();

        roundComponents.add(new RoundComponent(currentStitchTotal, ComponentType.STITCH_TOTAL));
        return new EndState();
    }
}
