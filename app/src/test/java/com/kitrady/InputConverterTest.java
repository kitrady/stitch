package com.kitrady;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputConverterTest {
    @Test
    public void testStRadius() {
        InputConverter classUnderTest = new InputConverter(1, 4, 3);
        assertEquals(4, classUnderTest.getStRadius());
    }

    @Test
    public void testRowCircumference() {
        InputConverter classUnderTest = new InputConverter(1.1, 4.7, 3.9);
        assertEquals((6.2831 * 1.1 * 3.9), classUnderTest.getRowCircumference());
    }
}
