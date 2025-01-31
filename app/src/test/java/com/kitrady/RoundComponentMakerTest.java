package com.kitrady;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RoundComponentMakerTest {
    @Test
    public void testNoIncreases() {
        List<Integer> stitchesPerRound = List.of(1, 1);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 0, 1);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.ALL_SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testAllIncreases() {
        List<Integer> stitchesPerRound = List.of(2, 4);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 0, 4);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.ALL_INCREASE, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testNoDecreases() {
        List<Integer> stitchesPerRound = List.of(10, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 0, 10);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.ALL_SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test void testAllDecreases() {
        List<Integer> stitchesPerRound = List.of(4, 2);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 0, 2);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.ALL_DECREASE, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testExtraStitchesForIncrease() {
        List<Integer> stitchesPerRound = List.of(7, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 1, 1, 3, 1, 10);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testExtraStitchesForDecrease() {
        List<Integer> stitchesPerRound = List.of(10, 7);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 1, 1, 3, 1, 7);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testNormalFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 1, 1, 3, 9);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testNormalFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(9, 6);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 1, 1, 3, 6);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(9, 12);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 1, 1, 2, 1, 2, 1, 12);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForIncreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(18, 21);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);

        List<Integer> counts = List.of(2, 2, 1, 5, 1, 2, 3, 21);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(12, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 1, 1, 2, 1, 2, 1, 9);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForDecreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(21, 18);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);

        List<Integer> counts = List.of(2, 2, 1, 5, 1, 2, 3, 18);
        assertEquals(counts, maker.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.ROUND_NUMBER, ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET, ComponentTypes.STITCH_TOTAL);
        assertEquals(types, maker.getRoundComponentTypes());
    }
}
