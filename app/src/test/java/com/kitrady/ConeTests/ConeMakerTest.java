package com.kitrady.ConeTests;

import com.kitrady.cones.ConeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        ConeMaker maker = new ConeMaker(4, 0.19611613513818404);
        assertEquals(
                "\n- Radius in stitches: 4.0" + "\n- Change in radius per one round: 0.19611613513818404" + "\n- stitches per round: []",
                maker.toString());
    }

    @Test
    public void testMakeCone1() {
        ConeMaker maker = new ConeMaker(4, 0.19611613513818404);
        List<Integer> totals = List.of(4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18, 19, 20, 21, 23, 24, 25);
        assertEquals(totals, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeCone2() {
        ConeMaker maker = new ConeMaker(4, 0.31622776601683794);
        List<Integer> totals = List.of(5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25);
        assertEquals(totals, maker.getStitchesPerRound());
    }
}
