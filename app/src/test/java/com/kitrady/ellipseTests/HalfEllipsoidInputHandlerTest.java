package com.kitrady.ellipseTests;

import com.kitrady.ellipses.HalfEllipsoidInputHandler;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class HalfEllipsoidInputHandlerTest {
    @Test
    public void testHardcodedInputs() {
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(2.4, 5.3, 4.3, 3.4);
        assertEquals(2.4, handler.getDiameterInInches());
        assertEquals(5.3, handler.getHeightInInches());
        assertEquals(4.3, handler.getStitchGauge());
        assertEquals(3.4, handler.getRoundGauge());
    }

    @Test
    public void testNegativeHardcodedInputs() {
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(-2, -5.3, -4.3, -3);
        assertEquals(2, handler.getDiameterInInches());
        assertEquals(5.3, handler.getHeightInInches());
        assertEquals(4.3, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testScannerInputs() {
        String data = "3\n5\n4\n3\n";
        Scanner input = new Scanner(data);
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(input);
        assertEquals(3, handler.getDiameterInInches());
        assertEquals(5, handler.getHeightInInches());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testNegativeScannerInputs() {
        String data = "-3.1\n-5.8\n-4.6\n-3.7\n";
        Scanner input = new Scanner(data);
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(input);
        assertEquals(3.1, handler.getDiameterInInches());
        assertEquals(5.8, handler.getHeightInInches());
        assertEquals(4.6, handler.getStitchGauge());
        assertEquals(3.7, handler.getRoundGauge());
    }

    @Test
    public void testGetRadiusInStitches() {
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(3.4, 6.3, 3.3, 3.4);
        assertEquals((3.4 / 2) * 3.3, handler.getRadiusInStitches());
    }

    @Test
    public void testGetHeightInStitches() {
        HalfEllipsoidInputHandler handler = new HalfEllipsoidInputHandler(3.4, 6.3, 3.3, 3.4);
        assertEquals(6.3 * 3.3, handler.getHeightInStitches());
    }

    // old to-do: when update classes to handle height being less than radius, update some tests to reflect that
}
