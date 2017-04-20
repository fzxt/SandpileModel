# Spec for implementation of the Abelian Sandpile model in Java

## Problem:
- Implement the [Abelian Sandpile Model](https://www.wikiwand.com/en/Abelian_sandpile_model)
- Confirm the following power-laws:
  -  the number of clusters D(s) of size s scaled with some exponent τ : D(s) ∼ s^(−τ)
  
## Class design and important methods

### Grid
- Represents the square lattice which sand will be dropped on
- Contains nxn "Site" cells
- Keeps track of the number of avalanches

#### Methods
- `void toppleAtThreshold(Site s, int t)` - Method to check sites current state, if it exceeds the threshold, then topple and recursively check it's neighbors. It's here where we keep track of the temporary count of avalanches

- `void topple()` - Method to distribute give the sites grains to it's neighbors equally. 

- `void resetAvalancheCount()` - Method to reset the current count for avalanche. Should be called at every timestep.

### Site
- Represents a single site on the grid
- Has a point on the grid (x, y)
- Keeps track of state, via an integer

#### Methods
- `int getState(), int setState(int state)`
- `void increment()` - Increments the current state

## How the experiments work
- The main method contains a Map (TreeMap) for keeping track of Avalanche sizes vs Frequencies

- For experiments specifically, the main method runs for some T number of iterations. At each iteration, we randomly select a site to increment. If it's greater than the threshold => we call `toppleAtThreshold(randomSite, 3)`.

- Once toppleAtThreshold is done, we update the map for the correct number of times the avalanche of a specific size has occurred.

## Tests
- Unit tests have been written to verify the correctness of the implementation with 3 guaranteed results obtained from the model (2 are from research papers, 1 is simply made up)
- You may find the tests in the projects root directory in the `tests` folder:
  - `MockGrids.java` for predefined Grids with known results
  - `GridTest.java` for methods related to the Grid. Tests for toppling and verifies that avalanche is counted correctly.
