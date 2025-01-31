package com.kitrady;

import java.util.List;

public class RoundComponentAssembler {
    private final List<Integer> roundComponentCounts;
    private final List<ComponentTypes> roundComponentTypes;

    public RoundComponentAssembler(List<Integer> roundComponentCounts, List<ComponentTypes> roundComponentTypes) {
        this.roundComponentCounts = roundComponentCounts;
        this.roundComponentTypes = roundComponentTypes;
    }

    public String assemble() {
        StringBuilder inProgressRound = new StringBuilder();
        ComponentTypes previousComponentType = null;
        int singleCrochetTotal = 0;
        int possibleRepeatSingleCrochets = 0;

        for (int i = 0; i < roundComponentCounts.size(); i++) {
            int currentComponentCount = roundComponentCounts.get(i);
            ComponentTypes currentComponentType = roundComponentTypes.get(i);

            if (currentComponentType == ComponentTypes.ROUND_NUMBER) {
                inProgressRound.append("Rd ").append(currentComponentCount).append(":");
            }

            else if (inProgressRound.isEmpty() || inProgressRound.charAt(inProgressRound.length() - 1) == ':' ) {
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
                        if (previousComponentType == ComponentTypes.SINGLE_CROCHET) {
                            inProgressRound.append(" ").append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            inProgressRound.append(", inc");
                        } else {
                            inProgressRound.append(" inc");
                        }
                        break;

                    case DECREASE:
                        if (previousComponentType == ComponentTypes.SINGLE_CROCHET) {
                            inProgressRound.append(" ").append(singleCrochetTotal).append(" sc");
                            singleCrochetTotal = 0;
                            inProgressRound.append(", dec");

                        } else {
                            inProgressRound.append(" dec");
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
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append(", inc");
                            } else {
                                inProgressRound.append(", dec");
                            }
                        } else {
                            if (previousComponentType == ComponentTypes.REPEAT_INCREASE) {
                                inProgressRound.append(" (").append(possibleRepeatSingleCrochets).append(" sc, inc) x").append(currentComponentCount);
                            } else {
                                inProgressRound.append(" (").append(possibleRepeatSingleCrochets).append(" sc, dec) x").append(currentComponentCount);
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
                        break;
                }
            }
            previousComponentType = currentComponentType;
        }

        if (singleCrochetTotal > 0) {
            inProgressRound.append(", ").append(singleCrochetTotal).append(" sc");
        }

        if (roundComponentTypes.getLast() == ComponentTypes.STITCH_TOTAL) {
            inProgressRound.append(" (").append(roundComponentCounts.getLast()).append(")");
        }

        return inProgressRound.toString();
    }
}
