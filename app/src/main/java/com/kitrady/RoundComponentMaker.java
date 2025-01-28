package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundComponentMaker {
    private final List<Integer> stitchesPerRound;
    private final List<String> formattedPattern = new ArrayList<>();
    private int alternateRoundToPreventBubblesCounter = 1;
    private RoundComponentAssembler assembler;

    public RoundComponentMaker(List<Integer> stitchesPerRound) {
        this.stitchesPerRound = stitchesPerRound;
    }

    public void formatPattern() {
        formattedPattern.add("Rd 1: " + stitchesPerRound.getFirst() + " sc in magic ring (" + stitchesPerRound.getFirst() + ")");

        int finalLargestRoundIndex = stitchesPerRound.lastIndexOf(Collections.max(stitchesPerRound));
        formatIncreaseRounds(stitchesPerRound, finalLargestRoundIndex);
        formatDecreaseRounds(stitchesPerRound, finalLargestRoundIndex);
    }

    private void formatIncreaseRounds(List<Integer> stitchesPerRound, int finalLargestRoundIndex) {
        for (int i = 1; i < finalLargestRoundIndex; i++) {
            String inProgressRound = "Rd " + (i + 1) + ": ";

            assembler = new RoundComponentAssembler();

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numIncreases = currentStitchTotal - previousStitchTotal;

            if (numIncreases == 0) {
                inProgressRound += "sc in each st in round";
            } else {
                int numStitchesInSection = currentStitchTotal / numIncreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numIncreases != currentStitchTotal) {
                    extraStitches = currentStitchTotal - (numStitchesInSection * numIncreases);
                }

                if (numSingleCrochetInSection == 0) {
                    inProgressRound += "inc in each st in round";
                } else {
                    // the numIncreases > 1 is needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numIncreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        assembler.updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                        assembler.updateRoundComponents(1, ComponentTypes.INCREASE);

                        assembler.updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);

                        assembler.updateRoundComponents(numIncreases - 1, ComponentTypes.REPEAT_COUNT);

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }
                        assembler.updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                    } else {
                        assembler.updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE);

                        assembler.updateRoundComponents(numIncreases, ComponentTypes.REPEAT_COUNT);
                    }
                    alternateRoundToPreventBubblesCounter++;
                    // TODO: the below comments describe an issue
                    // if increases in not greater than one, may be three normal rounds in a row
                    // or two in a row depending on whether you count 1 inc round to be normal
                    // solution is to either not increment the counter when inc <= 1
                    // or create code to format round as "# sc, inc # sc"
                }

                if (extraStitches > 0) {
                    assembler.updateRoundComponents(extraStitches, ComponentTypes.SINGLE_CROCHET);
                }
            }

            inProgressRound += assembler.assemble();

            inProgressRound += " (" + currentStitchTotal + ")";

            formattedPattern.add(inProgressRound);
        }
    }

    private void formatDecreaseRounds(List<Integer> stitchesPerRound, int finalLargestRdIndex) {
        for (int i = finalLargestRdIndex; i < stitchesPerRound.size(); i++) {
            String inProgressRound = "Rd " + (i + 1) + ": ";

            assembler = new RoundComponentAssembler();

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numDecreases = previousStitchTotal - currentStitchTotal;

            if (numDecreases == 0) {
                inProgressRound += "sc in each st in round";
            } else {
                int numStitchesInSection = previousStitchTotal / numDecreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numDecreases != previousStitchTotal) {
                    extraStitches = previousStitchTotal - (numStitchesInSection * numDecreases);
                }

                if (numSingleCrochetInSection == 0) {
                    inProgressRound += "dec in each st in round";
                } else {
                    // the numDecreases > 1 in needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numDecreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        assembler.updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                        assembler.updateRoundComponents(1, ComponentTypes.DECREASE);

                        assembler.updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);

                        assembler.updateRoundComponents(numDecreases - 1, ComponentTypes.REPEAT_COUNT);

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }

                        assembler.updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                    } else {
                        assembler.updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        assembler.updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);

                        assembler.updateRoundComponents(numDecreases, ComponentTypes.REPEAT_COUNT);
                    }
                    alternateRoundToPreventBubblesCounter++;
                }

                if (extraStitches > 0) {
                    assembler.updateRoundComponents(extraStitches, ComponentTypes.SINGLE_CROCHET);
                }
            }

            inProgressRound += assembler.assemble();

            inProgressRound += " (" + currentStitchTotal + ")";

            formattedPattern.add(inProgressRound);
        }
    }

    RoundComponentAssembler getAssembler() {
        return assembler;
    }

    public List<String> getFormattedPattern() {
        return formattedPattern;
    }

    public void printPattern() {
        for (String s : formattedPattern) {
            System.out.print("\n" + s);
        }
    }

    void formatGivenRounds(List<Integer> stitchesPerRound, boolean isDecrease) {
        if (isDecrease) {
            formatDecreaseRounds(stitchesPerRound, 1);
        } else {
            formatIncreaseRounds(stitchesPerRound, stitchesPerRound.size());
        }
    }
}