package com.kitrady;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoundComponentAssemblerTest {
    @Test
    public void testSingleCrochetThenIncreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);
        assertEquals("3 sc, inc", assembler.assemble());
    }

    @Test
    public void testSingleCrochetThenDecreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);
        assertEquals("3 sc, dec", assembler.assemble());
    }

    @Test
    public void testIncreaseAndSingleCrochet() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);
        assembler.updateRoundComponents(2, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);
        assertEquals("inc, 3 sc, inc", assembler.assemble());
    }
    // TODO make able to handle more than one inc at a time

    @Test
    public void testDecreaseAndSingleCrochet() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);
        assembler.updateRoundComponents(2, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);
        assertEquals("dec, 3 sc, dec", assembler.assemble());
    }
    // TODO make able to handle more than one dec

    @Test
    public void testRepeatWithIncreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);
        assembler.updateRoundComponents(3, ComponentTypes.REPEAT_COUNT);
        assertEquals("(2 sc, inc) x3", assembler.assemble());
    }

    @Test
    public void testRepeatWithDecreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);
        assembler.updateRoundComponents(3, ComponentTypes.REPEAT_COUNT);
        assertEquals("(2 sc, dec) x3", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithIncreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_COUNT);
        assertEquals("2 sc, inc", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithDecreaseWithEmptyRound() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_COUNT);
        assertEquals("2 sc, dec", assembler.assemble());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithIncrease() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);
        assembler.updateRoundComponents(3, ComponentTypes.REPEAT_COUNT);
        assertEquals("inc, (2 sc, inc) x3", assembler.assemble());
    }

    // for this test to pass, the decrease part of testDecreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithDecrease() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);
        assembler.updateRoundComponents(3, ComponentTypes.REPEAT_COUNT);
        assertEquals("dec, (2 sc, dec) x3", assembler.assemble());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testFakeRepeatWithIncrease() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_COUNT);
        assertEquals("inc, 2 sc, inc", assembler.assemble());
    }

    @Test
    public void testFakeRepeatWithDecrease() {
        RoundComponentAssembler assembler = new RoundComponentAssembler();
        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);
        assembler.updateRoundComponents(2, ComponentTypes.REPEAT_SINGLE_CROCHET);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);
        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_COUNT);
        assertEquals("dec, 2 sc, dec", assembler.assemble());
    }
}
