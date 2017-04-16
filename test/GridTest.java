import com.fahad.SandPileModel.Grid;
import com.fahad.SandPileModel.Point;
import com.fahad.SandPileModel.Site;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    Grid testGrid1 = MockGrids.getTestGrid1();
    Grid testGrid2 = MockGrids.getTestGrid2();

    @Test
    public void shouldToppleCorrectly() {
        setUpTestGrid1();

        int[][] expected = {
                {0, 1, 0},
                {1, 0 ,1},
                {0, 1, 0}
        };

        Site[][] resultingSites = testGrid1.getSites();
        assertSiteStates(expected, resultingSites);
    }

    @Test
    public void shouldToppleAtThresholdCorrectly() {
        setUpTestGrid2();

        int[][] expected = {
                {1, 3, 1, 3, 3},
                {3, 1, 2, 1, 1},
                {2, 1, 0, 3, 3},
                {3, 3, 2, 0, 2},
                {0, 2, 3, 2, 2}
        };

        Site[][] resultingSites = testGrid2.getSites();
        assertSiteStates(expected, resultingSites);
    }

    @Test
    public void shouldReturnCorrectNumberOfAvalanches() {
        setUpTestGrid1();
        setUpTestGrid2();
        assertEquals(1, testGrid1.getNumAvalanches());
        assertEquals(9, testGrid2.getNumAvalanches());
    }

    private void setUpTestGrid1() {
        Site middleSite = testGrid1.getSiteAtPoint(new Point(1, 1));
        // Set the middle site past the threshold (3)
        middleSite.increment();
        testGrid1.topple(middleSite);
    }

    private void setUpTestGrid2() {
        Site startingSite = testGrid2.getSiteAtPoint(new Point(2, 2));
        startingSite.increment();
        testGrid2.toppleAtThreshold(startingSite, 3);
    }

    private void assertSiteStates(int[][] expectedStates, Site[][] sites) {
        for (int i = 0; i < expectedStates.length; i++) {
            for (int j = 0; j < expectedStates[i].length; j++) {
                assertEquals(expectedStates[i][j], sites[i][j].getCurrentState());
            }
        }
    }
}
