package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundComponentMaker {
    private final List<Integer> stitchesPerRound;
    private final List<String> formattedPattern = new ArrayList<>();
    private int alternateRoundToPreventBubblesCounter = 1;
    private RoundComponentAssembler assembler;
    private final List<Integer> roundComponentCounts = new ArrayList<>();
    private final List<ComponentTypes> roundComponentTypes = new ArrayList<>();

    public RoundComponentMaker(List<Integer> stitchesPerRound) {
        this.stitchesPerRound = stitchesPerRound;
    }

    public void formatPattern() {
        roundComponentCounts.clear();
        roundComponentTypes.clear();
        updateRoundComponents(1, ComponentTypes.ROUND_NUMBER); // add to Makers instance variables instead
        updateRoundComponents(stitchesPerRound.getFirst(), ComponentTypes.MAGIC_RING); // add to Makers instance variables instead
        updateRoundComponents(stitchesPerRound.getFirst(), ComponentTypes.STITCH_TOTAL); // add to Makers instance variables instead
        assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);
        formattedPattern.add(assembler.assemble()); // this happens runner instead

        int finalLargestRoundIndex = stitchesPerRound.lastIndexOf(Collections.max(stitchesPerRound));
        formatIncreaseRounds(stitchesPerRound, finalLargestRoundIndex);
        formatDecreaseRounds(stitchesPerRound, finalLargestRoundIndex);
    }

    private void formatIncreaseRounds(List<Integer> stitchesPerRound, int finalLargestRoundIndex) {
        for (int i = 1; i < finalLargestRoundIndex; i++) {
            roundComponentCounts.clear();
            roundComponentTypes.clear();
            String inProgressRound = "";
            updateRoundComponents(i + 1, ComponentTypes.ROUND_NUMBER); // add to Makers instance variables instead

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numIncreases = currentStitchTotal - previousStitchTotal;

            if (numIncreases == 0) {
                updateRoundComponents(0, ComponentTypes.ALL_SINGLE_CROCHET); // add to Makers instance variables instead
            } else {
                int numStitchesInSection = currentStitchTotal / numIncreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numIncreases != currentStitchTotal) {
                    extraStitches = currentStitchTotal - (numStitchesInSection * numIncreases);
                }

                if (numSingleCrochetInSection == 0) {
                    updateRoundComponents(0, ComponentTypes.ALL_INCREASE); // add to Makers instance variables instead
                } else {
                    // the numIncreases > 1 is needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numIncreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET); // add to Makers instance variables instead
                        updateRoundComponents(1, ComponentTypes.INCREASE); // add to Makers instance variables instead

                        updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET); // add to Makers instance variables instead

                        updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE); // add to Makers instance variables instead

                        updateRoundComponents(numIncreases - 1, ComponentTypes.REPEAT_COUNT); // add to Makers instance variables instead

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }
                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET); // add to Makers instance variables instead
                    } else {
                        updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET); // add to Makers instance variables instead

                        updateRoundComponents(1, ComponentTypes.REPEAT_INCREASE); // add to Makers instance variables instead

                        updateRoundComponents(numIncreases, ComponentTypes.REPEAT_COUNT); // add to Makers instance variables instead
                    }
                    alternateRoundToPreventBubblesCounter++;
                    // TODO: the below comments describe an issue
                    // if increases in not greater than one, may be three normal rounds in a row
                    // or two in a row depending on whether you count 1 inc round to be normal
                    // solution is to either not increment the counter when inc <= 1
                    // or create code to format round as "# sc, inc # sc"
                }

                if (extraStitches > 0) {
                    updateRoundComponents(extraStitches, ComponentTypes.SINGLE_CROCHET); // add to Makers instance variables instead
                }
            }
            updateRoundComponents(currentStitchTotal, ComponentTypes.STITCH_TOTAL);

            assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);

            inProgressRound += assembler.assemble(); // called from runner instead

            formattedPattern.add(inProgressRound); // happens in runner instead
        }
    }

    private void formatDecreaseRounds(List<Integer> stitchesPerRound, int finalLargestRdIndex) {
        for (int i = finalLargestRdIndex; i < stitchesPerRound.size(); i++) {
            roundComponentCounts.clear();
            roundComponentTypes.clear();
            String inProgressRound = "";
            updateRoundComponents(i + 1, ComponentTypes.ROUND_NUMBER);

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numDecreases = previousStitchTotal - currentStitchTotal;

            if (numDecreases == 0) {
                updateRoundComponents(0, ComponentTypes.ALL_SINGLE_CROCHET);
            } else {
                int numStitchesInSection = previousStitchTotal / numDecreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numDecreases != previousStitchTotal) {
                    extraStitches = previousStitchTotal - (numStitchesInSection * numDecreases);
                }

                if (numSingleCrochetInSection == 0) {
                    updateRoundComponents(0, ComponentTypes.ALL_DECREASE);
                } else {
                    // the numDecreases > 1 in needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numDecreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                        updateRoundComponents(1, ComponentTypes.DECREASE);

                        updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);

                        updateRoundComponents(numDecreases - 1, ComponentTypes.REPEAT_COUNT);

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentTypes.SINGLE_CROCHET);
                    } else {
                        updateRoundComponents(numSingleCrochetInSection, ComponentTypes.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentTypes.REPEAT_DECREASE);

                        updateRoundComponents(numDecreases, ComponentTypes.REPEAT_COUNT);
                    }
                    alternateRoundToPreventBubblesCounter++;
                }

                if (extraStitches > 0) {
                    updateRoundComponents(extraStitches, ComponentTypes.SINGLE_CROCHET);
                }
            }
            updateRoundComponents(currentStitchTotal, ComponentTypes.STITCH_TOTAL);

            assembler = new RoundComponentAssembler(roundComponentCounts, roundComponentTypes);

            inProgressRound += assembler.assemble();

            formattedPattern.add(inProgressRound);
        }
    }

    public List<String> getFormattedPattern() {
        return formattedPattern;
    }

    private void updateRoundComponents(int componentCount, ComponentTypes componentType) {
        roundComponentCounts.add(componentCount);
        roundComponentTypes.add(componentType);
    }

    public List<Integer> getRoundComponentCounts() {
        return roundComponentCounts;
    }

    public List<ComponentTypes> getRoundComponentTypes() {
        return roundComponentTypes;
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