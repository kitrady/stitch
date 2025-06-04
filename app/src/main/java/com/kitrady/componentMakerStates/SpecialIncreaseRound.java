package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class SpecialIncreaseRound implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int previousStitchTotal = info.getPreviousStitchTotal();
        int currentStitchTotal = info.getCurrentStitchTotal();
        int numSpecialIncreases = currentStitchTotal - (previousStitchTotal * 2);
        int numNormalIncreases = previousStitchTotal - numSpecialIncreases;

        roundComponents.add(new RoundComponent(numNormalIncreases, ComponentType.INCREASE));
        roundComponents.add(new RoundComponent(numSpecialIncreases, ComponentType.SPECIAL_INCREASE));
        return new StitchTotal();
    }
}
