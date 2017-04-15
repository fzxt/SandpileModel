package com.fahad.SandPileModel;

public class Point {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point && ((Point) obj).x == this.x && ((Point) obj).y == this.y;
    }

    @Override
    public String toString() {
        return "X: " + x + " Y: " + y;
    }
}
