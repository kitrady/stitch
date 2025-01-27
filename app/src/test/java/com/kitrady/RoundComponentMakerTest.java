package com.kitrady;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RoundComponentMakerTest {
    @Test
    public void testNoIncreases() {
        ArrayList<Integer> stitchesPerRound = new ArrayList<Integer>(List.of(1, 1));
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        assertEquals("Rd 2: sc in each st in round (1)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testAllIncreases() {
        ArrayList<Integer> stitchesPerRound = new ArrayList<Integer>(List.of(2, 4));
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        assertEquals("Rd 2: inc in each st in round (4)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testNoDecreases() {
        ArrayList<Integer> stitchesPerRound = new ArrayList<Integer>(List.of(10, 10));
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        assertEquals("Rd 2: sc in each st in round (10)", maker.getFormattedPattern().getFirst());
    }

    @Test void testAllDecreases() {
        ArrayList<Integer> stitchesPerRound = new ArrayList<Integer>(List.of(4, 2));
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        assertEquals("Rd 2: dec in each st in round (2)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testExtraStitchesForIncrease() {
        ArrayList<Integer> stitchesPerRound = new ArrayList<>(List.of(7, 10));
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 3, 1));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testExtraStitchesForDecrease() {}

    @Test
    public void testNormalFormatForIncrease() {}

    @Test
    public void testNormalFormatForDecrease() {}

    @Test
    public void testAlternateFormatForIncrease() {}

    @Test
    public void testAlternateFormatForDecrease() {}
}
