package com.kitrady;

import com.kitrady.circles.CircleInputHandler;
import com.kitrady.cones.ConeInputHandler;
import com.kitrady.elongatedSpheres.ElongatedSphereInputHandler;
import com.kitrady.elongatedSpheres.ElongatedSphereMaker;
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

//        InputHandler handler1 = new ElongatedSphereInputHandler(1.5, 2.5, 4.66, 5.33);
//        ShapeMaker maker1 = handler1.makeShapeMaker();
//        RoundComponentMaker componentMaker1 =  new RoundComponentMaker(maker1.getStitchesPerRound());
//        componentMaker1.generateAllRoundComponents();
//        RoundComponentAssembler assembler1 = new RoundComponentAssembler(componentMaker1.getAllRoundComponents());
//        assembler1.assemble();
//        assembler1.printPattern();
    }

    private static InputHandler createInputHandler(Scanner input) {
        int shapeChoice = 0;
        System.out.println("Please choose the shape you want to generate a pattern for and enter the number that corresponds your choice:" +
                "\n1) Sphere" +
                "\n2) Circle" +
                "\n3) Elongated sphere (sphere with a cylinder in the middle; creates oval like shapes when cylinder is small compared to diameter of sphere" +
                "\n4) Cone");

        while (true) {
            if (input.hasNextInt()) { // this should prompt the scanner to wait for user input, as there should be nothing ahead of the scanner
                shapeChoice = input.nextInt(); // gets the int character from the scanner, leaving the newline character ahead of the scanner
            }

            if (shapeChoice >= 1 && shapeChoice <= 4) {
                input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
                break;
            }

            input.nextLine(); // gets the newline character from the scanner, meaning there is nothing ahead of the scanner
            System.out.print("Enter just a number that corresponds your choice of available shapes: ");
        }

        if (shapeChoice == 1) {
            return new SphereInputHandler(input);
        } else if (shapeChoice == 2) {
            return new CircleInputHandler(input);
        } else if (shapeChoice == 3) {
            return new ElongatedSphereInputHandler(input);
        } else {
            return new ConeInputHandler(input);
        }
    }
}