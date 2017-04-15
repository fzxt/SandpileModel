package tests;

import com.fahad.SandPileModel.Grid;
import com.fahad.SandPileModel.Point;
import com.fahad.SandPileModel.Site;

public class MockGrids {

    /**
     * [0, 0, 0]
     * [0, 4, 0]
     * [0, 0, 0]
     */
    public static Grid getTestGrid1() {
        // 3x3 Grid
        Grid grid = new Grid(3);
        Point midPoint = new Point(1, 1);

        // Set the middle site to 4
        Site middleSite = grid.getSiteAtPoint(midPoint);
        middleSite.setState(4);

        return grid;
    }


    /**
     * [0, 3, 3, 0]
     * [0, 3, 0, 3]
     * [0, 3, 3, 3]
     * [3, 3, 0, 0]
     */
    public static Grid getTestGrid2() {
        // 4x4 Grid
        Grid grid = new Grid(4);

        Point[] targetPoints = {
                new Point(0, 1),
                new Point(0, 2),
                new Point(1, 1),
                new Point(1, 3),
                new Point(2, 1),
                new Point(2, 2),
                new Point(2, 3),
                new Point(3, 0),
                new Point(3, 1),
        };

        // Set all target points to have state 3
        for (Point point : targetPoints) {
            grid.getSiteAtPoint(point).setState(3);
        }

        return grid;
    }

}
