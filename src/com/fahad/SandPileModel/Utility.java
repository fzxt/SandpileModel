package com.fahad.SandPileModel;

import java.util.ArrayList;

public class Utility {

    public static ArrayList<Point> getValidNeighbourPoints(Site site, int max) {
        ArrayList<Point> validPoints = new ArrayList<>();

        Point[] directionPoints = {
                // Up
                new Point(site.position.x-1, site.position.y),
                // Down
                new Point(site.position.x+1, site.position.y),
                // Left
                new Point(site.position.x, site.position.y-1),
                // Right
                new Point(site.position.x, site.position.y+1)
        };

        for (Point p : directionPoints) {
            if ((p.x >= 0 && p.x <= max) && (p.y >= 0 && p.y <= max)) {
                validPoints.add(p);
            }
        }

        return validPoints;
    }
}