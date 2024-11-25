package com.kitrady;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class InputGetterTest {
    @Test
    public void testHardcodeRadius() {
        InputGetter classUnderTest = new InputGetter(1.2, 4.3, 3.4);
        assertEquals(1.2, classUnderTest.getRadius());
    }

    @Test
    public void testHardcodeGauge() {
        InputGetter classUnderTest = new InputGetter(1.2, 4.3, 3.4);
        assertEquals(4.3, classUnderTest.getGauge());
    }

    @Test
    public void testHardcodeVertGauge() {
        InputGetter classUnderTest = new InputGetter(1.2, 4.3, 3.4);
        assertEquals(3.4, classUnderTest.getVertGauge());
    }

//    @Test
//    public void testHardcodeNegInput() {
//        InputGetter classUnderTest = new InputGetter(-2, -3, -3);
//        assertEquals(2, classUnderTest.getRadius());
//        assertEquals(3, classUnderTest.getGauge());
//        assertEquals(3, classUnderTest.getVertGauge());
//    }

    @Test
    public void testInputRadius() {
        String data = "1\n3\n4\n";
        Scanner input = new Scanner(data);
        InputGetter classUnderTest = new InputGetter(input);
        assertEquals(1, classUnderTest.getRadius());
    }

    @Test
    public void testInputGauge() {
        String data = "1\n3\n4\n";
        Scanner input = new Scanner(data);
        InputGetter classUnderTest = new InputGetter(input);
        assertEquals(3, classUnderTest.getGauge());
    }

    @Test
    public void testInputVertGauge() {
        String data = "2\n3\n4\n";
        Scanner input = new Scanner(data);
        InputGetter classUnderTest = new InputGetter(input);
        assertEquals(4, classUnderTest.getVertGauge());
    }

//    @Test
//    public void testInputNegInput() {
//        String data = "-1.9\n-4.1\n-3.7\n";
//        Scanner input = new Scanner(data);
//        InputGetter classUnderTest = new InputGetter(input);
//        assertEquals(1.9, classUnderTest.getRadius());
//        assertEquals(4.1, classUnderTest.getGauge());
//        assertEquals(3.7, classUnderTest.getVertGauge());
//    }
}
