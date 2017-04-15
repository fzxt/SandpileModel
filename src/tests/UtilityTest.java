package tests;

import com.fahad.SandPileModel.Point;
import com.fahad.SandPileModel.Site;
import com.fahad.SandPileModel.Utility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilityTest {

    @Test
    public void shouldReturnValidNeighbourPoints() {
        // For this test, imagine we have a 10x10 grid.
        // We will test by simply checking the corner bounds of the array
        Site topLeftSite = new Site(new Point(0, 0), 0);
        Site topRightSite = new Site(new Point(0, 9), 0);
        Site bottomLeftSite = new Site(new Point(9, 0), 0);
        Site bottomRightSite = new Site(new Point(9, 9), 0);

        ArrayList<Point> topLeftSiteNeighbours = Utility.getValidNeighbourPoints(topLeftSite, 10-1);
        ArrayList<Point> topRightSiteNeighbours = Utility.getValidNeighbourPoints(topRightSite, 10-1);
        ArrayList<Point> bottomLeftSiteNeighbours = Utility.getValidNeighbourPoints(bottomLeftSite, 10-1);
        ArrayList<Point> bottomRightSiteNeigbours = Utility.getValidNeighbourPoints(bottomRightSite, 10-1);

        assertEquals(topLeftSiteNeighbours.size(), 2);
        assertEquals(topLeftSiteNeighbours.contains(new Point(1, 0)), true);
        assertEquals(topLeftSiteNeighbours.contains(new Point(0, 1)), true);

        assertEquals(topRightSiteNeighbours.size(), 2);
        assertEquals(topRightSiteNeighbours.contains(new Point(0, 8)), true);
        assertEquals(topRightSiteNeighbours.contains(new Point(1, 9)), true);

        assertEquals(bottomLeftSiteNeighbours.size(), 2);
        assertEquals(bottomLeftSiteNeighbours.contains(new Point(8, 0)), true);
        assertEquals(bottomLeftSiteNeighbours.contains(new Point(9, 1)), true);

        assertEquals(bottomRightSiteNeigbours.size(), 2);
        assertEquals(bottomRightSiteNeigbours.contains(new Point(8, 9)), true);
        assertEquals(bottomRightSiteNeigbours.contains(new Point(9, 8)), true);
    }

}
