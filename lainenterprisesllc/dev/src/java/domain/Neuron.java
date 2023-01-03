package java.domain;

public enum Neuron {
	BORDER_DISTANCE_0(0, 1, Cardinal.Theta._0_DEGREES, 0),
	POPULATION_0(0, 1, Cardinal.Theta._0_DEGREES, 0),
	PHEROMONE_0(0, 1, Cardinal.Theta._0_DEGREES, 0),
	MOVE_0(0, 1, Cardinal.Theta._0_DEGREES, 0),
	
	BORDER_DISTANCE_45(0, 1, InterCardinal.Theta._45_DEGREES, 45),
	POPULATION_45(0, 1, InterCardinal.Theta._45_DEGREES, 45),
	PHEROMONE_45(0, 1, InterCardinal.Theta._45_DEGREES, 45),
	MOVE_45(0, 1, InterCardinal.Theta._45_DEGREES, 45),
	
	BORDER_DISTANCE_90(0, 1, Cardinal.Theta._90_DEGREES, 90),
	POPULATION_90(0, 1, Cardinal.Theta._90_DEGREES, 90),
	PHEROMONE_90(0, 1, Cardinal.Theta._90_DEGREES, 90),
	MOVE_90(0, 1, Cardinal.Theta._90_DEGREES, 90),
	
	BORDER_DISTANCE_135(0, 1, InterCardinal.Theta._135_DEGREES, 135),
	POPULATION_135(0, 1, InterCardinal.Theta._135_DEGREES, 135),
	PHEROMONE_135(0, 1, InterCardinal.Theta._135_DEGREES, 135),
	MOVE_135(0, 1, InterCardinal.Theta._135_DEGREES, 135),
	
	BORDER_DISTANCE_180(0, 1, Cardinal.Theta._180_DEGREES, 180),
	POPULATION_180(0, 1, Cardinal.Theta._180_DEGREES, 180),
	PHEROMONE_180(0, 1, Cardinal.Theta._180_DEGREES, 180),
	MOVE_180(0, 1, Cardinal.Theta._180_DEGREES, 180),
	
	BORDER_DISTANCE_225(0, 1, InterCardinal.Theta._225_DEGREES, 225),
	POPULATION_225(0, 1, InterCardinal.Theta._225_DEGREES, 225),
	PHEROMONE_225(0, 1, InterCardinal.Theta._225_DEGREES, 225),
	MOVE_225(0, 1, InterCardinal.Theta._225_DEGREES, 225),
	
	BORDER_DISTANCE_270(0, 1, Cardinal.Theta._270_DEGREES, 270),
	POPULATION_270(0, 1, Cardinal.Theta._270_DEGREES, 270),
	PHEROMONE_270(0, 1, Cardinal.Theta._270_DEGREES, 270),
	MOVE_270(0, 1, Cardinal.Theta._270_DEGREES, 270),
	
	BORDER_DISTANCE_315(0, 1, InterCardinal.Theta._315_DEGREES, 315),
	POPULATION_315(0, 1, InterCardinal.Theta._315_DEGREES, 315),
	PHEROMONE_315(0, 1, InterCardinal.Theta._315_DEGREES, 315),
	MOVE_315(0, 1, InterCardinal.Theta._315_DEGREES, 315),
	

	EMIT_PHEROMONE(0, 1, null, -1),
	AGE(0, 1, null, -1),
	
	
	N0(-1.0, 1.0, null, -1),
	N1(-1.0, 1.0, null, -1),
	N2(-1.0, 1.0, null, -1),
	
	
	;
	public final double min;
	public final double max;
	public final Direction direction;
	public final int degrees;
	
	Neuron(double min, double max, Direction direction, int degrees) {
		this.min = min;
		this.max = max;
		this.direction = direction;
		this.degrees = degrees;
	}
	
}

