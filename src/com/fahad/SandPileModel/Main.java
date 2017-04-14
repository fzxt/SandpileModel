package com.fahad.SandPileModel;

import java.util.Random;

public class Main {

    static final int N = 500;
    static final int T = 10000;
    static final int THRESHOLD = 4;

    public static void main(String[] args) {
        Random random = new Random(1234);
        Grid grid = new Grid(N);
        grid.initializeSitesWithRandomState();

        for (int i = 0; i < T; i++) {
            // Randomly select a site between 0 and N;
            int randomX = random.nextInt(N);
            int randomY = random.nextInt(N);
            Point randomPoint = new Point(randomX, randomY);
            // Increment (or add a sand grain)
            Site s = grid.getSiteAtPoint(randomPoint);
            s.increment();
            grid.toppleAtThreshold(s, THRESHOLD);
        }

        grid.printSites();
    }
}
