package src.java.domain;

import java.util.*;
import java.util.function.Predicate;

public class Individual extends PhysicalItem {

    public static final Random RANDOM = new Random();
    public static final int NUM_EDGES = 8;
    private final NeuralConnection[] genes;
    public int x;
    public int y;
    private final float responsiveness;
    public int pheromoneLevel;


    static Predicate<NeuralNode> intermediatePredicate = x -> x.nodeTypes.contains(NodeType.END) && x.nodeTypes.contains(NodeType.START);
    static Predicate<NeuralNode> sensoryPredicate = x -> !x.nodeTypes.contains(NodeType.END);
    static Predicate<NeuralNode> actionPredicate = x -> !x.nodeTypes.contains(NodeType.START);
    public static final NeuralNode[] sensoryNodes = getNeuralNodes(actionPredicate);

    private static NeuralNode[] getNeuralNodes(Predicate<NeuralNode> actionPredicate) {
        var nodes = Arrays.stream(NeuralNode.values()).filter(actionPredicate).toList();
        var array = new NeuralNode[nodes.size()];
        Iterator<NeuralNode> it = nodes.iterator();
        for (int i = 0; i < array.length;) {array[i++] = it.next();}
        return array;
    }

    public static final NeuralNode[] intermediateNodes = getNeuralNodes(intermediatePredicate);
    public static final NeuralNode[] actionNodes = getNeuralNodes(sensoryPredicate);
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
        return neuralNodes[RANDOM.nextInt(neuralNodes.length)];
    }

    public static NeuralNode randomStartNode() {
        return nextRandomNode(startNodes);
    }

    public static NeuralConnection<NeuralNode, NeuralNode> randomGene() {
        return new NeuralConnection<>(randomStartNode(), randomEndNode());
    }

    public List<NeuralConnection> shuffleGenes(){
        List<NeuralConnection> geneList = Arrays.stream(genes).toList();
        Collections.shuffle(geneList);
        return geneList;
    }

    public Individual(int x, int y) {
        this.x = x;
        this.y = y;
        this.genes = new NeuralConnection[NUM_EDGES];
        this.responsiveness = RANDOM.nextFloat();
        for (int i = 0; i < genes.length; i++) {
            genes[i] = randomGene();
        }
    }

    public Individual(List<Individual> parents) {
        //make list of queues
        List<PriorityQueue<NeuralConnection>> genePool = parents.stream().map(x -> new PriorityQueue<>(x.shuffleGenes())).toList();
        List<Float> responsivenesses = parents.stream().map(Individual::getResponsiveness).toList();
        this.responsiveness = responsivenesses.get(RANDOM.nextInt(responsivenesses.size()));

        HashSet<NeuralConnection<NeuralNode, NeuralNode>> genes = new HashSet<>(NUM_EDGES);
        Iterator<PriorityQueue<NeuralConnection>> it = genePool.iterator();
        while(genes.size() < NUM_EDGES) {
            genes.add(it.next().remove());
        }
        this.genes = new NeuralConnection[NUM_EDGES];
        Iterator<NeuralConnection<NeuralNode, NeuralNode>> it2 = genes.iterator();
        for (int i = 0; i < genes.size(); i++) {
            this.genes[i] = it2.next();
        }
        //todo randomly mutate the inherited aspects of the individual
    }

    private Float getResponsiveness() {
        float f = (float) (RANDOM.nextGaussian()*.1 + responsiveness);
        if(f < 0 || f > 1) {
            return responsiveness;
        }
        return f;
    }

    public static NeuralNode randomEndNode() {
        return nextRandomNode(endNodes);
    }

    public void takeAction() {
        //todo make a decision on where to move

        //todo update coordinates for individual
    }


}
