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


        int[][] expected = {
                {0, 1, 0},
                {1, 0 ,1},
                {0, 1, 0}
        };

        Site[][] resultingSites = testGrid1.getSites();
        assertEquals(1, testGrid1.getNumAvalanches());
        assertSiteStates(expected, resultingSites);
    }

    @Test
    public void shouldToppleAtThresholdCorrectly() {
        Grid testGrid2 = MockGrids.getTestGrid2();
        Site startingSite = testGrid2.getSiteAtPoint(new Point(2, 2));
        startingSite.increment();
        testGrid2.toppleAtThreshold(startingSite, 4);

        int[][] expected = {
                {1, 3, 1, 3, 3},
                {3, 1, 2, 1, 1},
                {2, 1, 0, 3, 3},
                {3, 3, 2, 0, 2},
                {0, 2, 3, 2, 2}
        };

        Site[][] resultingSites = testGrid2.getSites();
        assertEquals(9, testGrid2.getNumAvalanches());
        assertSiteStates(expected, resultingSites);
    }

    private void assertSiteStates(int[][] expectedStates, Site[][] sites) {
        for (int i = 0; i < expectedStates.length; i++) {
            for (int j = 0; j < expectedStates[i].length; j++) {
                assertEquals(expectedStates[i][j], sites[i][j].getCurrentState());
            }
        }
    }

}
