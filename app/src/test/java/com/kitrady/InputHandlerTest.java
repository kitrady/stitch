package com.kitrady;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class InputHandlerTest {
    @Test
    public void testHardcodeRadius() {
        InputHandler classUnderTest = new InputHandler(1.2, 4.3, 3.4);
        assertEquals(1.2, classUnderTest.getRadius());
    }

    @Test
    public void testHardcodeGauge() {
        InputHandler classUnderTest = new InputHandler(1.2, 4.3, 3.4);
        assertEquals(4.3, classUnderTest.getGauge());
    }

    @Test
    public void testHardcodeVertGauge() {
        InputHandler classUnderTest = new InputHandler(1.2, 4.3, 3.4);
        assertEquals(3.4, classUnderTest.getVertGauge());
    }

    @Test
    public void testHardcodeNegInput() {
        InputHandler classUnderTest = new InputHandler(-2, -3, -3);
        assertEquals(2, classUnderTest.getRadius());
        assertEquals(3, classUnderTest.getGauge());
        assertEquals(3, classUnderTest.getVertGauge());
    }

    @Test
    public void testInputRadius() {
        String data = "1\n3\n4\n";
        Scanner input = new Scanner(data);
        InputHandler classUnderTest = new InputHandler(input);
        assertEquals(1, classUnderTest.getRadius());
    }

    @Test
    public void testInputGauge() {
        String data = "1\n3\n4\n";
        Scanner input = new Scanner(data);
        InputHandler classUnderTest = new InputHandler(input);
        assertEquals(3, classUnderTest.getGauge());
    }

    @Test
    public void testInputVertGauge() {
        String data = "2\n3\n4\n";
        Scanner input = new Scanner(data);
        InputHandler classUnderTest = new InputHandler(input);
        assertEquals(4, classUnderTest.getVertGauge());
    }

    @Test
    public void testInputNegInput() {
        String data = "-1.9\n-4.1\n-3.7\n";
        Scanner input = new Scanner(data);
        InputHandler classUnderTest = new InputHandler(input);
        assertEquals(1.9, classUnderTest.getRadius());
        assertEquals(4.1, classUnderTest.getGauge());
        assertEquals(3.7, classUnderTest.getVertGauge());
    }

    @Test
    public void testStRadius() {
        InputHandler classUnderTest = new InputHandler(1, 4, 3);
        assertEquals(4, classUnderTest.getStRadius());
    }

    @Test
    public void testRowCircumference() {
        InputHandler classUnderTest = new InputHandler(1.1, 4.7, 3.9);
        assertEquals((6.2831 * 1.1 * 3.9), classUnderTest.getRowCircumference());
    }
}
