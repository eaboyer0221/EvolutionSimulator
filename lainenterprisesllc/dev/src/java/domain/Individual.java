package src.java.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Individual {

    private static Individual genome_instance;
    public static final int NUM_EDGES = 8;
    private final Gene[] genes;

    public static Individual getInstance()
    {
        if (genome_instance == null)
            genome_instance = new Individual();

        return genome_instance;
    }

    static Predicate<NeuralNode> intermediatePredicate = x -> x.nodeTypes.contains(NodeType.END) && x.nodeTypes.contains(NodeType.START);
    static Predicate<NeuralNode> sensoryPredicate = x -> !x.nodeTypes.contains(NodeType.END);
    static Predicate<NeuralNode> actionPredicate = x -> !x.nodeTypes.contains(NodeType.START);
    public static final NeuralNode[] sensoryNodes = (NeuralNode[]) Arrays.stream(NeuralNode.values()).filter(actionPredicate).collect(Collectors.toList()).toArray();
    public static final NeuralNode[] intermediateNodes = (NeuralNode[]) Arrays.stream(NeuralNode.values()).filter(intermediatePredicate).collect(Collectors.toList()).toArray();
    public static final NeuralNode[] actionNodes = (NeuralNode[]) Arrays.stream(NeuralNode.values()).filter(sensoryPredicate).collect(Collectors.toList()).toArray();
    public static final NeuralNode[] startNodes = new NeuralNode[sensoryNodes.length + intermediateNodes.length];
    public static final NeuralNode[] endNodes = new NeuralNode[actionNodes.length + intermediateNodes.length];

    static {
        int i = 0;
        for (NeuralNode sensoryNode : sensoryNodes) {
            startNodes[i++] = sensoryNode;
        }
        for (NeuralNode intermediateNode : intermediateNodes) {
            startNodes[i++] = intermediateNode;
        }
        i = 0;
        for (NeuralNode actionNode : actionNodes) {
            endNodes[i++] = actionNode;
        }
        for (NeuralNode intermediateNode : intermediateNodes) {
            endNodes[i++] = intermediateNode;
        }
    }

    private static NeuralNode nextRandomNode(NeuralNode[] neuralNodes) {
        return neuralNodes[new Random().nextInt(neuralNodes.length)];
    }

    public static NeuralNode randomStartNode() {
        return nextRandomNode(startNodes);
    }

    public static Gene randomGene() {
        return new Gene(randomStartNode(), randomEndNode());
    }

    public Individual() {
        this.genes = new Gene[NUM_EDGES];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = randomGene();
        }
    }

    public Individual(List<Individual> parents) {
        //todo take a piece of each parent and use it to make the individual
    }

    public static NeuralNode randomEndNode() {
        return nextRandomNode(endNodes);
    }

}
