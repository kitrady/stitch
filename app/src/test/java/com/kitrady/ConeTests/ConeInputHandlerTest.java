package com.kitrady.ConeTests;

import com.kitrady.ShapeMaker;
import com.kitrady.cones.ConeInputHandler;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class ConeInputHandlerTest {
    @Test
    public void testHardcodedInputs() {
        ConeInputHandler handler = new ConeInputHandler(3.4, 4, true, 3.9, 4);
        assertEquals(3.4, handler.getDiameterInInches());
        assertEquals(4, handler.getLengthInInches());
        assertTrue(handler.getStartFromSmallEnd());
        assertEquals(3.9, handler.getStitchGauge());
        assertEquals(4, handler.getRoundGauge());
    }

    @Test
    public void testNegativeHardcodedInputs() {
        ConeInputHandler handler = new ConeInputHandler(-2, -1.5, false, -4, -4.1);
        assertEquals(2, handler.getDiameterInInches());
        assertEquals(1.5, handler.getLengthInInches());
        assertFalse(handler.getStartFromSmallEnd());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(4.1, handler.getRoundGauge());
    }

    @Test
    public void testScannerInputs() {
        String data = "3\n5\nn\n4\n3\n";
        Scanner input = new Scanner(data);
        ConeInputHandler handler = new ConeInputHandler(input);
        assertEquals(3, handler.getDiameterInInches());
        assertEquals(5, handler.getLengthInInches());
        assertFalse(handler.getStartFromSmallEnd());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testNegativeScannerInputs() {
        String data = "-3.1\n-5\ny\n-4.2\n-3.8\n";
        Scanner input = new Scanner(data);
        ConeInputHandler handler = new ConeInputHandler(input);
        assertEquals(3.1, handler.getDiameterInInches());
        assertEquals(5, handler.getLengthInInches());
        assertTrue(handler.getStartFromSmallEnd());
        assertEquals(4.2, handler.getStitchGauge());
        assertEquals(3.8, handler.getRoundGauge());
    }

    @Test
    public void testCreateConeMaker() {
        ConeInputHandler handler = new ConeInputHandler(2, 5, true, 4, 4);
        ShapeMaker maker = handler.makeShapeMaker();
        assertEquals(
                """
                        
                        - Start from small end: true
                        - Radius in stitches: 4.0
                        - Change in radius per one round: 0.19611613513818404
                        - stitches per round: []""",
                maker.toString());
    }
}
