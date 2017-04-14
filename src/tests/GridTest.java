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
        Grid grid = new Grid(3);
        Point midPoint = new Point(1, 1);

        // Set the middle site to 4
        Site middleSite = grid.getSiteAtPoint(midPoint);
        middleSite.setState(4);

        assertEquals(4, middleSite.getCurrentState());

        // Topple with the middle site
        grid.topple(middleSite);

        Site[][] result = grid.getSites();

        assertEquals(0, result[0][0].getCurrentState());
        assertEquals(1, result[0][1].getCurrentState());
        assertEquals(0, result[0][2].getCurrentState());

        assertEquals(1, result[1][0].getCurrentState());
        assertEquals(0, result[1][1].getCurrentState());
        assertEquals(1, result[1][2].getCurrentState());

        assertEquals(0, result[2][0].getCurrentState());
        assertEquals(1, result[2][1].getCurrentState());
        assertEquals(0, result[2][2].getCurrentState());
    }
}
