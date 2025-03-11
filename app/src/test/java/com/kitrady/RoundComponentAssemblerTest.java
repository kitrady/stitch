package com.kitrady;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    // TODO test assemble special increase
}
