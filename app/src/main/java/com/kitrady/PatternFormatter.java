package com.kitrady;

import java.util.ArrayList;

public class PatternFormatter {
    private ArrayList<Integer> stitchesPerRow = new ArrayList<Integer>();
    private ArrayList<String> formattedPattern = new ArrayList<String>();

    public PatternFormatter(ArrayList<Integer> stitchesPerRow) {
        this.stitchesPerRow = stitchesPerRow;
    }

    private void formatPattern() {
        formattedPattern.add("Rd 1: " + stitchesPerRow.getFirst() + " sc in magic ring (" + stitchesPerRow.getFirst() + ")");

        for (int i = 1; i < stitchesPerRow.size(); i++) {
            String currentRow = "Rd " + (i + 1) + ": ";

            int previousStTotal = stitchesPerRow.get(i - 1);
            int currentStTotal = stitchesPerRow.get(i);
            int numIncreases = currentStTotal - previousStTotal;

            if (numIncreases != 0) {
                int numStitchesInRepeat = currentStTotal / numIncreases;

                int extraStitches = 0;
                if (numStitchesInRepeat * numIncreases != currentStTotal) {
                    extraStitches = currentStTotal - (numStitchesInRepeat * numIncreases);
                }

                currentRow += "(" + (numStitchesInRepeat - 2) + "sc, inc) x" + numIncreases;

                if (extraStitches != 0) {
                    currentRow += ", " + extraStitches + " sc";
                }
            } else {
                currentRow += "sc in each st in round";
            }

            currentRow += " (" + currentStTotal + ")";
            formattedPattern.add(currentRow);
        }
    }

    public void printPattern() {
        formatPattern();
        for (int i = 0; i < formattedPattern.size(); i++) {
            System.out.print("\n" + formattedPattern.get(i));
        }
    }
}
