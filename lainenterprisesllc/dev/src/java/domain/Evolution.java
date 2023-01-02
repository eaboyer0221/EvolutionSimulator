package src.java.domain;

import java.util.Arrays;

public class Evolution {
    private final int numberOfIndividuals;
    private final int numberOfGenerations;
    private final int framesPerGeneration;
    public Individual[] population;

    public Evolution(int numberOfGenerations, int framesPerGeneration) {
        this.numberOfGenerations = numberOfGenerations;
        this.framesPerGeneration = framesPerGeneration;
        population = new Individual[numberOfIndividuals]; //instantiate population array

    }

    public void RunSimulation() {
        for (int genCount = 0; genCount < numberOfGenerations; genCount++) {
            for (int frameCount = 0; frameCount < framesPerGeneration; frameCount++) {
                Arrays.stream(population).forEach(x -> x.takeAction());
            }
        }
    }
}
