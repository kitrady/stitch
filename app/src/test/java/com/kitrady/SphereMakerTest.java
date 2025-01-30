package com.kitrady;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SphereMakerTest {
    @Test
    public void testGetStRadius() {
        SphereMaker maker = new SphereMaker(4.6, 28.9);
        assertEquals(4.6, maker.getRadiusInStitches());
    }

    @Test
    public void testGetRowCircumference() {
        SphereMaker maker = new SphereMaker(4.6, 28.9);
        assertEquals(28.9, maker.getCircumferenceInRounds());
    }

    @Test
    public void testGetDegreesPerRd() {
        SphereMaker maker = new SphereMaker(4.6, 28.9);
        assertEquals(12.456747404844291, maker.getDegreesPerRound());
    }

    @Test
    public void testMakeSphere() {
        SphereMaker maker = new SphereMaker(4.6, 28.90226);
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 22, 26, 28, 29, 29, 28, 26, 22, 18, 12, 6);
        assertEquals(stitchesPerRd, maker.getStitchesPerRd());
    }

    @Test
    public void testMakeSphere2() {
        SphereMaker maker = new SphereMaker(5, 31.4155);
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 23, 26, 29, 31, 31, 31, 29, 26, 23, 18, 12, 6);
        assertEquals(stitchesPerRd, maker.getStitchesPerRd());
    }
}
