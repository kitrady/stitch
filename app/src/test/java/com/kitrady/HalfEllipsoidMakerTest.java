package com.kitrady;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class HalfEllipsoidMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(4, 16, 1.05263157895);
        assertEquals(4, maker.getRadiusInStitches());
        assertEquals(16, maker.getHeightInStitches());
    }

    // TODO test find x for given arc length

    // TODO test find angle for given x

    // TODO check if these totals are right by crocheting them
    @Test
    public void testMakeHalfEllipsoid() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(4, 16, 1);
        List<Integer> totals = List.of(25, 23, 22, 20, 19, 17, 16, 14, 13, 11, 10, 8, 7, 5, 3, 2, 0, 0);
        assertEquals(totals, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeHalfEllipsoid2() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(7, 8, 1.05263157895);
        List<Integer> totals = List.of(43, 42, 40, 37, 33, 28, 24, 18, 13, 7, 1, 0);
        assertEquals(totals, maker.getStitchesPerRound());
    }
}
