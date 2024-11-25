package com.kitrady;

import java.lang.Math;

public class InputConverter extends InputGetter {
    private double stRadius;
    private double rowRadius;
    private double rowCircumference;

    public InputConverter(double radius, double gauge, double vertGauge) {
        super(radius, gauge, vertGauge);
        stRadius = radius * gauge; // converts the radius from inches to stitches using gauge
        rowRadius = radius * vertGauge; // creates a vertical radius measured in rows using radius in inches and vertical gauge in rows per inch
        rowCircumference = 6.2831 * rowRadius; // creates a vertical circumference measured in rows using vertical radius measured in rows
    }

    public double getStRadius() {
        return stRadius;
    }

    public double getRowCircumference() {
        return rowCircumference;
    }

    public String toString() {
        return (super.toString() +
                "\n- Radius in stitches = " + stRadius +
                "\n- Radius in rows = " + rowRadius +
                "\n- Circumference in rows = " + rowCircumference);
    }
}
