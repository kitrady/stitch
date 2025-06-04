package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class AlternateRoundMultipleIncreases implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int numSingleCrochetInSection = info.getNumSingleCrochetInSection();
        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;
        int numIncreases = info.getNumIncreases();
        int extraStitches = info.getExtraStitches();

        if (numSingleCrochetInHalfSection > 0) {
            roundComponents.add(new RoundComponent(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET));
        }

        roundComponents.add(new RoundComponent(1, ComponentType.INCREASE));

        roundComponents.add(new RoundComponent(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET));
        roundComponents.add(new RoundComponent(1, ComponentType.REPEAT_INCREASE));
        roundComponents.add(new RoundComponent(numIncreases - 1, ComponentType.REPEAT_COUNT));

        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
            numSingleCrochetInHalfSection++;
        }
        roundComponents.add(new RoundComponent(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET));

        info.incrementAlternateRoundToPreventBubblesCounter();

        if (extraStitches > 0) {
            return new ExtraStitches();
        } else {
            return new StitchTotal();
        }
    }
}
