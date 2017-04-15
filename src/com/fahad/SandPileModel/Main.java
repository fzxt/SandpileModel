package com.fahad.SandPileModel;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

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
    static final int T = 100000;
    static final int THRESHOLD = 4;

    public static void main(String[] args) {
        Random random = new Random(1234);
        Grid grid = new Grid(N);

        // Using a TreeMap keeps the keys in sorted order,
        // Key: size of avalanche, Value: number of times this avalanche size has occurred.
        Map<Integer, Integer> sizeDistributionMap = new TreeMap<>();

        for (int t = 0; t < T; t++) {
            // Randomly select a site between 0 and N;
            int randomX = random.nextInt(N);
            int randomY = random.nextInt(N);
            Point randomPoint = new Point(randomX, randomY);
            // Increment (or add a sand grain)
            Site s = grid.getSiteAtPoint(randomPoint);
            s.increment();
            grid.toppleAtThreshold(s, THRESHOLD);

            // If the map already contains a key for the avalanche, increment the count
            // else set the count to 1
            if (sizeDistributionMap.containsKey(grid.getNumAvalanches())) {
                sizeDistributionMap.put(grid.getNumAvalanches(), sizeDistributionMap.get(grid.getNumAvalanches()) + 1);
            } else {
                sizeDistributionMap.put(grid.getNumAvalanches(), 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sizeDistributionMap.entrySet()) {
            System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        }
    }

}
