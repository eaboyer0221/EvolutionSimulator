package java.domain;

import java.domain.sensory.emission.Individual;
import java.util.*;
import java.util.stream.IntStream;

import static java.domain.sensory.emission.Individual.RANDOM;

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
	
	private HashMap<Neuron, Double> getSensorStats(int x, int y) {
		HashMap<Degrees, Double> directionStats = new HashMap<>();
		var map = new HashMap<Neuron, Double>(Neuron.values().length);
		Arrays.stream(Degrees.values())
		 .forEach(it -> {
			 directionStats.put(it, it.getPheromoneGradientInDirection(this.map, x, y));
			 // directionStats.put(it.neuron, map.getPheromoneGradientInDirection(it.neuron.directionalNeighbor, x, y));
			 // directionStats.put(it.neuron, (double)map.populationDensityInDirection(it.neuron.degrees), x, y));
			 // directionStats.put(it.neuron, (double)it.neuron.directionalNeighbor.getDistanceToBorderInDirection(x, y, map.width, map.height));
		  });
		
		return  map;
	}
}
