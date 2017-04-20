package com.fahad.SandPileModel;

import java.awt.Point;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * This program simulates the Abelian Sandpile Model, by Bak et al
 *
 * The program was designed and implemented for the purposes of running experiments
 * to understand the power laws in the underlying model.
 */

public class Main {

    private static final int N = 50;
    private static final int T = 2000;
    private static final int THRESHOLD = 3;


    public static void main(String[] args) {
        Random random = new Random(12930);
        Grid grid = new Grid(N);
        Map<Integer, Integer> sizeCountMap = new TreeMap<>();

        System.out.printf("Running simulations with N: %d and T: %d\n\n", N, T);

        for (int t = 0; t < T; t++) {
            // Randomly select a site between 0 and N;
            int randomX = random.nextInt(N);
            int randomY = random.nextInt(N);
            Point randomPoint = new Point(randomX, randomY);
            // Increment (or add a sand grain)
            Site s = grid.getSiteAtPoint(randomPoint);
            s.increment();
            grid.toppleAtThreshold(s, THRESHOLD);

            int numAvalanches = grid.getNumAvalanches();

            if (sizeCountMap.containsKey(numAvalanches)) {
                // If the number of avalanches already exists in our map, increment the count
                sizeCountMap.put(numAvalanches, sizeCountMap.get(numAvalanches) + 1);
            } else {
                // Else, initialize the count to 1
                sizeCountMap.put(numAvalanches, 1);
            }

            // Reset the avalanche count for the next time step
            grid.resetAvalancheCount();
        }

        for (Map.Entry<Integer, Integer> entry : sizeCountMap.entrySet()) {
            System.out.printf("%f %f\n", Math.log10(entry.getKey()), Math.log10(entry.getValue()));
        }

        System.out.println("\nDone");
    }

}
