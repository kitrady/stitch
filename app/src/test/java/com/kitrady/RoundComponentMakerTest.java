package com.kitrady;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RoundComponentMakerTest {
    @Test
    public void testNoIncreases() {
        List<Integer> stitchesPerRound = List.of(1, 1);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        assertEquals("Rd 2: sc in each st in round (1)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testAllIncreases() {
        List<Integer> stitchesPerRound = List.of(2, 4);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        assertEquals("Rd 2: inc in each st in round (4)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testNoDecreases() {
        List<Integer> stitchesPerRound = List.of(10, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        assertEquals("Rd 2: sc in each st in round (10)", maker.getFormattedPattern().getFirst());
    }

    @Test void testAllDecreases() {
        List<Integer> stitchesPerRound = List.of(4, 2);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        assertEquals("Rd 2: dec in each st in round (2)", maker.getFormattedPattern().getFirst());
    }

    @Test
    public void testExtraStitchesForIncrease() {
        List<Integer> stitchesPerRound = List.of(7, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 3, 1));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testExtraStitchesForDecrease() {
        List<Integer> stitchesPerRound = List.of(10, 7);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 3, 1));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testNormalFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 3));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testNormalFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(9, 6);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 3));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(9, 12);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(1, 1, 2, 1, 2, 1));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForIncreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(18, 21);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);
        RoundComponentAssembler assembler = maker.getAssembler();

        ArrayList<Integer> counts = new ArrayList<>(List.of(2, 1, 5, 1, 2, 3));
        assertEquals(counts, assembler.getRoundComponentCounts());

        ArrayList<ComponentTypes> types = new ArrayList<>(List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET));
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(12, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);
        RoundComponentAssembler assembler = maker.getAssembler();

        List<Integer> counts = List.of(1, 1, 2, 1, 2, 1);
        assertEquals(counts, assembler.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET);
        assertEquals(types, assembler.getRoundComponentTypes());
    }

    @Test
    public void testAlternateFormatForDecreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(21, 18);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);
        RoundComponentAssembler assembler = maker.getAssembler();

        List<Integer> counts = List.of(2, 1, 5, 1, 2, 3);
        assertEquals(counts, assembler.getRoundComponentCounts());

        List<ComponentTypes> types = List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT, ComponentTypes.SINGLE_CROCHET);
        assertEquals(types, assembler.getRoundComponentTypes());
    }
}
