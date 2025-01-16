package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;

public class PatternFormatter {
    private final ArrayList<Integer> stitchesPerRd;
    private final ArrayList<String> formattedPattern = new ArrayList<>();
    private int alternateRdCounter = 1; // alternate rounds are used to make sure the increases don't line up and create bubbles

    public PatternFormatter(ArrayList<Integer> stitchesPerRd) {
        this.stitchesPerRd = stitchesPerRd;
    }

    private void formatPattern() {
        // creates first round separately because of magic ring technique
        formattedPattern.add("Rd 1: " + stitchesPerRd.getFirst() + " sc in magic ring (" + stitchesPerRd.getFirst() + ")");

        int finalLargestRdIndex = stitchesPerRd.lastIndexOf(Collections.max(stitchesPerRd)); // finds last round that could need increases
        formatIncreaseRounds(finalLargestRdIndex);
        formatDecreaseRounds(finalLargestRdIndex);
    }

    public void formatIncreaseRounds(int finalLargestRdIndex) {
        // loops to create each round of pattern that needs increases
        for (int i = 1; i < finalLargestRdIndex; i++) {
            // current round is the string containing the round that is currently being built
            String currentRound = "Rd " + (i + 1) + ": "; // adds round number to the current round

            ArrayList<Integer> roundComponentCounts = new ArrayList<>(); // holds all the counts associated with the components of the round
            ArrayList<StitchTypes> roundComponentTypes = new ArrayList<>(); // hold the types of each component of the round
            // the above components will be added to the current round once they are fully formatted

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
                    // checks if round should have alternate format where one of the sections is split in half
                    if (alternateRdCounter % 2 == 0) {
                        int numScInHalfSection = numScInSection / 2; // finds sc in each part of half section

                        // adds first piece of half section to round components
                        roundComponentCounts.add(numScInHalfSection);
                        roundComponentTypes.add(StitchTypes.SC);
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.INC);

                        // adds the sc that are part of the repeat to the round components
                        roundComponentCounts.add(numScInSection);
                        roundComponentTypes.add(StitchTypes.REPEAT_SC);

                        // adds the inc that are part of the repeat to the round components
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.REPEAT_INC);

                        // adds number of times the repeat is done to the round components
                        roundComponentCounts.add(numIncreases - 1);
                        roundComponentTypes.add(StitchTypes.REPEAT_COUNT);

                        // checks if truncation occurred when finding number of sc in half section
                        if (numScInHalfSection * 2 != numScInSection) {
                            numScInHalfSection += 1; // if truncation did occur, add an extra stitch
                        }

                        // adds second piece of half section to round components
                        roundComponentCounts.add(numScInHalfSection);
                        roundComponentTypes.add(StitchTypes.SC);
                    }
                    // otherwise, uses normal format
                    else {
                        // adds the sc that are part of the repeat to the round components
                        roundComponentCounts.add(numScInSection);
                        roundComponentTypes.add(StitchTypes.REPEAT_SC);

                        // adds the inc that are part of the repeat to the round components
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.REPEAT_INC);

