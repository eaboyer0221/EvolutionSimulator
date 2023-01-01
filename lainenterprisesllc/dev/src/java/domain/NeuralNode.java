package src.java.domain;

import java.util.List;

import static src.java.domain.NodeType.END;
import static src.java.domain.NodeType.START;

public enum NeuralNode {

    PHEROMONE_GRADIENT_LEFT_RIGHT(Neuron.PHEROMONE_GRADIENT_LEFT_RIGHT,List.of(START)),
    PHEROMONE_GRADIENT_FORWARD(Neuron.PHEROMONE_GRADIENT_FORWARD,List.of(START)),
    PHEROMONE_DENSITY(Neuron.PHEROMONE_DENSITY,List.of(START)),
    AGE(Neuron.AGE,List.of(START)),
    RANDOM_INPUT(Neuron.RANDOM_INPUT,List.of(START)),
    BLOCKAGE_LEFT_RIGHT(Neuron.BLOCKAGE_LEFT_RIGHT,List.of(START)),
    OSCILLATOR(Neuron.OSCILLATOR,List.of(START)),
    BLOCKAGE_FORWARD(Neuron.BLOCKAGE_FORWARD,List.of(START)),
    POPULATION_GRADIENT_LEFT_RIGHT(Neuron.POPULATION_GRADIENT_LEFT_RIGHT,List.of(START)),
    POPULATION_DENSITY(Neuron.POPULATION_DENSITY,List.of(START)),
    POPULATION_GRADIENT_FORWARD(Neuron.POPULATION_GRADIENT_FORWARD,List.of(START)),
    POPULATION_LONG_RANGE_FORWARD(Neuron.POPULATION_LONG_RANGE_FORWARD,List.of(START)),
    LAST_MOVEMENT_Y(Neuron.LAST_MOVEMENT_Y,List.of(START)),
    BLOCKAGE_LONG_RANGE_FORWARD(Neuron.BLOCKAGE_LONG_RANGE_FORWARD,List.of(START)),
    LAST_MOVEMENT_X(Neuron.LAST_MOVEMENT_X,List.of(START)),
    NORTH_SOUTH_BORDER_DISTANCE(Neuron.NORTH_SOUTH_BORDER_DISTANCE,List.of(START)),
    GENETIC_SIMILARITY_OF_FWD_NEIGHBOR(Neuron.GENETIC_SIMILARITY_OF_FWD_NEIGHBOR,List.of(START)),
    EAST_WEST_BORDER_DISTANCE(Neuron.EAST_WEST_BORDER_DISTANCE,List.of(START)),
    EAST_WEST_WORLD_LOCATION(Neuron.EAST_WEST_WORLD_LOCATION,List.of(START)),
    NEAREST_BORDER_DISTANCE(Neuron.NEAREST_BORDER_DISTANCE,List.of(START)),
    NORTH_SOUTH_WORLD_LOCATION(Neuron.NORTH_SOUTH_WORLD_LOCATION,List.of(START)),

    SET_LONG_PROBE_DISTANCE(Neuron.SET_LONG_PROBE_DISTANCE,List.of(END)),
    KILL_FORWARD_NEIGHBOR(Neuron.KILL_FORWARD_NEIGHBOR,List.of(END)),
    SET_OSCILLATOR_PERIOD(Neuron.SET_OSCILLATOR_PERIOD,List.of(END)),
    EMIT_PHEROMONE(Neuron.EMIT_PHEROMONE,List.of(END)),
    SET_RESPONSIVENESS(Neuron.SET_RESPONSIVENESS,List.of(END)),
    MOVE_FORWARD(Neuron.MOVE_FORWARD,List.of(END)),
    MOVE_RANDOM(Neuron.MOVE_RANDOM,List.of(END)),
    MOVE_REVERSE(Neuron.MOVE_REVERSE,List.of(END)),
    MOVE_LEFT_RIGHT(Neuron.MOVE_LEFT_RIGHT,List.of(END)),
    MOVE_EAST_WEST(Neuron.MOVE_EAST_WEST,List.of(END)),
    MOVE_NORTH_SOUTH(Neuron.MOVE_NORTH_SOUTH,List.of(END)),

    N1(Neuron.N1,List.of(END, START)),
    N2(Neuron.N2,List.of(END, START)),
    N0(Neuron.N0,List.of(END, START)),
    ;

    public final Neuron neuron;
    public final List<NodeType> nodeTypes;

    NeuralNode(Neuron neuron, List<NodeType> nodeTypes) {
        this.neuron = neuron;
        this.nodeTypes = nodeTypes;
    }

}
