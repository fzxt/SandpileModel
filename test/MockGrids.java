import java.awt.Point;

public class MockGrids {

    /**
     * [0, 0, 0]
     * [0, 3, 0]
     * [0, 0, 0]
     */
    static Grid getTestGrid1() {
        // 3x3 Grid, all values are 0 by default
        Grid grid = new Grid(3);
        Point midPoint = new Point(1, 1);

        // Set the middle site to 3
        Site middleSite = grid.getSiteAtPoint(midPoint);
        middleSite.setState(3);

        return grid;
    }


    /**
     * This grid was obtained from How Nature Works (Written by Per Bak), Page 53
     * So it's significant that any test that uses this grid passes.
     *
     * [1, 2, 0, 2, 3]
     * [2, 3, 2, 3, 0]
     * [1, 2, 3, 3, 2]
     * [3, 1, 3, 2, 1]
     * [0, 2, 2, 1, 2]
     */
    static Grid getTestGrid2() {
        // 5x5 Grid
        Grid grid = new Grid(5);

        int[][] values = {
                {1, 2, 0, 2, 3},
                {2, 3, 2, 3, 0},
                {1, 2, 3, 3, 2},
                {3, 1, 3, 2, 1},
                {0, 2, 2, 1, 2}
        };

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                grid.getSiteAtPoint(new Point(i, j)).setState(values[i][j]);
            }
        }


        return grid;
    }

    static Grid getTestGrid3() {
        Grid grid = new Grid(3);

        int[][] values = {
                {1, 3, 3},
                {3, 2, 1},
                {2, 3, 2}
        };

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                grid.getSiteAtPoint(new Point(i, j)).setState(values[i][j]);
            }
        }

        return grid;
    }


}
