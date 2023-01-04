package java.domain;

public enum Neuron {
	BORDER_DISTANCE_0(0, 1, Cardinal.PiOverTwoTimes.ZERO, 0),
	POPULATION_0(0, 1, Cardinal.PiOverTwoTimes.ZERO, 0),
	PHEROMONE_0(0, 1, Cardinal.PiOverTwoTimes.ZERO, 0),
	MOVE_0(0, 1, Cardinal.PiOverTwoTimes.ZERO, 0),
	
	BORDER_DISTANCE_45(0, 1, InterCardinal.PiOverFourTimes.ONE, 45),
	POPULATION_45(0, 1, InterCardinal.PiOverFourTimes.ONE, 45),
	PHEROMONE_45(0, 1, InterCardinal.PiOverFourTimes.ONE, 45),
	MOVE_45(0, 1, InterCardinal.PiOverFourTimes.ONE, 45),
	
	BORDER_DISTANCE_90(0, 1, Cardinal.PiOverTwoTimes.ONE, 90),
	POPULATION_90(0, 1, Cardinal.PiOverTwoTimes.ONE, 90),
	PHEROMONE_90(0, 1, Cardinal.PiOverTwoTimes.ONE, 90),
	MOVE_90(0, 1, Cardinal.PiOverTwoTimes.ONE, 90),
	
	BORDER_DISTANCE_135(0, 1, InterCardinal.PiOverFourTimes.THREE, 135),
	POPULATION_135(0, 1, InterCardinal.PiOverFourTimes.THREE, 135),
	PHEROMONE_135(0, 1, InterCardinal.PiOverFourTimes.THREE, 135),
	MOVE_135(0, 1, InterCardinal.PiOverFourTimes.THREE, 135),
	
	BORDER_DISTANCE_180(0, 1, Cardinal.PiOverTwoTimes.TWO, 180),
	POPULATION_180(0, 1, Cardinal.PiOverTwoTimes.TWO, 180),
	PHEROMONE_180(0, 1, Cardinal.PiOverTwoTimes.TWO, 180),
	MOVE_180(0, 1, Cardinal.PiOverTwoTimes.TWO, 180),
	
	BORDER_DISTANCE_225(0, 1, InterCardinal.PiOverFourTimes.FIVE, 225),
	POPULATION_225(0, 1, InterCardinal.PiOverFourTimes.FIVE, 225),
	PHEROMONE_225(0, 1, InterCardinal.PiOverFourTimes.FIVE, 225),
	MOVE_225(0, 1, InterCardinal.PiOverFourTimes.FIVE, 225),
	
	BORDER_DISTANCE_270(0, 1, Cardinal.PiOverTwoTimes.THREE, 270),
	POPULATION_270(0, 1, Cardinal.PiOverTwoTimes.THREE, 270),
	PHEROMONE_270(0, 1, Cardinal.PiOverTwoTimes.THREE, 270),
	MOVE_270(0, 1, Cardinal.PiOverTwoTimes.THREE, 270),
	
	BORDER_DISTANCE_315(0, 1, InterCardinal.PiOverFourTimes.SEVEN, 315),
	POPULATION_315(0, 1, InterCardinal.PiOverFourTimes.SEVEN, 315),
	PHEROMONE_315(0, 1, InterCardinal.PiOverFourTimes.SEVEN, 315),
	MOVE_315(0, 1, InterCardinal.PiOverFourTimes.SEVEN, 315),
	

	EMIT_PHEROMONE(0, 1, null, -1),
	AGE(0, 1, null, -1),
	
	
	N0(-1.0, 1.0, null, -1),
	N1(-1.0, 1.0, null, -1),
	N2(-1.0, 1.0, null, -1),
	
	
	;
	public final double min;
	public final double max;
	public final DirectionalNeighbor directionalNeighbor;
	public final int degrees;
	
	Neuron(double min, double max, DirectionalNeighbor directionalNeighbor, int degrees) {
		this.min = min;
		this.max = max;
		this.directionalNeighbor = directionalNeighbor;
		this.degrees = degrees;
	}
	
}

