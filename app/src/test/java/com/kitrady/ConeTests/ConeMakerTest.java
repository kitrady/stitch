package com.kitrady.ConeTests;

import com.kitrady.cones.ConeMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        ConeMaker maker = new ConeMaker(true, 4, 0.19611613513818404);
        assertEquals(
                """
                        
                        - Start from small end: true
                        - Radius in stitches: 4.0
                        - Change in radius per one round: 0.19611613513818404
                        - stitches per round: []""",
                maker.toString());
    }

    @Test
    public void testMakeCone1() {
        ConeMaker maker = new ConeMaker(false, 4, 0.19611613513818404);
        List<Integer> totals = List.of(25, 24, 23, 21, 20, 19, 18, 17, 15, 14, 13, 12, 10, 9, 8, 7, 5, 4);
        assertEquals(totals, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeCone2() {
        ConeMaker maker = new ConeMaker(false, 4, 0.31622776601683794);
        List<Integer> totals = List.of(25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5);
        assertEquals(totals, maker.getStitchesPerRound());
    }
}
