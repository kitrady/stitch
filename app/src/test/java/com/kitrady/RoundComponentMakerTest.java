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
        List<RoundComponent> components = List.of(
                new RoundComponent(2,ComponentType.ROUND_NUMBER),
                new RoundComponent(0, ComponentType.ALL_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlmostAllIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 11);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2,ComponentType.ROUND_NUMBER),
                new RoundComponent(5, ComponentType.INCREASE),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(11, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAllIncreases() {
        List<Integer> stitchesPerRound = List.of(2, 4);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(0, ComponentType.ALL_INCREASE),
                new RoundComponent(4, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testNoDecreases() {
        List<Integer> stitchesPerRound = List.of(10, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(0, ComponentType.ALL_SINGLE_CROCHET),
                new RoundComponent(10, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlmostAllDecrease() {
        List<Integer> stitchesPerRound = List.of(11, 6);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2,ComponentType.ROUND_NUMBER),
                new RoundComponent(5, ComponentType.DECREASE),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(6, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test void testAllDecreases() {
        List<Integer> stitchesPerRound = List.of(4, 2);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(0, ComponentType.ALL_DECREASE),
                new RoundComponent(2, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testExtraStitchesForIncrease() {
        List<Integer> stitchesPerRound = List.of(7, 10);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(10, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testExtraStitchesForDecrease() {
        List<Integer> stitchesPerRound = List.of(10, 7);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(7, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testNormalFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT),
                new RoundComponent(9, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testNormalFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(9, 6);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(3, ComponentType.REPEAT_COUNT),
                new RoundComponent(6, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForIncrease() {
        List<Integer> stitchesPerRound = List.of(9, 12);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(2, ComponentType.REPEAT_COUNT),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(12, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForIncreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(18, 21);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(5, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_INCREASE),
                new RoundComponent(2, ComponentType.REPEAT_COUNT),
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(21, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForIncreaseWithOneIncrease() {
        List<Integer> stitchesPerRound = List.of(14, 15);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(6, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.INCREASE),
                new RoundComponent(7, ComponentType.SINGLE_CROCHET),
                new RoundComponent(15, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForDecrease() {
        List<Integer> stitchesPerRound = List.of(12, 9);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(2, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(2, ComponentType.REPEAT_COUNT),
                new RoundComponent(1, ComponentType.SINGLE_CROCHET),
                new RoundComponent(9, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForDecreaseOddSplit() {
        List<Integer> stitchesPerRound = List.of(21, 18);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(2, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(5, ComponentType.REPEAT_SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.REPEAT_DECREASE),
                new RoundComponent(2, ComponentType.REPEAT_COUNT),
                new RoundComponent(3, ComponentType.SINGLE_CROCHET),
                new RoundComponent(18, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testAlternateFormatForIncreaseWithOneDecrease() {
        List<Integer> stitchesPerRound = List.of(15, 14);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, true);
        maker.formatGivenRounds(stitchesPerRound, true);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(6, ComponentType.SINGLE_CROCHET),
                new RoundComponent(1, ComponentType.DECREASE),
                new RoundComponent(7, ComponentType.SINGLE_CROCHET),
                new RoundComponent(14, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testSpecialIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 13);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(5, ComponentType.INCREASE),
                new RoundComponent(1, ComponentType.SPECIAL_INCREASE),
                new RoundComponent(13, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }

    @Test
    public void testRepeatSpecialIncrease() {
        List<Integer> stitchesPerRound = List.of(6, 14);
        RoundComponentMaker maker = new RoundComponentMaker(stitchesPerRound);
        maker.formatGivenRounds(stitchesPerRound, false);
        List<RoundComponent> components = List.of(
                new RoundComponent(2, ComponentType.ROUND_NUMBER),
                new RoundComponent(4, ComponentType.INCREASE),
                new RoundComponent(2, ComponentType.SPECIAL_INCREASE),
                new RoundComponent(14, ComponentType.STITCH_TOTAL)
        );
        for (int i = 0; i < components.size(); i++) {
            assertEquals(components.get(i).getCount(), maker.getAllRoundComponents().getLast().get(i).getCount());
            assertEquals(components.get(i).getType(), maker.getAllRoundComponents().getLast().get(i).getType());
        }
    }
}
