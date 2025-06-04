package com.kitrady.ellipsoidTests;

import com.kitrady.ellipsoids.HalfEllipsoidMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HalfEllipsoidMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(4, 16, 1.05263157895);
        assertEquals(4, maker.getRadiusInStitches());
        assertEquals(16, maker.getHeightInStitches());
    }

    @Test
    public void testFindXForGivenArcLength() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(5, 10, 1);
        assertEquals(4.910000000000002, maker.findXForGivenArcLength(1, 5, 10, 5));
    }

    @Test
    public void testFindAngleForGivenX() {
        HalfEllipsoidMaker maker = new HalfEllipsoidMaker(5, 10, 1);
        assertEquals(0.3672355054826683, maker.findAngleForGivenX(4.91));
    }

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
