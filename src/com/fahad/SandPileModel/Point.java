package com.fahad.SandPileModel;

public class Point {

    int x, y;

    public Point(int x, int y) {
        assert x >= 0 && y >= 0;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}
