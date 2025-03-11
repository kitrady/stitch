package com.kitrady;

import com.kitrady.ellipses.HalfEllipsoidInputHandler;
import com.kitrady.ellipses.HalfEllipsoidMaker;
import com.kitrady.spheres.SphereInputHandler;
import com.kitrady.spheres.SphereMaker;

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
    }
}