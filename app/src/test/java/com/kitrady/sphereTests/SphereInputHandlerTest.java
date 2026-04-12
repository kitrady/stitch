package com.kitrady.sphereTests;

import com.kitrady.ShapeMaker;
import com.kitrady.spheres.SphereInputHandler;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereInputHandlerTest {
    @Test
    public void testHardcodedInputs() {
        SphereInputHandler handler = new SphereInputHandler(2.4, 4.3, 3.4);
        assertEquals(1.2, handler.getRadius());
        assertEquals(4.3, handler.getStitchGauge());
        assertEquals(3.4, handler.getRoundGauge());
    }

    @Test
    public void testHardcodedNegInputs() {
        SphereInputHandler handler = new SphereInputHandler(-4, -3, -3);
        assertEquals(2, handler.getRadius());
        assertEquals(3, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testScannerInputs() {
        String data = "2\n3\n4\n";
        Scanner input = new Scanner(data);
        SphereInputHandler handler = new SphereInputHandler(input);
        assertEquals(1, handler.getRadius());
        assertEquals(3, handler.getStitchGauge());
        assertEquals(4, handler.getRoundGauge());
    }

    @Test
    public void testScannerNegInputs() {
        String data = "-3.8\n-4.1\n-3.7\n";
        Scanner input = new Scanner(data);
        SphereInputHandler handler = new SphereInputHandler(input);
        assertEquals(1.9, handler.getRadius());
        assertEquals(4.1, handler.getStitchGauge());
        assertEquals(3.7, handler.getRoundGauge());
    }

    @Test
    public void testStRadius() {
        SphereInputHandler handler = new SphereInputHandler(2, 4, 3);
        ShapeMaker maker = handler.makeShapeMaker();
        assertEquals(
                "\n- Radius in stitches: 4.0" + "\n- Degrees per round: 19.098593171027442" + "\n- Stitches per round: []",
                maker.toString());
    }
}
