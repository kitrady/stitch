package com.kitrady;

import java.util.ArrayList;
import java.util.List;

public class RoundComponentAssembler {
    private final List<List<RoundComponent>> allRoundComponents;
    private final List<String> formattedPattern = new ArrayList<>();

    public RoundComponentAssembler(List<List<RoundComponent>> allRoundComponents) {
        this.allRoundComponents = allRoundComponents;
    }

    public void assemble() {
        for (List<RoundComponent> roundComponents : allRoundComponents) {
            StringBuilder inProgressRound = new StringBuilder();
            ComponentType previousComponentType = null;
            int singleCrochetTotal = 0;
            int possibleRepeatSingleCrochets = 0;

            for (RoundComponent component : roundComponents) {
                int currentComponentCount = component.getCount();
                ComponentType currentComponentType = component.getType();

                if (currentComponentType == ComponentType.ROUND_NUMBER) {
                    inProgressRound.append("Rd ").append(currentComponentCount).append(":");
                } else if (inProgressRound.isEmpty() || inProgressRound.charAt(inProgressRound.length() - 1) == ':') {
                    switch (currentComponentType) {
                        case MAGIC_RING:
                            inProgressRound.append(" ").append(currentComponentCount).append(" sc in magic ring");
                            break;

                        case ALL_SINGLE_CROCHET:
                            inProgressRound.append(" sc in each st in round");
                            break;

                        case ALL_INCREASE:
                            inProgressRound.append(" inc in each st in round");
                            break;

                        case ALL_DECREASE:
                            inProgressRound.append(" dec in each st in round");
                            break;

                        case SINGLE_CROCHET:
                            singleCrochetTotal += currentComponentCount;
                            break;

                        case INCREASE:
                            if (previousComponentType == ComponentType.SINGLE_CROCHET) {
                                inProgressRound.append(" ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                                inProgressRound.append(", ").append(currentComponentCount).append(" inc");
                            } else {
                                inProgressRound.append(" ").append(currentComponentCount).append(" inc");
                            }
                            break;

                        case DECREASE:
                            if (previousComponentType == ComponentType.SINGLE_CROCHET) {
                                inProgressRound.append(" ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                                inProgressRound.append(", ").append(currentComponentCount).append(" dec");

                            } else {
                                inProgressRound.append(" ").append(currentComponentCount).append(" dec");
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
                                inProgressRound.append(" ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                                if (previousComponentType == ComponentType.REPEAT_INCREASE) {
                                    inProgressRound.append(", 1 inc");
                                } else {
                                    inProgressRound.append(", 1 dec");
                                }
                            } else {
                                if (previousComponentType == ComponentType.REPEAT_INCREASE) {
                                    inProgressRound.append(" (").append(possibleRepeatSingleCrochets).append(" sc, 1 inc) x").append(currentComponentCount);
                                } else {
                                    inProgressRound.append(" (").append(possibleRepeatSingleCrochets).append(" sc, 1 dec) x").append(currentComponentCount);
                                }
                            }
                            break;
                    }
                } else {
                    switch (currentComponentType) {
                        case SINGLE_CROCHET:
                            singleCrochetTotal += currentComponentCount;
                            break;

                        case INCREASE:
                            if (previousComponentType != null && previousComponentType.equals(ComponentType.SINGLE_CROCHET)) {
                                inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                            }
                            inProgressRound.append(", ").append(currentComponentCount).append(" inc");
                            break;

                        case DECREASE:
                            if (previousComponentType != null && previousComponentType.equals(ComponentType.SINGLE_CROCHET)) {
                                inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                            }
                            inProgressRound.append(", ").append(currentComponentCount).append(" dec");
                            break;

                        case REPEAT_SINGLE_CROCHET:
                            possibleRepeatSingleCrochets = currentComponentCount;
                            break;

                        case REPEAT_INCREASE, REPEAT_DECREASE:
                            break;

                        case REPEAT_COUNT:
                            if (currentComponentCount == 1) {
                                singleCrochetTotal += possibleRepeatSingleCrochets;
                                inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
                                singleCrochetTotal = 0;
                                if (previousComponentType == ComponentType.REPEAT_INCREASE) {
                                    inProgressRound.append(", 1 inc");
                                } else {
                                    inProgressRound.append(", 1 dec");
                                }
                            } else {
                                if (previousComponentType == ComponentType.REPEAT_INCREASE) {
                                    inProgressRound.append(", (").append(possibleRepeatSingleCrochets).append(" sc, 1 inc) x").append(currentComponentCount);
                                } else {
                                    inProgressRound.append(", (").append(possibleRepeatSingleCrochets).append(" sc, 1 dec) x").append(currentComponentCount);
                                }
                            }
                            break;
                    }
                }
                previousComponentType = currentComponentType;
            }

            if (singleCrochetTotal > 0) {
                inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
            }

            if (roundComponents.getLast().getType() == ComponentType.STITCH_TOTAL) {
                inProgressRound.append(" (").append(roundComponents.getLast().getCount()).append(")");
            }

            formattedPattern.add(inProgressRound.toString());
        }
    }

    List<String> getFormattedPattern() {
        return formattedPattern;
    }

    public void printPattern() {
        for (String s : formattedPattern) {
            System.out.print("\n" + s);
        }
    }
}
