package com.kitrady.sphereTests;

import com.kitrady.spheres.SphereMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SphereMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        SphereMaker maker = new SphereMaker(4.6, 28.9);
        assertEquals(
                "\n- Radius in stitches: 4.6" + "\n- Degrees per round: 28.9" + "\n- Stitches per round: []",
                maker.toString());
    }

    @Test
    public void testMakeSphere() {
        SphereMaker maker = new SphereMaker(4.6, 12.4557733547);
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 22, 26, 28, 29, 29, 28, 26, 22, 18, 12, 6);
        assertEquals(stitchesPerRd, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeSphere2() {
        SphereMaker maker = new SphereMaker(5, 11.4593114864);
        List<Integer> stitchesPerRd = List.of(6, 12, 18, 23, 26, 29, 31, 31, 31, 29, 26, 23, 18, 12, 6);
        assertEquals(stitchesPerRd, maker.getStitchesPerRound());
    }
}
