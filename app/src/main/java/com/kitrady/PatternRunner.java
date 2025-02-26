package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SphereInputHandler handler = new SphereInputHandler(5, 2.9, 2.9);
//        InputHandler handler = new InputHandler(input);
        SphereMaker sphereMaker = new SphereMaker(handler.getRadiusInStitches(), handler.getCircumferenceInRounds());
        RoundComponentMaker componentMaker =  new RoundComponentMaker(sphereMaker.getStitchesPerRound());
        componentMaker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(componentMaker.getAllRoundComponents());
        assembler.assemble();
        assembler.printPattern();

        HalfEllipsoidInputHandler handler2 = new HalfEllipsoidInputHandler(3, 2, 5, 5);
        HalfEllipsoidMaker maker2 = new HalfEllipsoidMaker(handler2.getRadiusInStitches(), handler2.getHeightInStitches(), 1);
        System.out.println("\n");
        maker2.printPattern();
    }
}