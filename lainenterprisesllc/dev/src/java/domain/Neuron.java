package src.java.domain;


public enum Neuron {

        PHEROMONE_GRADIENT_LEFT_RIGHT(0.0,1.0),
        PHEROMONE_GRADIENT_FORWARD(0.0,1.0),
        PHEROMONE_DENSITY(0.0,1.0),
        AGE(0.0,1.0),
        RANDOM_INPUT(0.0,1.0),
        BLOCKAGE_LEFT_RIGHT(0.0,1.0),
        OSCILLATOR(0.0,1.0),
        BLOCKAGE_FORWARD(0.0,1.0),
        POPULATION_GRADIENT_LEFT_RIGHT(0.0,1.0),
        POPULATION_DENSITY(0.0,1.0),
        POPULATION_GRADIENT_FORWARD(0.0,1.0),
        POPULATION_LONG_RANGE_FORWARD(0.0,1.0),
        LAST_MOVEMENT_Y(0.0,1.0),
        BLOCKAGE_LONG_RANGE_FORWARD(0.0,1.0),
        LAST_MOVEMENT_X(0.0,1.0),
        NORTH_SOUTH_BORDER_DISTANCE(0.0,1.0),
        GENETIC_SIMILARITY_OF_FWD_NEIGHBOR(0.0,1.0),
        EAST_WEST_BORDER_DISTANCE(0.0,1.0),
        EAST_WEST_WORLD_LOCATION(0.0,1.0),
        NEAREST_BORDER_DISTANCE(0.0,1.0),
        NORTH_SOUTH_WORLD_LOCATION(0.0,1.0),
        SET_LONG_PROBE_DISTANCE(0.0,1.0),
        KILL_FORWARD_NEIGHBOR(0.0,1.0),
        SET_OSCILLATOR_PERIOD(0.0,1.0),
        EMIT_PHEROMONE(0.0,1.0),
        SET_RESPONSIVENESS(0.0,1.0),
        MOVE_FORWARD(0.0,1.0),
        MOVE_RANDOM(0.0,1.0),
        MOVE_REVERSE(0.0,1.0),
        MOVE_LEFT_RIGHT(0.0,1.0),
        MOVE_EAST_WEST(0.0,1.0),
        MOVE_NORTH_SOUTH(0.0,1.0),
        N0(-1.0, 1.0),
        N1(-1.0, 1.0),
        N2(-1.0, 1.0);

        public final double min;
        public final double max;

        Neuron(double min, double max) {
                this.min = min;
                this.max = max;
        }
}

