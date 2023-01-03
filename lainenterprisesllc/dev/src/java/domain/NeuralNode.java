package java.domain;

import java.util.List;

import static java.domain.NodeType.START;
import static java.domain.NodeType.END;

public enum NeuralNode {
	// Sensory Inputs
    PHEROMONE_0(Neuron.PHEROMONE_0,List.of(START)),
    POPULATION_0(Neuron.POPULATION_0,List.of(START)),
    BORDER_DISTANCE_0(Neuron.BORDER_DISTANCE_0,List.of(START)),
	PHEROMONE_45(Neuron.PHEROMONE_45,List.of(START)),
    POPULATION_45(Neuron.POPULATION_45,List.of(START)),
    BORDER_DISTANCE_45(Neuron.BORDER_DISTANCE_45,List.of(START)),
	PHEROMONE_90(Neuron.PHEROMONE_90,List.of(START)),
    POPULATION_90(Neuron.POPULATION_90,List.of(START)),
    BORDER_DISTANCE_90(Neuron.BORDER_DISTANCE_90,List.of(START)),
	PHEROMONE_135(Neuron.PHEROMONE_135,List.of(START)),
    POPULATION_135(Neuron.POPULATION_135,List.of(START)),
    BORDER_DISTANCE_135(Neuron.BORDER_DISTANCE_135,List.of(START)),
	PHEROMONE_180(Neuron.PHEROMONE_180,List.of(START)),
    POPULATION_180(Neuron.POPULATION_180,List.of(START)),
    BORDER_DISTANCE_180(Neuron.BORDER_DISTANCE_180,List.of(START)),
	PHEROMONE_225(Neuron.PHEROMONE_225,List.of(START)),
    POPULATION_225(Neuron.POPULATION_225,List.of(START)),
    BORDER_DISTANCE_225(Neuron.BORDER_DISTANCE_225,List.of(START)),
	PHEROMONE_270(Neuron.PHEROMONE_270,List.of(START)),
    POPULATION_270(Neuron.POPULATION_270,List.of(START)),
    BORDER_DISTANCE_270(Neuron.BORDER_DISTANCE_270,List.of(START)),
	PHEROMONE_315(Neuron.PHEROMONE_315,List.of(START)),
    POPULATION_315(Neuron.POPULATION_315,List.of(START)),
    BORDER_DISTANCE_315(Neuron.BORDER_DISTANCE_315,List.of(START)),
    AGE(Neuron.AGE,List.of(START)),
	
	
	// Internal Neurons
    N1(Neuron.N1,List.of(END, START)),
    N2(Neuron.N2,List.of(END, START)),
    N0(Neuron.N0,List.of(END, START)),
	
	
	// Action Outputs
	MOVE_0(Neuron.MOVE_0, List.of(END)),
	MOVE_45(Neuron.MOVE_0, List.of(END)),
	MOVE_90(Neuron.MOVE_0, List.of(END)),
	MOVE_135(Neuron.MOVE_0, List.of(END)),
	MOVE_180(Neuron.MOVE_0, List.of(END)),
	MOVE_225(Neuron.MOVE_0, List.of(END)),
	MOVE_270(Neuron.MOVE_270, List.of(END)),
	MOVE_315(Neuron.MOVE_315, List.of(END)),
    EMIT_PHEROMONE(Neuron.EMIT_PHEROMONE,List.of(END)),
    ;

    public final Neuron neuron;
    public final List<NodeType> nodeTypes;

    NeuralNode(Neuron neuron, List<NodeType> nodeTypes) {
        this.neuron = neuron;
        this.nodeTypes = nodeTypes;
    }

}
