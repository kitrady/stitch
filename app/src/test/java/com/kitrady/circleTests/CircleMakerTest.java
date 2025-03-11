package com.kitrady.circleTests;

import com.kitrady.circles.CircleMaker;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        CircleMaker maker = new CircleMaker(4, 1.05263157895);
        assertEquals(4, maker.getRadiusInRounds());
        assertEquals(1.05263157895, maker.getRoundLengthInStitches());
    }

    @Test
    public void testMakeCircle() {
        CircleMaker maker = new CircleMaker(4, 1);
        List<Integer> totals = List.of(6, 13, 19, 25);
        assertEquals(totals, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeCircle2() {
        CircleMaker maker = new CircleMaker(7, 1.05263157895);
        List<Integer> totals = List.of(7, 13, 20, 26, 33, 40, 46);
        assertEquals(totals, maker.getStitchesPerRound());
    }
}
