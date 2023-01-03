package java.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.domain.Cardinal.Theta.*;

public class GridMap {
	public final int width;
	public final int height;
	GridLocation[][] map;
	public final List<Individual> population;
	
	
	public GridMap(int width, int height, float populationDensity, Random rand) {
		this.width = width;
		this.height = height;
		map = new GridLocation[width][height];
		int numItems = (int)( width * height * populationDensity );
		this.population = new ArrayList<>();
		for(int i = 0; i < numItems; ) {
			int w = rand.nextInt(width);
			int h = rand.nextInt(height);
			GridLocation gridLocation = map[w][h];
			if(gridLocation.item.isPresent()) {
				continue;
			}
			Individual individual = new Individual(w, h);
			population.add(0, individual);
			i++;
		}
	}
	
	/**
	 * Reduce all pheromone levels on the map by one half.
	 */
	public void decayPheromones() {
		Arrays.stream(map)
		 .forEach(x -> Arrays.stream(x)
		  .forEach(GridLocation::decayPheromones));
	}
	
	/**
	 * Add some pheromones for each Individual by calculating their "cloud"
	 */
	public void incrementPheromones() {
		
		population.forEach(x -> 
		 getPheromoneCloud(x.x, x.y, new HashMap<>(), x.pheromoneLevel)
		  .forEach((key, value) -> {
			int i = key.getKey();
			int j = key.getValue();
			map[i][j].pheromoneLevel += value;
		}));
	}
	
	/**
	 * Get an Individual's stanky-ass pheromone cloud to  be emitted.
	 * @param i the row
	 * @param j the column
	 * @param pairs the coords which map to the amount of pheromone to be applied.
	 * @param pheromoneLevel the base level to apply to the current spot and to calculate 
	 *                          the next recursive spot's level with.
	 * @return a HashMap with coordinates and pheromone levels to apply for
	 * 	 * the given stanky-ass Individual.
	 */
	public HashMap<Pair<Integer, Integer>, Integer> getPheromoneCloud(
	 int i, 
	 int j,
	 HashMap<Pair<Integer, Integer>, Integer> pairs,
	 int pheromoneLevel
	) {
		
		if(i < 0 || j < 0 || i >= height || j >= width || pheromoneLevel == 0) {
			return pairs;
		}
		Queue<Pair<Integer, Integer>> queu = new PriorityQueue<>();
		queu.add(new Pair<>(i, j));
		while(!queu.isEmpty()) {
			Pair<Integer, Integer> pair = queu.remove();
			if(!pairs.containsKey(pair)) {
				pairs.put(pair, 0);
			}
			pairs.put(pair, pheromoneLevel);
			if(pair.getKey() + 1 < height) {
				queu.add(new Pair<>(pair.getKey() + 1, pair.getValue()));
			}
			if(pair.getKey() - 1 >= 0) {
				queu.add(new Pair<>(pair.getKey() - 1, pair.getValue()));
			}
			if(pair.getValue() + 1 < width) {
				queu.add(new Pair<>(pair.getKey(), pair.getValue() + 1));
			}
			if(pair.getValue() - 1 >= 0) {
				queu.add(new Pair<>(pair.getKey(), pair.getValue() - 1));
			}
		}
		return pairs;
	}
	
	/**
	 * Get the gradient of pheromone in the given direction.
	 * @return a list of Integers representing the pheromone gradient, radiating from direction.  
	 */
	public Double getPheromoneGradientInDirection(
	 Direction direction, 
	 int i,
	 int j
	) {
		
		return getCollinearLocations(direction, i, j)
		 .collect(Collectors.averagingInt(x -> x.pheromoneLevel));
	}
	
	/**
	 * Get all locations along an axis.
	 * @return a List of all collinear locations along the given axis. 
	 */
	private Stream<GridLocation> getCollinearLocations(
	 Direction direction,
	 int i,
	 int j
	) {
		
		Pair<Integer, Integer> stepSizes = direction.getStepSizes();
		int xStep = stepSizes.getKey();
		int yStep = stepSizes.getValue();
		List<GridLocation> locations = new ArrayList<>();
		while(i < height && j < width && i >= 0 && j >= 0) {
			locations.add(map[i][j]);
			i += xStep;
			j += yStep;
		}
		return locations.stream();
	}
	
	/**
	 * @return a Stream of GridLocations with all locations within the bifurcation,
	 * as specified by cardinal.
	 */	
	private Stream<GridLocation> getBifurcatedSectorInDirection(
	 Cardinal cardinal,
	 int x,
	 int y
	) {
		
		List<GridLocation> locations = new ArrayList<>();
		switch(cardinal.theta) {
			case _0_DEGREES -> IntStream.range(x + 1, width).forEach(itX -> 
			 IntStream.range(0, height).forEach(itY -> 
			  locations.add(map[itX][itY])));
			
			case _90_DEGREES -> IntStream.range(0, width).forEach(itX -> 
		 IntStream.range(0, y - 1).forEach(itY -> 
		  locations.add(map[itX][itY])));
			
			case _180_DEGREES -> IntStream.range(0, x).forEach(itX -> 
		 IntStream.range(0, height).forEach(itY -> 
		  locations.add(map[itX][itY])));
			
			case _270_DEGREES -> IntStream.range(0, width).forEach(itX -> 
		 IntStream.range(y + 1, height).forEach(itY -> 
		  locations.add(map[itX][itY])));
		}
		return locations.stream();
	}
	
