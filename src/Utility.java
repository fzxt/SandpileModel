import java.awt.Point;
import java.util.ArrayList;

public class Utility {

    /**
     * Utility method to get valid neighbour points.
     * A valid neighbour is one whose position is in the bounds of 0 < neighbour.x && neighbour.y < max
     * @param site      Site whose neighbours you are checking
     * @param max       Max bounds
     * @return          List of points of Valid neighbours
     */
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