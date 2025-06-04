package com.kitrady;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundComponentAssemblerTest {
    @Test
    public void testSingleCrochetThenIncreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 3 sc, 1 inc", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testSingleCrochetThenDecreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.DECREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 3 sc, 1 dec", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testIncreaseAndSingleCrochet() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 inc, 3 sc, 1 inc", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testDecreaseAndSingleCrochet() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.DECREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 dec, 3 sc, 1 dec", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testRepeatWithIncreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" (2 sc, 1 inc) x3", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testRepeatWithDecreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" (2 sc, 1 dec) x3", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testFakeRepeatWithIncreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(1, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 2 sc, 1 inc", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testFakeRepeatWithDecreaseWithEmptyRound() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(1, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 2 sc, 1 dec", assembler.getFormattedPattern().getLast());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithIncrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 inc, (2 sc, 1 inc) x3", assembler.getFormattedPattern().getLast());
    }

    // for this test to pass, the decrease part of testDecreaseAndSingleCrochet must also work
    @Test
    public void testRepeatWithDecrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 dec, (2 sc, 1 dec) x3", assembler.getFormattedPattern().getLast());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testFakeRepeatWithIncrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(1, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 inc, 2 sc, 1 inc", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testFakeRepeatWithDecrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(1, ComponentType.REPEAT_COUNT)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 1 dec, 2 sc, 1 dec", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testSpecialIncreaseFirst() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.SPECIAL_INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 3 sc in st", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testRepeatSpecialIncreaseFirst() {
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.SPECIAL_INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" (3 sc in st) x2", assembler.getFormattedPattern().getLast());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testSpecialIncrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(5, ComponentType.INCREASE),
                new RoundComponent(1, ComponentType.SPECIAL_INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 5 inc, 3 sc in st", assembler.getFormattedPattern().getLast());
    }

    // for this test to pass, the increase part of testIncreaseAndSingleCrochet must also work
    @Test
    public void testRepeatSpecialIncrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(4, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.SPECIAL_INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 4 inc, (3 sc in st) x2", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testRoundNumber() {
        List<RoundComponent> components = List.of(
                new RoundComponent(1, ComponentType.ROUND_NUMBER)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals("Rd 1:", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testMagicRing() {
        List<RoundComponent> components = List.of(
                new RoundComponent(5, ComponentType.MAGIC_RING)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" 5 sc in magic ring", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testAllSingleCrochet() {
        List<RoundComponent> components = List.of(
                new RoundComponent(0, ComponentType.ALL_SINGLE_CROCHET)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" sc in each st in round", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testAllIncrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(0, ComponentType.ALL_INCREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" inc in each st in round", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testAllDecrease() {
        List<RoundComponent> components = List.of(
                new RoundComponent(0, ComponentType.ALL_DECREASE)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" dec in each st in round", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testStitchTotal() {
        List<RoundComponent> components = List.of(
                new RoundComponent(15, ComponentType.STITCH_TOTAL)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(" (15)", assembler.getFormattedPattern().getLast());
    }

    @Test
    public void testExtraSingleCrochets() {
        List<RoundComponent> components = List.of(
                new RoundComponent(5, ComponentType.SINGLE_CROCHET)
        );
        List<List<RoundComponent>> allComponents = List.of(components);
        RoundComponentAssembler assembler = new RoundComponentAssembler(allComponents);
        assembler.assemble();
        assertEquals(", 5 sc", assembler.getFormattedPattern().getLast());
    }
}
