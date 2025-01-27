package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler objInputHandler = new InputHandler(1.25, 4, 4);
//        InputHandler objInputHandler = new InputHandler(input);
        SphereMaker objSphereMaker = new SphereMaker(objInputHandler.getStRadius(), objInputHandler.getRdCircumference());
        RoundComponentMaker objRoundComponentMaker =  new RoundComponentMaker(objSphereMaker.getStitchesPerRd());

        System.out.println("\nobjInputGetter:" + objInputHandler);
        System.out.println("\nobjSphereMaker:" + objSphereMaker);

        objRoundComponentMaker.formatPattern();
        objRoundComponentMaker.printPattern();
    }
}