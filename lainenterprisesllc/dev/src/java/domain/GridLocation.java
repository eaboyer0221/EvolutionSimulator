package java.domain;

import java.util.Optional;

public class GridLocation {
    public Optional<PhysicalItem> item;

    public GridLocation() {
        this.item = Optional.empty();
        this.pheromoneLevel = 0;
    }
    public void decayPheromones() {
        pheromoneLevel /= 2;
    }
    public int pheromoneLevel;
}
