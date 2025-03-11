package com.kitrady.ellipses;

import org.hipparchus.special.elliptic.legendre.LegendreEllipticIntegral;

public class EllipticIntegrals {
    public static int factorial(int num) {
        int total = 1;
        for (int count = num; count > 0; count--) {
            total *= count;
        }
        if (num < 1) {
            throw new IllegalArgumentException("Tried to take factorial of number less than one");
        }
        return total;
    }

    public static double calculateEccentricity(double semiMajorAxis, double semiMinorAxis) {
        return Math.sqrt(1 - (Math.pow(semiMinorAxis, 2) / Math.pow(semiMajorAxis, 2)));
    }

    public static double calculateArcLengthOfEllipse(double angle, double semiMajorAxis, double semiMinorAxis) {
        double eccentricity = calculateEccentricity(semiMajorAxis, semiMinorAxis);

        // calculates incomplete elliptic integral of the second kind from zero to given angle using calculated eccentricity
        double integral = LegendreEllipticIntegral.bigE(angle, Math.pow(eccentricity, 2));

        // calculates other parts of arc length formula
        double arcLengthNumerator = Math.pow(eccentricity, 2) * Math.sin(angle) * Math.cos(angle);
        double arcLengthDenominator = Math.sqrt(1- Math.pow(eccentricity, 2) * Math.pow(Math.sin(angle), 2));

        // returns arc length according to formula (see wikipedia page on meridian arc length for formula)
        return semiMajorAxis * (integral - arcLengthNumerator/arcLengthDenominator);
    }

    // uses power series for elliptic integral from wikipedia to calculate
    // result is a quarter of the circumference of the ellipse measured in semi-major axis (like how radians are units of radius)
    public static double calculateSecondCompleteEllipticIntegral(double eccentricity) {
        double sum = 1;
        for (int n = 1; n <= 20; n++) {
            double firstNumerator = factorial(2 * n);
            double firstDenominator = Math.pow(2, 2 * n) * Math.pow(factorial(n), 2);
            double secondNumerator = Math.pow(eccentricity, 2 * n);
            int secondDenominator = 1 - 2 * n;
            double term = Math.pow(firstNumerator / firstDenominator, 2) * (secondNumerator / secondDenominator);
            sum += term;
        }
        return sum * (Math.PI / 2);
    }
}