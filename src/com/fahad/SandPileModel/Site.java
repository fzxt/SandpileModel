package com.fahad.SandPileModel;

import java.awt.Point;

public class Site {

    Point position;
    int currentState;

    public Site(Point position, int initialState) {
        this.position = position;
        this.currentState = initialState;
    }

    public void increment() {
        currentState++;
    }

    @Override
    public String toString() {
        return String.format("%d", currentState);
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setState(int state) {
        this.currentState = state;
    }

}
