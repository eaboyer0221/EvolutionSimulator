package src.java.domain;

import java.util.Arrays;

public class Evolution {
    private final int numberOfIndividuals;
    private final int numberOfGenerations;
    private final int framesPerGeneration;
    public Individual[] population;

    public Evolution(int numberOfIndividuals, int numberOfGenerations, int framesPerGeneration) {
        this.numberOfIndividuals = numberOfIndividuals;
        this.numberOfGenerations = numberOfGenerations;
        this.framesPerGeneration = framesPerGeneration;
        population = new Individual[numberOfIndividuals]; //instantiate population array
        for (int i = 0; i < numberOfIndividuals; i++) {
            population[i] = new Individual(); //pass Individual method to create new random individual
        }
    }

    public void RunSimulation() {
        for (int genCount = 0; genCount < numberOfGenerations; genCount++) {
            for (int frameCount = 0; frameCount < framesPerGeneration; frameCount++) {
                Arrays.stream(population).forEach(x -> x.takeAction());
            }
        }
    }
}
