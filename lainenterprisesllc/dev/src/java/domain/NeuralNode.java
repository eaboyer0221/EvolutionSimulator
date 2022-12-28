package src.java.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum NeuralNode {

    PHEROMONE_GRADIENT_LEFT_RIGHT(Neuron.PHEROMONE_GRADIENT_LEFT_RIGHT,List.of(NodeType.START)),
    PHEROMONE_GRADIENT_FORWARD(Neuron.PHEROMONE_GRADIENT_FORWARD,List.of(NodeType.START)),
    PHEROMONE_DENSITY(Neuron.PHEROMONE_DENSITY,List.of(NodeType.START)),
    AGE(Neuron.AGE,List.of(NodeType.START)),
    RANDOM_INPUT(Neuron.RANDOM_INPUT,List.of(NodeType.START)),
    BLOCKAGE_LEFT_RIGHT(Neuron.BLOCKAGE_LEFT_RIGHT,List.of(NodeType.START)),
    OSCILLATOR(Neuron.OSCILLATOR,List.of(NodeType.START)),
    BLOCKAGE_FORWARD(Neuron.BLOCKAGE_FORWARD,List.of(NodeType.START)),
    POPULATION_GRADIENT_LEFT_RIGHT(Neuron.POPULATION_GRADIENT_LEFT_RIGHT,List.of(NodeType.START)),
    POPULATION_DENSITY(Neuron.POPULATION_DENSITY,List.of(NodeType.START)),
    POPULATION_GRADIENT_FORWARD(Neuron.POPULATION_GRADIENT_FORWARD,List.of(NodeType.START)),
    POPULATION_LONG_RANGE_FORWARD(Neuron.POPULATION_LONG_RANGE_FORWARD,List.of(NodeType.START)),
    LAST_MOVEMENT_Y(Neuron.LAST_MOVEMENT_Y,List.of(NodeType.START)),
    BLOCKAGE_LONG_RANGE_FORWARD(Neuron.BLOCKAGE_LONG_RANGE_FORWARD,List.of(NodeType.START)),
    LAST_MOVEMENT_X(Neuron.LAST_MOVEMENT_X,List.of(NodeType.START)),
    NORTH_SOUTH_BORDER_DISTANCE(Neuron.NORTH_SOUTH_BORDER_DISTANCE,List.of(NodeType.START)),
    GENETIC_SIMILARITY_OF_FWD_NEIGHBOR(Neuron.GENETIC_SIMILARITY_OF_FWD_NEIGHBOR,List.of(NodeType.START)),
    EAST_WEST_BORDER_DISTANCE(Neuron.EAST_WEST_BORDER_DISTANCE,List.of(NodeType.START)),
    EAST_WEST_WORLD_LOCATION(Neuron.EAST_WEST_WORLD_LOCATION,List.of(NodeType.START)),
    NEAREST_BORDER_DISTANCE(Neuron.NEAREST_BORDER_DISTANCE,List.of(NodeType.START)),
    NORTH_SOUTH_WORLD_LOCATION(Neuron.NORTH_SOUTH_WORLD_LOCATION,List.of(NodeType.START)),
    SET_LONG_PROBE_DISTANCE(Neuron.SET_LONG_PROBE_DISTANCE,List.of(NodeType.END)),
    KILL_FORWARD_NEIGHBOR(Neuron.KILL_FORWARD_NEIGHBOR,List.of(NodeType.END)),
    SET_OSCILLATOR_PERIOD(Neuron.SET_OSCILLATOR_PERIOD,List.of(NodeType.END)),
    EMIT_PHEROMONE(Neuron.EMIT_PHEROMONE,List.of(NodeType.END)),
    SET_RESPONSIVENESS(Neuron.SET_RESPONSIVENESS,List.of(NodeType.END)),
    MOVE_FORWARD(Neuron.MOVE_FORWARD,List.of(NodeType.END)),
    MOVE_RANDOM(Neuron.MOVE_RANDOM,List.of(NodeType.END)),
    MOVE_REVERSE(Neuron.MOVE_REVERSE,List.of(NodeType.END)),
    MOVE_LEFT_RIGHT(Neuron.MOVE_LEFT_RIGHT,List.of(NodeType.END)),
    MOVE_EAST_WEST(Neuron.MOVE_EAST_WEST,List.of(NodeType.END)),
    MOVE_NORTH_SOUTH(Neuron.MOVE_NORTH_SOUTH,List.of(NodeType.END)),
    N1(Neuron.N1,List.of(NodeType.END, NodeType.START)),
    N2(Neuron.N2,List.of(NodeType.END, NodeType.START)),
    N0(Neuron.N0,List.of(NodeType.END, NodeType.START)),
    ;

    public final Neuron neuron;
    public final List<NodeType> nodeTypes;

    NeuralNode(Neuron neuron, List<NodeType> nodeTypes) {
        this.neuron = neuron;
        this.nodeTypes = nodeTypes;
    }

}