                        // adds number of times the repeat is done to the round components
                        roundComponentCounts.add(numIncreases);
                        roundComponentTypes.add(StitchTypes.REPEAT_COUNT);
                    }
                    alternateRdCounter++;
                }

                // round is all increases if no single crochets are needed
                else {
                    currentRound += "inc in each st in round";
                }

                // adds extra stitches if there are any
                if (extraStitches > 0) {
                    // adds extra stitches to round components
                    roundComponentCounts.add(extraStitches);
                    roundComponentTypes.add(StitchTypes.SC);
                }
            }
            // round is all single crochets if no increases are needed
            else {
                currentRound += "sc in each st in round";
            }

            currentRound += assembleRoundComponents(roundComponentCounts, roundComponentTypes);

            // adds total stitch count to end
            currentRound += " (" + currentStTotal + ")";

            // adds the round to the collection of rounds
            formattedPattern.add(currentRound);
        }
    }

    public void formatDecreaseRounds(int finalLargestRdIndex) {
        for (int i = finalLargestRdIndex; i < stitchesPerRd.size(); i++) {
            // current round is the string containing the round that is currently being built
            String currentRound = "Rd " + (i + 1) + ": "; // adds round number to the current round

            ArrayList<Integer> roundComponentCounts = new ArrayList<>(); // holds all the counts associated with the components of the round
            ArrayList<StitchTypes> roundComponentTypes = new ArrayList<>(); // hold the types of each component of the round
            // the above components will be added to the current round once they are fully formatted

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
                    // checks if round should have alternate format where one of the sections is split in half
                    if (alternateRdCounter % 2 == 0 && numDecreases > 1) {
                        int numScInHalfSection = numScInSection / 2; // finds sc in each part of half section

                        // adds first piece of half section to round components
                        roundComponentCounts.add(numScInHalfSection);
                        roundComponentTypes.add(StitchTypes.SC);
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.DEC);

                        // adds the sc that are part of the repeat to the round components
                        roundComponentCounts.add(numScInSection);
                        roundComponentTypes.add(StitchTypes.REPEAT_SC);

                        // adds the dec that are part of the repeat to the round components
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.REPEAT_DEC);

                        // adds number of times the repeat is done to the round components
                        roundComponentCounts.add(numDecreases - 1);
                        roundComponentTypes.add(StitchTypes.REPEAT_COUNT);

                        // checks if truncation occurred when finding number of sc in half section
                        if (numScInHalfSection * 2 != numScInSection) {
                            extraStitches += 1; // if truncation did occur, add an extra stitch
                        }

                        // adds second piece of half section to round components
                        roundComponentCounts.add(numScInHalfSection);
                        roundComponentTypes.add(StitchTypes.SC);
                    }
                    // otherwise, uses normal format
                    else {
                        // adds the sc that are part of the repeat to the round components
                        roundComponentCounts.add(numScInSection);
                        roundComponentTypes.add(StitchTypes.REPEAT_SC);

                        // adds the dec that are part of the repeat to the round components
                        roundComponentCounts.add(1);
                        roundComponentTypes.add(StitchTypes.REPEAT_DEC);

                        // adds number of times the repeat is done to the round components
                        roundComponentCounts.add(numDecreases);
                        roundComponentTypes.add(StitchTypes.REPEAT_COUNT);
                    }
                    alternateRdCounter++;
                }
                // round is all decreases if no single crochets are needed
                else {
                    currentRound += "dec in each st in round";
                }

                // adds extra stitches if there are any
                if (extraStitches > 0) {
                    // adds extra stitches to round components
                    roundComponentCounts.add(extraStitches);
                    roundComponentTypes.add(StitchTypes.SC);
                }
            }
            // round is all single crochets if no decreases are needed
            else {
                currentRound += "sc in each st in round";
            }

            currentRound += assembleRoundComponents(roundComponentCounts, roundComponentTypes);

            // adds total stitch count to end
            currentRound += " (" + currentStTotal + ")";

            // adds the round to the collection of rounds
            formattedPattern.add(currentRound);
        }
    }

    public String assembleRoundComponents(ArrayList<Integer> stCounts, ArrayList<StitchTypes> stTypes) {
        StringBuilder currentRound = new StringBuilder(); // the round that is currently being assembled
        StitchTypes previousType = null; // the type of the previous component
        int scTotal = 0; // the running total of concurrent single crochets
        int possiblyRepeatedSc = 0; // single crochets that are possibly repeated, depending on whether repeat count is greater than one

        for (int i = 0; i < stCounts.size(); i++) {
            int currentComponentCount = stCounts.get(i);
            StitchTypes currentComponentType = stTypes.get(i);

            // formatting to use when nothing has been added to the current round
            if (currentRound.isEmpty()) {
                switch (currentComponentType) {
                    case SC: // if the current component is a sc
                        scTotal += currentComponentCount; // add it to running total
                        break;

                    case INC: // if the current component is an inc
                        if (previousType == null) { // and there were no sc preceding the inc
                            currentRound.append("inc"); // add the formatted inc to the current round
                        }
                        else { // and there were sc preceding the inc
                            currentRound.append(scTotal).append(" sc"); // add the formatted sc to the current round
                            scTotal = 0; // reset the running sc total
                            currentRound.append(", inc"); // and add the formatted inc to the current round
                        }
                        break;

                    case DEC: // if the current component is a dec
                        if (previousType == null) { // and there were NO sc preceding the dec
                            currentRound.append("dec"); // add the formatted dec to the current round
                        }
                        else { // and there were sc preceding the dec
                            currentRound.append(scTotal).append(" sc"); // add the formatted sc to the current round
                            scTotal = 0; // reset the running sc total
                            currentRound.append(", dec"); // and add the formatted dec to the current round
                        }
                        break;

                    case REPEAT_SC: // if the current component is a sc that could be part of a repeat
                        possiblyRepeatedSc = currentComponentCount; // add it to the possibly repeated single crochets
                        break;

                    case REPEAT_INC: // if the current component is an inc that could be part of a repeat
                        break; // nothing needs to happen as inc are always in groups of one

                    case REPEAT_DEC: // if the current component is a dec that could be part of a repeat
                        break; // nothing needs to happen as dec are always in groups of one

                    case REPEAT_COUNT: // if the current component is the number of times the repeat is done
                        if (currentComponentCount == 1) { // and that number is one
                            // treat the possible repeat stitches as normal stitches
                            scTotal += possiblyRepeatedSc;
                            currentRound.append(scTotal).append(" sc");
                            scTotal = 0;
                            if (previousType == StitchTypes.REPEAT_INC) { // checks previous type to know whether to add inc or dec
                                currentRound.append(", inc");
                            }
                            else {
                                currentRound.append(", dec");
                            }
                        }
                        else { // and that number is greater than one
                            // add the formatted repeat to the current round
                            if (previousType == StitchTypes.REPEAT_INC) { // checks previous type to know whether to add inc or dec
                                currentRound.append("(").append(possiblyRepeatedSc).append(" sc, inc) x").append(currentComponentCount);
                            }
                            else {
                                currentRound.append("(").append(possiblyRepeatedSc).append(" sc, dec) x").append(currentComponentCount);
                            }
                        }
                }
            }
            // formatting to use when something has been added to the current round
            // logic is very similar to code in 'if' block, just uses different formatting when adding to current round
            else {
                switch (currentComponentType) {
                    case SC:
                        scTotal += currentComponentCount;
                        break;

                    case INC:
                        if (previousType != null && previousType.equals(StitchTypes.SC)) {
                            currentRound.append(", ").append(scTotal).append(" sc");
                            scTotal = 0;
                        }
                        currentRound.append(", inc");
                        break;

                    case DEC:
                        if (previousType != null && previousType.equals(StitchTypes.SC)) {
                            currentRound.append(", ").append(scTotal).append(" sc");
                            scTotal = 0;
                        }
                        currentRound.append(", dec");
                        break;

                    case REPEAT_SC:
                        possiblyRepeatedSc = currentComponentCount;
                        break;

                    case REPEAT_INC:
                        break; // nothing needs to happen as inc are always in groups of one

                    case REPEAT_DEC:
                        break; // nothing needs to happen as dec are always in groups of one

                    case REPEAT_COUNT:
                        if (currentComponentCount < 2) {
                            scTotal += possiblyRepeatedSc;
                            currentRound.append(", ").append(scTotal).append(" sc");
                            scTotal = 0;
                            if (previousType == StitchTypes.REPEAT_INC) {
                                currentRound.append(", inc");
                            }
                            else {
                                currentRound.append(", dec");
                            }
                        }
                        else {
                            if (previousType == StitchTypes.REPEAT_INC) {
                                currentRound.append(", (").append(possiblyRepeatedSc).append(" sc, inc) x").append(currentComponentCount);
                            }
                            else {
                                currentRound.append(", (").append(possiblyRepeatedSc).append(" sc, dec) x").append(currentComponentCount);
                            }
                        }
                }
            }
            previousType = currentComponentType;
        }
        // checks if there were still sc in the sc total that were never added to the current round
        if (scTotal > 0) {
            currentRound.append(", ").append(scTotal).append(" sc");
        }
        return currentRound.toString();
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
