package com.fahad.SandPileModel;

public class Grid {
    private Site[][] sites;
    private int n;

    public Grid(int n) {
        assert n > 0;
        this.n = n;
        sites = new Site[n][n];
        initializeWithEmptySites();
    }

    public Site[][] getSites() {
        return sites;
    }

    public void printSites() {
        for (int i = 0; i < sites.length; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                System.out.print(sites[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    public void toppleAtThreshold(Site s, int threshold) {
        if (s.getCurrentState() >= threshold) {
            topple(s);

            for (Point neighbouringPoint : Utility.getValidNeighbourPoints(s, n-1)) {
                // If the neighboring point is actually on the grid, we recursively check if it toppled
                toppleAtThreshold(getSiteAtPoint(neighbouringPoint), threshold);
            }
        }
    }

    /**
     * This will topple according to the model presented in Abelian Sandpile Model
     * @param site      The site one is trying to topple
     */
    public void topple(Site site) {
        site.setState(site.currentState - 4);

        for (Point neighbouringPoint : Utility.getValidNeighbourPoints(site, n-1)) {
            getSiteAtPoint(neighbouringPoint).increment();
        }
    }

    public Site getSiteAtPoint(Point point) {
        return sites[point.x][point.y];
    }

    private void initializeWithEmptySites() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                sites[i][j] = new Site(new Point(i, j), 0);
            }
        }
    }
}
