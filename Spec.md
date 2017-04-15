# Spec for implementation of the Abelian Sandpile model in Java

## Problem:
- Implement the [Abelian Sandpile Model](https://www.wikiwand.com/en/Abelian_sandpile_model)
- Confirm the following power-laws:
  -  the number of clusters D(s) of size s scaled with some exponent τ : D(s) ∼ s^(−τ)
  
## Class design

### Grid
- Represents the square lattice which sand will be dropped on
- Contains nxn "Site" cells

#### Methods
- `void toppleAtThreshold(Site s, int t)` - Method to check sites current state, if it exceeds the threshold, then topple and recursively check it's neighbors.

- `void topple()` - Method to distribute give the sites grains to it's neighbors equally. 

### Site
- Represents a single site on the grid
- Has a point on the grid (x, y)
- Keeps track of state, via an integer

#### Methods
- `int getState(), int setState(int state)`
- `void increment()` - Increments the current state
