package com.fahad.SandPileModel;

import java.awt.Point;

public class Grid {
    private Site[][] sites;
    private int numAvalanches;
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

    /**
     * Used primarily for debugging purposes
     */
    public void printSites() {
        for (int i = 0; i < sites.length; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                     System.out.print(sites[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    public int getNumAvalanches() {
        return numAvalanches;
    }

    /**
     * Method used to reset the total avalanche count. Used at every time step.
     */
    void resetAvalancheCount() {
        this.numAvalanches = 0;
    }

    /**
     * Recursive algorithm to topple when past a certain threshold
     * If the threshold is passed, then we topple the site then recursively check its neighbours for any further topples.
     * @param s             Site to topple
     * @param threshold     Threshold to pass for topple
     */
    public void toppleAtThreshold(Site s, int threshold) {
        if (s.getCurrentState() > threshold) {
            topple(s);
            for (Point neighbouringPoint : Utility.getValidNeighbourPoints(s, n-1)) {
                // If the neighboring point is actually on the grid, we recursively check if it toppled
                toppleAtThreshold(getSiteAtPoint(neighbouringPoint), threshold);
            }
        }
    }

    public Site getSiteAtPoint(Point point) {
        return sites[point.x][point.y];
    }


    /**
     * This will topple according to the model presented in Abelian Sandpile Model
     * @param site      The site one is trying to topple
     */
    private void topple(Site site) {
        incrementAvalancheCount();

        site.setState(site.currentState - 4);

        for (Point neighbouringPoint : Utility.getValidNeighbourPoints(site, n-1)) {
            getSiteAtPoint(neighbouringPoint).increment();
        }
    }

    /**
     * Method to increment the total avalanche count
     */
    private void incrementAvalancheCount() {
        numAvalanches++;
    }


    private void initializeWithEmptySites() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                sites[i][j] = new Site(new Point(i, j), 0);
            }
        }
    }
}
