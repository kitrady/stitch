package com.kitrady;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler objInputHandler = new InputHandler(1.2, 4, 4);
//        InputHandler objInputHandler = new InputHandler(input);
        SphereMaker objSphereMaker = new SphereMaker(objInputHandler.getStRadius(), objInputHandler.getRowCircumference());

        System.out.println("\nobjInputGetter:" + objInputHandler);
        System.out.println("\nobjSphereMaker:" + objSphereMaker);

        objSphereMaker.printRows();
    }
}
