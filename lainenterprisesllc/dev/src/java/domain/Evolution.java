package java.domain;

import java.util.*;
import java.util.stream.IntStream;

import static java.domain.Individual.RANDOM;

public class Evolution {
	public final int numberOfIndividuals;
	public final int generationLimit;
	public final int framesPerGeneration;
	public HashSet<Individual> population;
	public GridMap map;
	
	public Evolution(
	 int numberOfIndividuals,
	 int generationLimit,
	 int framesPerGeneration,
	 int width, 
	 int height,
	 float populationDensity
	) {
		this.numberOfIndividuals = numberOfIndividuals;
		this.generationLimit = generationLimit;
		this.framesPerGeneration = framesPerGeneration;
		population = new HashSet<>(); //instantiate population array
		this.map = new GridMap(width, height, populationDensity, RANDOM);
	}
	
	public void RunSimulation() {
		
		for(int generation = 0; generation < generationLimit; generation++) {
			
			List<Individual> deadIndividuals = new ArrayList<>();
			map.incrementPheromones();
			IntStream.range(0, framesPerGeneration)
			 .forEach(x -> population.forEach(individual -> {
				if(individual.isDeadAfterTurn(getSensorStats(individual.x, individual.y), x)) {
					deadIndividuals.add(individual);
				}
			}));
			deadIndividuals.forEach(x -> population.remove(x));
			map.decayPheromones();
		}
	}
	
	private HashMap<Direction, SensorStats> getSensorStats(int x, int y) {
		HashMap<Direction, SensorStats> directionStats = new HashMap<>();
		Arrays.stream(Cardinal.Theta.values())
		 .forEach(
		  it -> {
			 directionStats.put(it, new SensorStats(
			  map.getPheromoneGradientInDirection(it, x, y),
			  map.populationDensityInDirection(it, x, y),
			  it.getDistanceToBorderInDirection(x, y, map.width, map.height)
			 ));
		  });
		 Arrays.stream(InterCardinal.Theta.values())
		 .forEach(
		  it -> {
			 directionStats.put(it, new SensorStats(
			  map.getPheromoneGradientInDirection(it, x, y),
			  map.populationDensityInDirection(it, x, y),
			  it.getDistanceToBorderInDirection(x, y, map.width, map.height)
			 ));
		 });
		return directionStats;
	}
}
