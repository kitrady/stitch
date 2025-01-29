package com.kitrady;

import java.util.ArrayList;

public class RoundComponentAssembler {
    private final ArrayList<Integer> roundComponentCounts;
    private final ArrayList<ComponentTypes> roundComponentTypes;

    public RoundComponentAssembler() {
        roundComponentCounts = new ArrayList<>();
        roundComponentTypes = new ArrayList<>();
    }

    public void updateRoundComponents(int componentCount, ComponentTypes componentType) {
        roundComponentCounts.add(componentCount);
        roundComponentTypes.add(componentType);
    }

    public ArrayList<Integer> getRoundComponentCounts() {
        return roundComponentCounts;
    }

    public ArrayList<ComponentTypes> getRoundComponentTypes() {
        return roundComponentTypes;
    }

    public String assemble() {
        StringBuilder inProgressRound = new StringBuilder();
        ComponentTypes previousComponentType = null;
        int singleCrochetTotal = 0;
        int possibleRepeatSingleCrochets = 0;

        for (int i = 0; i < roundComponentCounts.size(); i++) {
            int currentComponentCount = roundComponentCounts.get(i);
            ComponentTypes currentComponentType = roundComponentTypes.get(i);

            if (inProgressRound.isEmpty()) {
                switch (currentComponentType) {
                    case SINGLE_CROCHET:
                        singleCrochetTotal += currentComponentCount;
                        break;

                    case INCREASE:
                        if (previousComponentType == null) {
                            inProgressRound.append("inc");
                        } else {
                            inProgressRound.append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            inProgressRound.append(", inc");
                        }
                        break;

                    case DECREASE:
                        if (previousComponentType == null) {
                            inProgressRound.append("dec");
                        } else {
                            inProgressRound.append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            inProgressRound.append(", dec");
                        }
                        break;

                    case REPEAT_SINGLE_CROCHET:
                        possibleRepeatSingleCrochets = currentComponentCount;
                        break;

                    case REPEAT_INCREASE, REPEAT_DECREASE:
                        break;

                    case REPEAT_COUNT:
                        if (currentComponentCount == 1) {
                            singleCrochetTotal += possibleRepeatSingleCrochets;
                            inProgressRound.append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append(", inc");
                            } else {
                                inProgressRound.append(", dec");
                            }
                        } else {
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append("(").append(possibleRepeatSingleCrochets).append(" sc, inc) x").append(currentComponentCount);
                            } else {
                                inProgressRound.append("(").append(possibleRepeatSingleCrochets).append(" sc, dec) x").append(currentComponentCount);
                            }
                        }
                }
            } else {
                switch (currentComponentType) {
                    case SINGLE_CROCHET:
                        singleCrochetTotal += currentComponentCount;
                        break;

                    case INCREASE:
                        if (previousComponentType != null && previousComponentType.equals(ComponentTypes.SINGLE_CROCHET)) {
                            inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                        }
                        inProgressRound.append(", inc");
                        break;

                    case DECREASE:
                        if (previousComponentType != null && previousComponentType.equals(ComponentTypes.SINGLE_CROCHET)) {
                            inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                        }
                        inProgressRound.append(", dec");
                        break;

                    case REPEAT_SINGLE_CROCHET:
                        possibleRepeatSingleCrochets = currentComponentCount;
                        break;

                    case REPEAT_INCREASE, REPEAT_DECREASE:
                        break;

                    case REPEAT_COUNT:
                        if (currentComponentCount < 2) {
                            singleCrochetTotal += possibleRepeatSingleCrochets;
                            inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append(", inc");
                            }
                            else {
                                inProgressRound.append(", dec");
                            }
                        }
                        else {
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append(", (").append(possibleRepeatSingleCrochets).append(" sc, inc) x").append(currentComponentCount);
                            }
                            else {
                                inProgressRound.append(", (").append(possibleRepeatSingleCrochets).append(" sc, dec) x").append(currentComponentCount);
                            }
                        }
                }
            }
            previousComponentType = currentComponentType;
        }

        if (singleCrochetTotal > 0) {
            inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
        }

        return inProgressRound.toString();
    }
}
