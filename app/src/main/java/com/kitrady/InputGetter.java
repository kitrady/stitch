package com.kitrady;

import java.util.Scanner;
import static java.lang.Math.*;

public class InputGetter {
    private final double radius; // radius of desired sphere in inches
    private final double gauge; // gauge of crocheter in stitches per inch
    private final double vertGauge; // vertical gauge of crocheter in rows per inch

    public InputGetter(Scanner input) {
        radius = abs(handleInput(input,
                "\nEnter the radius of your sphere in inches: ",
                "\nPlease enter just a number that is the radius of your sphere in inches."));
        input.nextLine();

        gauge = abs(handleInput(input,
                "\nEnter your crochet gauge in stitches per inch: ",
                "\nPlease enter just a number that is your crochet gauge in stitches per inch."));
        input.nextLine();

        vertGauge = abs(handleInput(input,
                "\nEnter your vertical crochet gauge in rows per inch: ",
                "\nPlease enter just a number that is your vertical crochet gauge in stitches per inch."));
        input.nextLine();
    }

    public InputGetter(double radius, double gauge, double vertGauge) {
        this.radius = abs(radius);
        this.gauge = abs(gauge);
        this.vertGauge = abs(vertGauge);
    }

    private double handleInput(Scanner input, String message, String correctingMessage) {
        while (true) {
            System.out.print(message);

            // logic to ensure input that is received is an int or double but no other type
            if (input.hasNextDouble()) {
                return input.nextDouble();
            }
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.nextLine(); // clearing buffer so if statements evaluate properly on subsequent loops

            // further instructions if the received input is incorrect type
            System.out.print(correctingMessage);
        }
    }

    public double getRadius() {
        return radius;
    }

    public double getGauge() {
        return gauge;
    }

    public double getVertGauge() {
        return vertGauge;
    }

    public String toString() {
        return ("\n- Radius = " + radius +
                "\n- Gauge = " + gauge +
                "\n- Vertical gauge = " + vertGauge);
    }
}
