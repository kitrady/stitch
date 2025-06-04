package com.kitrady.elongatedSphereTests;

import com.kitrady.elongatedSpheres.ElongatedSphereMaker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElongatedSphereMakerTest {
    @Test
    public void testGetDirectlyAssignedInstanceVariables() {
        ElongatedSphereMaker maker = new ElongatedSphereMaker(4, 14.32394487827058, 4);
        assertEquals(
                "\n- Radius in stitches: 4.0" + "\n- Degrees per round: 14.32394487827058" + "\n- Cylinder length in rounds: 4.0" + "\n- Stitches per round: []",
                maker.toString());
    }

    @Test
    public void testMakeCircle() {
        ElongatedSphereMaker maker = new ElongatedSphereMaker(4, 14.32394487827058, 4);
        List<Integer> totals = List.of(6, 12, 17, 21, 24, 25, 25, 25, 25, 25, 25, 24, 21, 17, 12, 6);
        assertEquals(totals, maker.getStitchesPerRound());
    }

    @Test
    public void testMakeCircle2() {
        ElongatedSphereMaker maker = new ElongatedSphereMaker(2, 28.64788975654116, 8);
        List<Integer> totals = List.of(6, 11, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 11, 6);
        assertEquals(totals, maker.getStitchesPerRound());
    }
}
