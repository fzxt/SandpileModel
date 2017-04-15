package com.fahad.SandPileModel;

import java.util.Map;
import java.util.TreeMap;

public class Grid {

    private Site[][] sites;
    private int n;
    private int numAvalanches;
    private Map<Integer, Integer> sizeCountMap;

    public Grid(int n) {
        assert n > 0;
        this.n = n;
        numAvalanches = 0;
        sizeCountMap = new TreeMap<>();
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

    private void incrementAvalancheCount() {
        numAvalanches++;
        for (int i = 0; i <= getNumAvalanches(); i++) {
            if (sizeCountMap.containsKey(i)) {
                sizeCountMap.put(i, sizeCountMap.get(i) + 1);
            } else {
                sizeCountMap.put(i, 1);
            }
        }
    }

    /**
     * This will topple according to the model presented in Abelian Sandpile Model
     * @param site      The site one is trying to topple
     */
    public void topple(Site site) {
        incrementAvalancheCount();

        site.setState(site.currentState - 4);

        for (Point neighbouringPoint : Utility.getValidNeighbourPoints(site, n-1)) {
            getSiteAtPoint(neighbouringPoint).increment();
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

    public Map<Integer, Integer> getSizeCountMap() {
        return sizeCountMap;
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
