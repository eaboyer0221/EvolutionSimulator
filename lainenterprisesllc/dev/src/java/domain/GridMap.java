package src.java.domain;

import java.util.*;
import java.util.stream.IntStream;


public class GridMap {
    private final int width;
    private final int height;
    GridLocation[][] map;
    private Individual[] population;

    public GridMap(int width, int height, float populationDensity, Random rand) {
        this.width = width;
        this.height = height;
        map = new GridLocation[width][height];
        int numItems = (int) (width * height * populationDensity);
        this.population = new Individual[numItems];
        for (int i = 0; i < numItems;) {
            int w = rand.nextInt(width);
            int h = rand.nextInt(height);
            GridLocation gridLocation = map[w][h];
            if(gridLocation.item.isPresent()) {
                continue;
            }
            Individual individual = new Individual(w,h);
            population[i] = individual;
            i++;
        }
    }

    public void decayPheromones(){
        Arrays.stream(map).forEach(x -> Arrays.stream(x).forEach(GridLocation::decayPheromones));
    }

    public void incrementPheromones(){
        HashMap<Pair<Integer, Integer>, HashMap<Pair<Integer, Integer> , Integer>> pheromoneClouds = new HashMap<>();
        Arrays.stream(population).forEach(x -> getPheromoneCloud(x.x, x.y, new HashMap<>(), x.pheromoneLevel).entrySet().forEach(entry -> {
            int i = entry.getKey().getKey();
            int j = entry.getKey().getValue();
            map[i][j].pheromoneLevel += entry.getValue();
        }));}

    public HashMap<GridMap.Pair<Integer, Integer>, Integer> getPheromoneCloud(int i, int j, HashMap<Pair<Integer, Integer>, Integer> pairs, int pheromoneLevel) {
        if (i < 0 || j < 0 || i >= height || j >= width || pheromoneLevel == 0 ) {
            return pairs;
        }
        Queue<Pair<Integer, Integer>> queu = new PriorityQueue<>();
        queu.add(new Pair<>(i,j));
        while(!queu.isEmpty()){
            Pair<Integer, Integer> pair = queu.remove();
            if (!pairs.containsKey(pair)){
                pairs.put(pair, 0);
            }
            pairs.put(pair, pheromoneLevel);
            if (pair.getKey()+1 < height){
                queu.add(new Pair<>(pair.getKey()+1, pair.getValue()));
            }
            if (pair.getKey()-1 >= 0){
                queu.add(new Pair<>(pair.getKey()-1, pair.getValue()));
            }
            if (pair.getValue()+1 < width){
                queu.add(new Pair<>(pair.getKey(), pair.getValue()+1));
            }
            if (pair.getValue()-1 >= 0){
                queu.add(new Pair<>(pair.getKey(), pair.getValue()-1));
            }
        }
        return pairs;
    }

    class Pair<k, v> extends AbstractMap.SimpleEntry<k, v> {

        public Pair(k key, v value) {
            super(key, value);
        }
    }
    public GridLocation get(int i,int j) {
        return map[i][j];
    }
    public List<GridLocation> getCollinearLocations (int i, int j, LinearDirection direction) {
        if(direction == LinearDirection.NORTHSOUTH) {
            int finalJ = j;
            return IntStream.range(0, height).mapToObj(x -> get(x, finalJ)).toList();
        }
        else if(direction == LinearDirection.EASTWEST) {
            return Arrays.stream(map[i]).toList();
        }
        else if(direction == LinearDirection.NORTHEASTSOUTHWEST) {
            ArrayList<GridLocation> gridLocationArrayList = new ArrayList<GridLocation>();
            int minimum = Math.min(i, j);
            i -= minimum;
            j -= minimum;
            while(i < width && j < height){
                gridLocationArrayList.add(map[i++][j++]);
            }
            return gridLocationArrayList;
        }
        else {
            ArrayList<GridLocation> gridLocationArrayList = new ArrayList<GridLocation>();
            int minimum = Math.min(i, height-j);
            i -= minimum;
            j += minimum;
            while(i < width && j < height){
                gridLocationArrayList.add(map[i++][j--]);
            }
            return gridLocationArrayList;
        }
    }
}
