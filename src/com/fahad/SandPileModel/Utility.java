package com.fahad.SandPileModel;

import java.util.ArrayList;

class Utility {

    public static ArrayList<Point> getValidNeighbourPoints(Site site, int min, int max) {
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
            if ((p.x >= min && p.x <= max) && (p.y >= min && p.y <= max)) {
                validPoints.add(p);
            }
        }

        return validPoints;
    }
}