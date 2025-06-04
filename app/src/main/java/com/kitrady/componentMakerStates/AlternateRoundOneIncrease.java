package com.kitrady.componentMakerStates;

import com.kitrady.ComponentMakerRoundInfo;
import com.kitrady.ComponentMakerState;
import com.kitrady.ComponentType;
import com.kitrady.RoundComponent;

import java.util.List;

public class AlternateRoundOneIncrease implements ComponentMakerState {

    public ComponentMakerState step(ComponentMakerRoundInfo info) {
        List<RoundComponent> roundComponents = info.getRoundComponents();
        int numSingleCrochetInSection = info.getNumSingleCrochetInSection();
        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;
        int extraStitches = info.getExtraStitches();

        roundComponents.add(new RoundComponent(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET));
        roundComponents.add(new RoundComponent(1, ComponentType.INCREASE));

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
