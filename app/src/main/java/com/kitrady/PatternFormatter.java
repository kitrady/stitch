package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;

public class PatternFormatter {
    private ArrayList<Integer> stitchesPerRd = new ArrayList<Integer>();
    private ArrayList<String> formattedPattern = new ArrayList<String>();
    private int alternateRdCounter = 1; // alternate rounds are used to make sure the increases don't line up and create bubbles

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
                int numStitchesInSection = currentStTotal / numIncreases;
                int numScInSection = numStitchesInSection - 2;

                // if increases don't divide evenly into stitch total, calculates remaining stitches
                int extraStitches = 0;
                if (numStitchesInSection * numIncreases != currentStTotal) {
                    extraStitches = currentStTotal - (numStitchesInSection * numIncreases);
                }

                // checks if any single crochets are needed
                if (numScInSection > 0) {
                    // checks if there are multiple sections in the round
                    if (numIncreases > 1) {
                        // checks if round should have alternate format where one of the sections is split in half
                        if (alternateRdCounter % 2 == 0) {
                            int numScInHalfSection = numScInSection / 2; // finds sc in each part of half section

                            // adds "second" half of sc to extra stitches, just because this is a convenient way to incorporate the stitches
                            extraStitches += numScInHalfSection;

                            // checks if truncation occurred when finding number of sc in half section
                            if (numScInHalfSection * 2 != numScInSection) {
                                extraStitches += 1; // if truncation did occur, add an extra stitch
                            }
                            currentRound += numScInHalfSection + " sc, inc, (" + numScInSection + " sc, inc) x" + (numIncreases - 1);
                        }
                        // otherwise, uses normal format
                        else {
                            currentRound += "(" + numScInSection + " sc, inc) x" + numIncreases;
                        }
                        alternateRdCounter++;
                    }
                    // otherwise there is only one section
                    else {
                        currentRound += numScInSection + " sc, inc";
                    }
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
                int numStitchesInSection = previousStTotal / numDecreases;
                int numScInSection = numStitchesInSection - 2;

                // if decreases don't divide evenly into stitch total, calculates remaining stitches
                int extraStitches = 0;
                if (numStitchesInSection * numDecreases != previousStTotal) {
                    extraStitches = previousStTotal - (numStitchesInSection * numDecreases);
                }

                // checks if any single crochets are needed
                if (numScInSection > 0) {
                    // checks if there are multiple sections in the round
                    if (numDecreases > 1) {
                        if (alternateRdCounter % 2 == 0) {
                            int numScInHalfSection = numScInSection / 2; // finds sc in each part of half section

                            // adds "second" half of sc to extra stitches, just because this is a convenient way to incorporate the stitches
                            extraStitches += numScInHalfSection;

                            // checks if truncation occurred when finding number of sc in half section
                            if (numScInHalfSection * 2 != numScInSection) {
                                extraStitches += 1; // if truncation did occur, add an extra stitch
                            }
                            currentRound += numScInHalfSection + " sc, dec, (" + numScInSection + " sc, dec) x" + (numDecreases - 1);
                        }
                        else {
                            currentRound += "(" + (numStitchesInSection - 2) + " sc, dec) x" + numDecreases;
                        }
                        alternateRdCounter++;
                    }
                    // otherwise, there is only one section
                    else {
                        currentRound += numScInSection + " sc, dec";
                    }
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
