package com.kitrady.circleTests;

import com.kitrady.ShapeMaker;
import com.kitrady.circles.CircleInputHandler;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleInputHandlerTest {
    @Test
    public void testHardcodedInputs() {
        CircleInputHandler handler = new CircleInputHandler(2.4, 4.3, 3.4);
        assertEquals(2.4, handler.getDiameterInInches());
        assertEquals(4.3, handler.getStitchGauge());
        assertEquals(3.4, handler.getRoundGauge());
    }

    @Test
    public void testNegativeHardcodedInputs() {
        CircleInputHandler handler = new CircleInputHandler(-2, -4.3, -3);
        assertEquals(2, handler.getDiameterInInches());
        assertEquals(4.3, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testScannerInputs() {
        String data = "3\n4\n3\n";
        Scanner input = new Scanner(data);
        CircleInputHandler handler = new CircleInputHandler(input);
        assertEquals(3, handler.getDiameterInInches());
        assertEquals(4, handler.getStitchGauge());
        assertEquals(3, handler.getRoundGauge());
    }

    @Test
    public void testNegativeScannerInputs() {
        String data = "-3.1\n-4.6\n-3.7\n";
        Scanner input = new Scanner(data);
        CircleInputHandler handler = new CircleInputHandler(input);
        assertEquals(3.1, handler.getDiameterInInches());
        assertEquals(4.6, handler.getStitchGauge());
        assertEquals(3.7, handler.getRoundGauge());
    }

    @Test
    public void testCreateCircleMaker() {
        CircleInputHandler handler = new CircleInputHandler(3.4, 3.3, 3.4);
        ShapeMaker maker = handler.makeShapeMaker();
        assertEquals(
                "\n- Radius in rounds: 5.779999999999999" + "\n- Round length in stitches: 0.9705882352941176" + "\n- Stitches per round: []",
                maker.toString());
    }
}
