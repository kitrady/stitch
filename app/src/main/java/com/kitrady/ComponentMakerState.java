package com.kitrady;

public interface ComponentMakerState {
    ComponentMakerState step(ComponentMakerRoundInfo info);

    default boolean isEndState() {
        return false;
    }
}
