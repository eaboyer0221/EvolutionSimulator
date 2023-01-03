package java.domain;

public enum Neuron {
	BORDER_DISTANCE_0(0, 1),
	BORDER_DISTANCE_45(0, 1),
	BORDER_DISTANCE_90(0, 1),
	BORDER_DISTANCE_135(0, 1),
	BORDER_DISTANCE_180(0, 1),
	BORDER_DISTANCE_225(0, 1),
	BORDER_DISTANCE_270(0, 1),
	BORDER_DISTANCE_315(0, 1),
	POPULATION_0(0, 1),
	POPULATION_45(0, 1),
	POPULATION_90(0, 1),
	POPULATION_135(0, 1),
	POPULATION_180(0, 1),
	POPULATION_225(0, 1),
	POPULATION_270(0, 1),
	POPULATION_315(0, 1),
	PHEROMONE_0(0, 1),
	PHEROMONE_45(0, 1),
	PHEROMONE_90(0, 1),
	PHEROMONE_135(0, 1),
	PHEROMONE_180(0, 1),
	PHEROMONE_225(0, 1),
	PHEROMONE_270(0, 1),
	PHEROMONE_315(0, 1),
	AGE(0, 1),
	EMIT_PHEROMONE(0, 1),
	N0(-1.0, 1.0),
	N1(-1.0, 1.0),
	N2(-1.0, 1.0),
	
	MOVE_0(0, 1),
	MOVE_45(0, 1),
	MOVE_90(0, 1),
	MOVE_135(0, 1),
	MOVE_180(0, 1),
	MOVE_225(0, 1),
	MOVE_270(0, 1),
	MOVE_315(0, 1),
	
	;
	public final double min;
	public final double max;
	
	Neuron(double min, double max) {
		this.min = min;
		this.max = max;
	}
}

