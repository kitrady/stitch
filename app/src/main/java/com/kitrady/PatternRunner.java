package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler objInputHandler = new InputHandler(1.25, 4, 4);
//        InputHandler objInputHandler = new InputHandler(input);
        SphereMaker objSphereMaker = new SphereMaker(objInputHandler.getRadiusInStitches(), objInputHandler.getRdCircumference());
        RoundComponentMaker objRoundComponentMaker =  new RoundComponentMaker(objSphereMaker.getStitchesPerRd());

        System.out.println("\nobjInputGetter:" + objInputHandler);
        System.out.println("\nobjSphereMaker:" + objSphereMaker);

//        TODO refactor maker and assembler class
//        have maker make only components, absolutely zero strings
//        have assembler make all the components into strings
//        this would allow the formatted pattern list to just be a list of components
//        which does magically make everything more encapsulated and tests more realistic
//
//        example:
//        List<CrochetRound> components = objRoundComponentMaker.makeComponents();
//        printedPattern = patternPrinter.format(components)
//        System.out.println(printedPattern);

        // TODO add more descriptive names to potentially remove comments
        // TODO remove abbreviations from names

        objRoundComponentMaker.formatPattern();
        objRoundComponentMaker.printPattern();
    }
}