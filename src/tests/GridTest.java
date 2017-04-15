package tests;

import com.fahad.SandPileModel.Grid;
import com.fahad.SandPileModel.Point;
import com.fahad.SandPileModel.Site;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    public void shouldToppleCorrectly() {
        // Create a 3x3 Grid
        Grid testGrid1 = MockGrids.getTestGrid1();
        Site middleSite = testGrid1.getSiteAtPoint(new Point(1, 1));
        // Topple with the middle site
        testGrid1.topple(middleSite);
        Site[][] g1Results = testGrid1.getSites();

        assertEquals(0, g1Results[0][0].getCurrentState());
        assertEquals(1, g1Results[0][1].getCurrentState());
        assertEquals(0, g1Results[0][2].getCurrentState());

        assertEquals(1, g1Results[1][0].getCurrentState());
        assertEquals(0, g1Results[1][1].getCurrentState());
        assertEquals(1, g1Results[1][2].getCurrentState());

        assertEquals(0, g1Results[2][0].getCurrentState());
        assertEquals(1, g1Results[2][1].getCurrentState());
        assertEquals(0, g1Results[2][2].getCurrentState());
    }

    @Test
    public void shouldToppleAtThresholdCorrectly() {
        Grid testGrid2 = MockGrids.getTestGrid2();
        Site bottomSite = testGrid2.getSiteAtPoint(new Point(3, 1));
        bottomSite.increment();
        // This should recursively topple multiple times
        testGrid2.toppleAtThreshold(bottomSite, 4);
        Site[][] g2Results = testGrid2.getSites();

        assertEquals(2, g2Results[0][0].getCurrentState());
        assertEquals(2, g2Results[0][1].getCurrentState());
        assertEquals(1, g2Results[0][2].getCurrentState());
        assertEquals(2, g2Results[0][3].getCurrentState());

        assertEquals(2, g2Results[1][0].getCurrentState());
        assertEquals(2, g2Results[1][1].getCurrentState());
        assertEquals(0, g2Results[1][2].getCurrentState());
        assertEquals(1, g2Results[1][3].getCurrentState());

        assertEquals(3, g2Results[2][0].getCurrentState());
        assertEquals(2, g2Results[2][1].getCurrentState());
        assertEquals(2, g2Results[2][2].getCurrentState());
        assertEquals(1, g2Results[2][3].getCurrentState());

        assertEquals(0, g2Results[3][0].getCurrentState());
        assertEquals(3, g2Results[3][1].getCurrentState());
        assertEquals(3, g2Results[3][2].getCurrentState());
        assertEquals(2, g2Results[3][3].getCurrentState());
    }
}
