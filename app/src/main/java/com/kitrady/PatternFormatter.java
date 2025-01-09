package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;

public class PatternFormatter {
    private ArrayList<Integer> stitchesPerRd = new ArrayList<Integer>();
    private ArrayList<String> formattedPattern = new ArrayList<String>();

    public PatternFormatter(ArrayList<Integer> stitchesPerRd) {
        this.stitchesPerRd = stitchesPerRd;
    }

    private void formatPattern() {
        // creates first round separately because of magic ring technique
        formattedPattern.add("Rd 1: " + stitchesPerRd.getFirst() + " sc in magic ring (" + stitchesPerRd.getFirst() + ")");

        int FinalLargestRdIndex = stitchesPerRd.lastIndexOf(Collections.max(stitchesPerRd)); // finds last round that could need increases
        formatIncreaseRounds(FinalLargestRdIndex);
        formatDecreaseRounds(FinalLargestRdIndex);
    }

    public void formatIncreaseRounds(int FinalLargestRdIndex) {
        // loops to create each round of pattern that needs increases
        for (int i = 1; i < FinalLargestRdIndex; i++) {
            String currentRound = "Rd " + (i + 1) + ": "; // adds round number

            int previousStTotal = stitchesPerRd.get(i - 1);
            int currentStTotal = stitchesPerRd.get(i);
            int numIncreases = currentStTotal - previousStTotal;

            // checks if any increases are needed
            if (numIncreases > 0) {
                int numStitchesInRepeat = currentStTotal / numIncreases;

                // if increases don't divide evenly into stitch total, calculates remaining stitches
                int extraStitches = 0;
                if (numStitchesInRepeat * numIncreases != currentStTotal) {
                    extraStitches = currentStTotal - (numStitchesInRepeat * numIncreases);
                }

                // checks if any single crochets are needed
                if (numStitchesInRepeat - 2 > 0) {
                    currentRound += "(" + (numStitchesInRepeat - 2) + "sc, inc) x" + numIncreases;
                }
                // round is all increases if no single crochets are needed
                else {
                    currentRound += "inc in each st in round";
                }

                // adds extra stitches if there are any
                if (extraStitches > 0) {
                    currentRound += ", " + extraStitches + " sc";
                }
            }
            // round is all single crochets if no increases are needed
            else {
                currentRound += "sc in each st in round";
            }

            // adds total stitch count to end
            currentRound += " (" + currentStTotal + ")";

            // adds the round to the collection of rounds
            formattedPattern.add(currentRound);
        }
    }

    public void formatDecreaseRounds(int FinalLargestRdIndex) {
        for (int i = FinalLargestRdIndex; i < stitchesPerRd.size(); i++) {
            String currentRound = "Rd " + (i + 1) + ": "; // adds round number

            int previousStTotal = stitchesPerRd.get(i - 1);
            int currentStTotal = stitchesPerRd.get(i);
            int numDecreases = previousStTotal - currentStTotal;

            // checks if any decreases are needed
            if (numDecreases > 0) {
                int numStitchesInRepeat = previousStTotal / numDecreases;

                // if decreases don't divide evenly into stitch total, calculates remaining stitches
                int extraStitches = 0;
                if (numStitchesInRepeat * numDecreases != previousStTotal) {
                    extraStitches = previousStTotal - (numStitchesInRepeat * numDecreases);
                }

                // checks if any single crochets are needed
                if (numStitchesInRepeat - 2 > 0) {
                    currentRound += "(" + (numStitchesInRepeat - 2) + "sc, dec) x" + numDecreases;
                }
                // round is all decreases if no single crochets are needed
                else {
                    currentRound += "dec in each st in round";
                }

                // adds extra stitches if there are any
                if (extraStitches > 0) {
                    currentRound += ", " + extraStitches + " sc";
                }
            }
            // round is all single crochets if no decreases are needed
            else {
                currentRound += "sc in each st in round";
            }

            // adds total stitch count to end
            currentRound += " (" + currentStTotal + ")";

            // adds the round to the collection of rounds
            formattedPattern.add(currentRound);
        }
    }

    public ArrayList<String> getFormattedPattern() {
        formatPattern();
        return formattedPattern;
    }

    public void printPattern() {
        formatPattern();
        for (String s : formattedPattern) {
            System.out.print("\n" + s);
        }
    }
}
