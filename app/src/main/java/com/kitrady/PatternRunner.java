package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler objInputHandler = new InputHandler(1.15, 4, 4);
//        InputHandler objInputHandler = new InputHandler(input);
        SphereMaker objSphereMaker = new SphereMaker(objInputHandler.getStRadius(), objInputHandler.getRowCircumference());
        PatternFormatter objPatternFormatter =  new PatternFormatter(objSphereMaker.getStitchesPerRow());

        System.out.println("\nobjInputGetter:" + objInputHandler);
        System.out.println("\nobjSphereMaker:" + objSphereMaker);

        objPatternFormatter.printPattern();
    }
}