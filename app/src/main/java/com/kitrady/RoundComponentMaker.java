package com.kitrady;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RoundComponentMaker {
    private final List<Integer> stitchesPerRound;
    private int alternateRoundToPreventBubblesCounter = 1;
    private List<RoundComponent> roundComponents = new ArrayList<>();
    private final List<List<RoundComponent>> allRoundComponents = new ArrayList<>();

    public RoundComponentMaker(List<Integer> stitchesPerRound) {
        this.stitchesPerRound = stitchesPerRound;
    }

    public void formatPattern() {
        updateRoundComponents(1, ComponentType.ROUND_NUMBER);
        updateRoundComponents(stitchesPerRound.getFirst(), ComponentType.MAGIC_RING);
        updateRoundComponents(stitchesPerRound.getFirst(), ComponentType.STITCH_TOTAL);

        addRoundComponents();

        int finalLargestRoundIndex = stitchesPerRound.lastIndexOf(Collections.max(stitchesPerRound));
        formatIncreaseRounds(stitchesPerRound, finalLargestRoundIndex);
        formatDecreaseRounds(stitchesPerRound, finalLargestRoundIndex);
    }

    private void formatIncreaseRounds(List<Integer> stitchesPerRound, int finalLargestRoundIndex) {
        for (int i = 1; i < finalLargestRoundIndex; i++) {
            updateRoundComponents(i + 1, ComponentType.ROUND_NUMBER);

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numIncreases = currentStitchTotal - previousStitchTotal;

            if (numIncreases == 0) {
                updateRoundComponents(0, ComponentType.ALL_SINGLE_CROCHET);
            } else {
                int numStitchesInSection = currentStitchTotal / numIncreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numIncreases != currentStitchTotal) {
                    extraStitches = currentStitchTotal - (numStitchesInSection * numIncreases);
                }

                if (numSingleCrochetInSection == 0) {
                    updateRoundComponents(0, ComponentType.ALL_INCREASE);
                } else {
                    // the numIncreases > 1 is needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numIncreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET);
                        updateRoundComponents(1, ComponentType.INCREASE);

                        updateRoundComponents(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentType.REPEAT_INCREASE);

                        updateRoundComponents(numIncreases - 1, ComponentType.REPEAT_COUNT);

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }
                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET);
                    } else {
                        updateRoundComponents(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentType.REPEAT_INCREASE);

                        updateRoundComponents(numIncreases, ComponentType.REPEAT_COUNT);
                    }
                    alternateRoundToPreventBubblesCounter++;
                    // TODO: the below comments describe an issue
                    // if increases in not greater than one, may be three normal rounds in a row
                    // or two in a row depending on whether you count 1 inc round to be normal
                    // solution is to either not increment the counter when inc <= 1
                    // or create code to format round as "# sc, inc # sc"
                }

                if (extraStitches > 0) {
                    updateRoundComponents(extraStitches, ComponentType.SINGLE_CROCHET);
                }
            }
            updateRoundComponents(currentStitchTotal, ComponentType.STITCH_TOTAL);

            addRoundComponents();
        }
    }

    private void formatDecreaseRounds(List<Integer> stitchesPerRound, int finalLargestRdIndex) {
        for (int i = finalLargestRdIndex; i < stitchesPerRound.size(); i++) {
            updateRoundComponents(i + 1, ComponentType.ROUND_NUMBER);

            int previousStitchTotal = stitchesPerRound.get(i - 1);
            int currentStitchTotal = stitchesPerRound.get(i);
            int numDecreases = previousStitchTotal - currentStitchTotal;

            if (numDecreases == 0) {
                updateRoundComponents(0, ComponentType.ALL_SINGLE_CROCHET);
            } else {
                int numStitchesInSection = previousStitchTotal / numDecreases;
                int numSingleCrochetInSection = numStitchesInSection - 2;

                int extraStitches = 0;
                if (numStitchesInSection * numDecreases != previousStitchTotal) {
                    extraStitches = previousStitchTotal - (numStitchesInSection * numDecreases);
                }

                if (numSingleCrochetInSection == 0) {
                    updateRoundComponents(0, ComponentType.ALL_DECREASE);
                } else {
                    // the numDecreases > 1 in needed because alternate rounds need two repeats to work
                    if (alternateRoundToPreventBubblesCounter % 2 == 0 && numDecreases > 1) {
                        int numSingleCrochetInHalfSection = numSingleCrochetInSection / 2;

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET);
                        updateRoundComponents(1, ComponentType.DECREASE);

                        updateRoundComponents(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentType.REPEAT_DECREASE);

                        updateRoundComponents(numDecreases - 1, ComponentType.REPEAT_COUNT);

                        if (numSingleCrochetInHalfSection * 2 != numSingleCrochetInSection) {
                            numSingleCrochetInHalfSection += 1;
                        }

                        updateRoundComponents(numSingleCrochetInHalfSection, ComponentType.SINGLE_CROCHET);
                    } else {
                        updateRoundComponents(numSingleCrochetInSection, ComponentType.REPEAT_SINGLE_CROCHET);

                        updateRoundComponents(1, ComponentType.REPEAT_DECREASE);

                        updateRoundComponents(numDecreases, ComponentType.REPEAT_COUNT);
                    }
                    alternateRoundToPreventBubblesCounter++;
                }

                if (extraStitches > 0) {
                    updateRoundComponents(extraStitches, ComponentType.SINGLE_CROCHET);
                }
            }
            updateRoundComponents(currentStitchTotal, ComponentType.STITCH_TOTAL);

            addRoundComponents();
        }
    }

    private void updateRoundComponents(int componentCount, ComponentType componentType) {
        roundComponents.add(new RoundComponent(componentCount, componentType));
    }

    private void addRoundComponents() {
        allRoundComponents.add(roundComponents);
        roundComponents = new ArrayList<>();
    }

    public List<List<RoundComponent>> getAllRoundComponents() {
        return allRoundComponents;
    }

    void formatGivenRounds(List<Integer> stitchesPerRound, boolean isDecrease) {
        if (isDecrease) {
            formatDecreaseRounds(stitchesPerRound, 1);
        } else {
            formatIncreaseRounds(stitchesPerRound, stitchesPerRound.size());
        }
    }
}