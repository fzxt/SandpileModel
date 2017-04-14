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

    /**
     * Will initialize with random state (either 0 or 1)
     */
    public void initializeSitesWithRandomState() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sites[i].length; j++) {
                int initialState = Math.random() > 0.5 ? 1 : 0;
                sites[i][j] = new Site(new Point(i, j), initialState);
            }
        }
    }


    public void toppleAtThreshold(Site s, int threshold) {
        if (s.getCurrentState() >= threshold) {
            topple(s);
            toppleAtThreshold(getSiteAtPoint(new Point((s.position.x-1+n)%n, s.position.y)), threshold);
            toppleAtThreshold(getSiteAtPoint(new Point((s.position.x+1)%n, s.position.y)), threshold);
            toppleAtThreshold(getSiteAtPoint(new Point(s.position.x, (s.position.y-1+n)%n)), threshold);
            toppleAtThreshold(getSiteAtPoint(new Point(s.position.x, (s.position.y+1)%n)), threshold);
        }
    }

    /**
     * This will topple according to the model presented in Abelian Sandpile Model
     * @param site
     */
    public void topple(Site site) {
        sites[site.position.x][site.position.y].setState(site.currentState - 4);
        sites[(site.position.x+1)%n][site.position.y].increment();
        sites[(site.position.x-1+n)%n][site.position.y].increment();
        sites[site.position.x][(site.position.y-1+n)%n].increment();
        sites[site.position.x][(site.position.y+1)%n].increment();
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
