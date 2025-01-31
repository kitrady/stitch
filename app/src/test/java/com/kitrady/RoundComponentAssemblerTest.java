package com.kitrady;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoundComponentAssemblerTest {
    @Test
    public void testSingleCrochetThenIncreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" 3 sc, inc", assembler.assemble());
    }

    @Test
    public void testSingleCrochetThenDecreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.SINGLE_CROCHET, ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" 3 sc, dec", assembler.assemble());
    }

    @Test
    public void testIncreaseAndSingleCrochet() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.INCREASE, ComponentTypes.SINGLE_CROCHET, ComponentTypes.SINGLE_CROCHET, ComponentTypes.INCREASE);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" inc, 3 sc, inc", assembler.assemble());
    }
    // TODO make able to handle more than one inc at a time

    @Test
    public void testDecreaseAndSingleCrochet() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.DECREASE, ComponentTypes.SINGLE_CROCHET, ComponentTypes.SINGLE_CROCHET, ComponentTypes.DECREASE);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" dec, 3 sc, dec", assembler.assemble());
    }
    // TODO make able to handle more than one dec

    @Test
    public void testRepeatWithIncreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 3);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" (2 sc, inc) x3", assembler.assemble());
    }

    @Test
    public void testRepeatWithDecreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 3);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" (2 sc, dec) x3", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithIncreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" 2 sc, inc", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithDecreaseWithEmptyRound() {
        List<Integer> roundComponentCounts = List.of(2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" 2 sc, dec", assembler.assemble());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithIncrease() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 3);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" inc, (2 sc, inc) x3", assembler.assemble());
    }

    // for this test to pass, the decrease part of testDecreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithDecrease() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 3);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" dec, (2 sc, dec) x3", assembler.assemble());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testFakeRepeatWithIncrease() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.INCREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_INCREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" inc, 2 sc, inc", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithDecrease() {
        List<Integer> roundComponentCounts = List.of(1, 2, 1, 1);
        List<ComponentTypes> roundComponentTypes = List.of(ComponentTypes.DECREASE, ComponentTypes.REPEAT_SINGLE_CROCHET, ComponentTypes.REPEAT_DECREASE, ComponentTypes.REPEAT_COUNT);
        RoundComponentAssembler assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        assertEquals(" dec, 2 sc, dec", assembler.assemble());
    }
}