	/**
	 * @return a Stream of GridLocations with all locations within the bifurcation,
	 * as specified by interCardinal.
	 */	
	private Stream<GridLocation> getBifurcatedSectorInDirection(
	 InterCardinal interCardinal,
	 int x,
	 int y
	) {
		
		var stream = getCollinearLocations(interCardinal.theta, x, y);
		return Stream.concat(stream, 
		switch(interCardinal.theta) {
			case _45_DEGREES -> getGridLocationStream(x, y, stream, _0_DEGREES, _90_DEGREES);
			case _135_DEGREES-> getGridLocationStream(x, y, stream, _90_DEGREES, _180_DEGREES);
			case _225_DEGREES-> getGridLocationStream(x, y, stream, _180_DEGREES, _270_DEGREES);
			case _315_DEGREES-> getGridLocationStream(x, y, stream, _270_DEGREES, _0_DEGREES);
		});
	}
	
	private Stream<GridLocation> getGridLocationStream(int x, int y, Stream<GridLocation> stream,
	 Cardinal.Theta angle1, Cardinal.Theta angle2) {
		stream = Stream.concat(stream, getAcuteSectorInDirection(new Cardinal(angle1), x, y));
		return Stream.concat(stream, getAcuteSectorInDirection(new Cardinal(angle2), x, y));
	}
	
	/**
	 * @return a Stream of GridLocations with all locations within the sector,
	 * as specified by cardinal.
	 */	
	private Stream<GridLocation> getAcuteSectorInDirection(
	 Cardinal cardinal,
	 int x,
	 int y
	) {
		List<GridLocation> list = new ArrayList<>();
		switch(cardinal.theta) {
			case _0_DEGREES -> {
				for(int j = x + 1; j < width; j++) {
					for(int i = y - j; i < height && i <= y + j; i++) {
						list.add(map[i][j]);
					}
				}
			}
			case _90_DEGREES -> {
				for(int i = 0; i < height && i < y; i++) {
					for(int j = x - y + 1; j < width && j < x + y; j++) {
						list.add(map[i][j]);
					}
				}
			}			
			case _180_DEGREES -> {
				for(int j = x - 1; j >= 0; j--) {
					for(int i = y - j; i < height && i <= y + j; i++) {
						list.add(map[i][j]);
					}
				}
			}			
			case _270_DEGREES -> {
				for(int i = y + 1; i < height; i++) {
					for(int j = x - y + 1; j < width && j < x + y; j++) {
						list.add(map[i][j]);
					}
				}
			} 
		}
		return list.stream();
	}
	
	/**
	 * @return a Stream of GridLocations with all locations within the sector,
	 * as specified by interCardinal.
	 */		
	private Stream<GridLocation> getAcuteSectorInDirection(
	 InterCardinal interCardinal,
	 int x,
	 int y
	) {
		List<GridLocation> list = new ArrayList<>();
		switch(interCardinal.theta) {
			case _45_DEGREES -> {
				for(int i = x + 1; i < width; i++) {
					for(int j =0; j < y; j++) {
						list.add(map[j][i]);
					}
				}
			}
			case _135_DEGREES-> {
				for(int i = 0; i < x; i++) {
					for(int j =0; j < y; j++) {
						list.add(map[j][i]);
					}
				}
			}
			case _225_DEGREES-> {
				for(int i = 0; i < x; i++) {
					for(int j = y + 1; j < height; j++) {
						list.add(map[j][j]);
					}
				}
			}
			case _315_DEGREES-> {
				for(int i = x + 1; i < width; i++) {
					for(int j = y + 1; j < height; j++) {
						list.add(map[j][j]);
					}
				}	
			}
		}
		return list.stream();
	}
	
	public float populationDensityInDirection(Cardinal.Theta direction, int x, int y) {
		var locs = getCollinearLocations(direction, x, y);
		return locs.filter(it -> it.item.isPresent() 
		  && it.item.get() instanceof Individual)
		 .collect(Collectors.averagingDouble(
		  it -> it.pheromoneLevel)).floatValue();
	}
	
	public float populationDensityInDirection(InterCardinal.Theta direction, int x, int y) {
		var locs = getCollinearLocations(direction, x, y);
		return locs.filter(it -> it.item.isPresent() 
		  && it.item.get() instanceof Individual)
		 .collect(Collectors.averagingDouble(
		  it -> it.pheromoneLevel)).floatValue();
	}
}
	
