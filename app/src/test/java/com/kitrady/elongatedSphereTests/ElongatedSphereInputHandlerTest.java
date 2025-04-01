package com.kitrady.elongatedSphereTests;

import com.kitrady.ShapeMaker;
import com.kitrady.elongatedSpheres.ElongatedSphereInputHandler;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElongatedSphereInputHandlerTest {
    @Test
    public void testHardcodedInputs() {
        ElongatedSphereInputHandler handler = new ElongatedSphereInputHandler(1.3, 2, 4.1, 4);
        assertEquals(1.3, handler.getDiameter());
        assertEquals(2, handler.getLength());
        assertEquals(4.1, handler.getStitchGauge());
        assertEquals(4, handler.getRoundGauge());
    }

    @Test
    public void testNegativeHardcodedInputs() {
        ElongatedSphereInputHandler handler = new ElongatedSphereInputHandler(-1.3, -2, -4.1, -4);
        assertEquals(1.3, handler.getDiameter());
        assertEquals(2, handler.getLength());
        assertEquals(4.1, handler.getStitchGauge());
        assertEquals(4, handler.getRoundGauge());
    }

    @Test
    public void testScannerInputs() {
        String data = "2.1\n8\n4\n4.4\n";
        Scanner input = new Scanner(data);
        ElongatedSphereInputHandler handler = new ElongatedSphereInputHandler(input);
        assertEquals(2.1, handler.getDiameter());
        assertEquals(8, handler.getLength());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(4.4, handler.getRoundGauge());
    }

    @Test
    public void testNegativeScannerInputs() {
        String data = "-2.1\n-8\n-4\n-4.4\n";
        Scanner input = new Scanner(data);
        ElongatedSphereInputHandler handler = new ElongatedSphereInputHandler(input);
        assertEquals(2.1, handler.getDiameter());
        assertEquals(8, handler.getLength());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(4.4, handler.getRoundGauge());
    }

    @Test
    public void testCreateElongatedSphereMaker() {
        ElongatedSphereInputHandler handler = new ElongatedSphereInputHandler(2, 3, 4, 4);
        ShapeMaker maker = handler.makeShapeMaker();
        assertEquals(
                "\n- Radius in stitches: 4.0" + "\n- Degrees per round: 14.32394487827058" + "\n- Cylinder length in rounds: 4.0" + "\n- Stitches per round: []",
                maker.toString());
    }
}
