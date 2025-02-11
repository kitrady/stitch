package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler handler = new InputHandler(1.25, 4, 4);
//        InputHandler handler = new InputHandler(input);
        SphereMaker sphereMaker = new SphereMaker(handler.getRadiusInStitches(), handler.getCircumferenceInRounds());
        RoundComponentMaker componentMaker =  new RoundComponentMaker(sphereMaker.getStitchesPerRd());
        componentMaker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(componentMaker.getAllRoundComponents());
        assembler.assemble();
        assembler.printPattern();
//        System.out.println("\nobjInputGetter:" + handler);
//        System.out.println("\nsphereMaker:" + sphereMaker);
    }
}