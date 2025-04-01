package com.kitrady;

import com.kitrady.circles.CircleInputHandler;
import com.kitrady.spheres.SphereInputHandler;

import java.util.Scanner;

public class PatternRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        InputHandler handler = createInputHandler(input);
        ShapeMaker maker = handler.makeShapeMaker();
        RoundComponentMaker componentMaker =  new RoundComponentMaker(maker.getStitchesPerRound());
        componentMaker.generateAllRoundComponents();
        RoundComponentAssembler assembler = new RoundComponentAssembler(componentMaker.getAllRoundComponents());
        assembler.assemble();
        assembler.printPattern();
    }

    private static InputHandler createInputHandler(Scanner input) {
        int shapeChoice = 0;
        System.out.println("Please choose the shape you want to generate a pattern for and enter the number that corresponds your choice:\n1) Sphere\n2) Circle");

        while (true) {
            if (input.hasNextInt()) {
                shapeChoice = input.nextInt();
            }

            if (shapeChoice == 1 || shapeChoice == 2) {
                break;
            }

            input.nextLine();
            System.out.print("Enter just a number that corresponds your choice of available shapes: ");
        }

        if (shapeChoice == 1) {
            return new SphereInputHandler(input);
        } else {
            return new CircleInputHandler(input);
        }
    }
    /*
    TODO
    consider writing to-string methods for ShapeMaker classes so that tests can act more realistically
    since the InputHandlers share information by creating ShapeMaker inside the class
    */

    // TODO update runner and readme with elongated spheres
}