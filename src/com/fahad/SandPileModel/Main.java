package com.fahad.SandPileModel;

import java.util.Map;
import java.util.Random;

/**
 * @author Fahad Ahmad
 */

/**
 * This program simulates the Abelian Sandpile Model, by Bak et al
 *
 * The program was designed and implemented for the purposes of running experiments
 * to understand the power laws in the underlying model.
 */

public class Main {


    static final int N = 200;
    static final int T = 80000;
    static final int THRESHOLD = 3;

    public static void main(String[] args) {
        Random random = new Random(1234);
        Grid grid = new Grid(N);

        for (int t = 0; t < T; t++) {
            // Randomly select a site between 0 and N;
            int randomX = random.nextInt(N);
            int randomY = random.nextInt(N);
            Point randomPoint = new Point(randomX, randomY);
            // Increment (or add a sand grain)
            Site s = grid.getSiteAtPoint(randomPoint);
            s.increment();
            grid.toppleAtThreshold(s, THRESHOLD);
            grid.resetAvalancheCount();
        }

        for (Map.Entry<Integer, Integer> entry : grid.getSizeCountMap().entrySet()) {
            System.out.printf("%f %f\n", Math.log(entry.getKey()), Math.log(entry.getValue()));
        }
    }

}
