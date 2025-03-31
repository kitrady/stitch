package com.kitrady.sphereTests;

import com.kitrady.spheres.SphereInputHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class SphereInputHandlerTest {
    @Test
    public void testHardcodeRadius() {
        SphereInputHandler handler = new SphereInputHandler(2.4, 4.3, 3.4);
        assertEquals(1.2, handler.getRadius());
    }

    @Test
    public void testHardcodeGauge() {
        SphereInputHandler handler = new SphereInputHandler(2.4, 4.3, 3.4);
        assertEquals(4.3, handler.getStitchGauge());
    }

    @Test
    public void testHardcodeVertGauge() {
        SphereInputHandler handler = new SphereInputHandler(2.4, 4.3, 3.4);
        assertEquals(3.4, handler.getRoundGauge());
    }

    @Test
    public void testHardcodeNegInput() {
        SphereInputHandler handler = new SphereInputHandler(-4, -3, -3);
        assertEquals(2, handler.getRadius());
        assertEquals(3, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testInputRadius() {
        String data = "2\n3\n4\n";
        Scanner input = new Scanner(data);
        SphereInputHandler handler = new SphereInputHandler(input);
        assertEquals(1, handler.getRadius());
    }

    @Test
    public void testInputGauge() {
        String data = "2\n3\n4\n";
        Scanner input = new Scanner(data);
        SphereInputHandler handler = new SphereInputHandler(input);
        assertEquals(3, handler.getStitchGauge());
    }

    @Test
    public void testInputVertGauge() {
        String data = "4\n3\n4\n";
        Scanner input = new Scanner(data);
        SphereInputHandler handler = new SphereInputHandler(input);
        assertEquals(4, handler.getRoundGauge());
    }

    @Test
    public void testInputNegInput() {
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
        assertEquals(4, handler.getRadiusInStitches());
    }

    @Test
    public void testRdCircumference() {
        SphereInputHandler handler = new SphereInputHandler(2.2, 4.7, 3.9);
        assertEquals((26.954864967800425), handler.getCircumferenceInRounds()); // 2 * Math.PI * 1.1 * 3.9 = 26.95486496780043
    }
}
