package com.kitrady;

public class RoundComponent {
    private final int count;
    private final ComponentType type;

    public RoundComponent(int count, ComponentType type) {
        this.count = count;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public ComponentType getType() {
        return type;
    }
}
