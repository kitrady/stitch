package com.kitrady.ellipsoidTests;

import com.kitrady.ellipsoids.EllipticIntegrals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EllipticIntegralsTest {
    @Test
    public void testFactorial() {
        assertEquals(2, EllipticIntegrals.factorial(2));
        assertEquals(6, EllipticIntegrals.factorial(3));
        assertEquals(24, EllipticIntegrals.factorial(4));
        assertEquals(120, EllipticIntegrals.factorial(5));
    }

    @Test
    public void testFactorialWithOne() {
        assertEquals(1, EllipticIntegrals.factorial(1));
    }

    @Test
    public void testCalculateEccentricity() {
        assertEquals(0.7453559924999299, EllipticIntegrals.calculateEccentricity(3, 2));
        assertEquals(0.6614378277661477, EllipticIntegrals.calculateEccentricity(4, 3));
        assertEquals(0.8, EllipticIntegrals.calculateEccentricity(5, 3));
    }

    @Test
    public void testCalculateArcLengthOfEllipse() {
        assertEquals(1.4599777481030394, EllipticIntegrals.calculateArcLengthOfEllipse(0.9, 16, 4));
        assertEquals(8.471294543800818, EllipticIntegrals.calculateArcLengthOfEllipse(1.2, 8, 7));
        assertEquals(1.3729482466092318, EllipticIntegrals.calculateArcLengthOfEllipse(0.3, 11, 7));
    }

    @Test
    public void testCalculateSecondCompleteEllipticIntegral() {
        assertEquals(1.0391704747857509, EllipticIntegrals.calculateSecondCompleteEllipticIntegral(1));
        assertEquals(1.5707963267948966, EllipticIntegrals.calculateSecondCompleteEllipticIntegral(0));
        assertEquals(1.4674626097068781, EllipticIntegrals.calculateSecondCompleteEllipticIntegral(0.5));
    }
}
