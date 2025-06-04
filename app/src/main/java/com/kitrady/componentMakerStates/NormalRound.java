package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class NormalRound implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int numSingleCrochetInSection = info.getNumSingleCrochetInSection();
        int numIncreases = info.getNumIncreases();
        int extraStitches = info.getExtraStitches();

        roundComponents.add(new RoundComponent(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET));
        roundComponents.add(new RoundComponent(1, ComponentType.REPEAT_INCREASE));
        roundComponents.add(new RoundComponent(numIncreases, ComponentType.REPEAT_COUNT));

        info.incrementAlternateRoundToPreventBubblesCounter();

        if (extraStitches > 0) {
            return new ExtraStitches();
        } else {
            return new StitchTotal();
        }
    }
}
