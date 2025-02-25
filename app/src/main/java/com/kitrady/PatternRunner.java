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
//        System.out.println("\nobjInputGetter:" + handler);
//        System.out.println("\nsphereMaker:" + sphereMaker);
        double eccentricity = EllipticIntegrals.calculateEccentricity(3, 2);
        System.out.println("\n" + eccentricity);
        System.out.println(EllipticIntegrals.calculateArcLengthOfEllipse(1, 3, 2));
    }
}