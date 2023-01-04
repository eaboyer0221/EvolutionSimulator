package java.domain.sensory.emission;

import java.domain.*;
import java.domain.sensory.detection.EyeBall;
import java.domain.sensory.sensoryconcepts.PhysicalItem;
import java.domain.sensory.detection.Nose;
import java.domain.sensory.detection.Ear;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Individual extends PhysicalItem {

    public static final Random RANDOM = new Random();
    public static final int NUM_EDGES = 8;
    private final List<NeuralConnection<NeuralNode, NeuralNode>> genes;
    public int x;
    public int y;
    private final float responsiveness;
    public int pheromoneLevel;
	public boolean isDead;
	
	public EyeBall eyeBall;
	public Armpit armpit;
	public Nose nose;
	public Ear ear;
	public VoiceBox voiceBox;
	

    static Predicate<NeuralNode> intermediatePredicate = x -> x.nodeTypes.contains(NodeType.END) && x.nodeTypes.contains(NodeType.START);
    static Predicate<NeuralNode> sensoryPredicate = x -> !x.nodeTypes.contains(NodeType.END);
    static Predicate<NeuralNode> actionPredicate = x -> !x.nodeTypes.contains(NodeType.START);
    public static final NeuralNode[] sensoryNodes = getNeuralNodes(actionPredicate);

    public	 static NeuralNode[] getNeuralNodes(Predicate<NeuralNode> actionPredicate) {
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

    public List<NeuralConnection<NeuralNode, NeuralNode>> shuffleGenes(){
        Collections.shuffle(genes);
        return genes;
    }

    public Individual(int x, int y) {
        this.x = x;
        this.y = y;
        this.genes = new ArrayList<>(NUM_EDGES);
        this.responsiveness = RANDOM.nextFloat();
        for (int i = 0; i < NUM_EDGES; i++) {
            genes.add(0,  randomGene());
        }
    }

    public Individual(List<Individual> parents) {
        //make list of queues
        List<PriorityQueue<NeuralConnection<NeuralNode, NeuralNode>>> genePool = parents.stream().map(x -> new PriorityQueue<>(x.shuffleGenes())).collect(Collectors.toList());
        List<Float> responsivenesses = parents.stream().map(Individual::getResponsiveness).toList();
        this.responsiveness = responsivenesses.get(RANDOM.nextInt(responsivenesses.size()));

        HashSet<NeuralConnection<NeuralNode, NeuralNode>> genes = new HashSet<>(NUM_EDGES);
        Iterator<PriorityQueue<NeuralConnection<NeuralNode, NeuralNode>>> it = genePool.iterator();
        while(genes.size() < NUM_EDGES) {
            genes.add(it.next().remove());
        }
        this.genes = new ArrayList<>(NUM_EDGES);
        Iterator<NeuralConnection<NeuralNode, NeuralNode>> it2 = genes.iterator();
        for (int i = 0; i < genes.size(); i++) {
            this.genes.add(0, it2.next());
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

    private boolean takeAction(HashMap<Neuron, Double> directionStats, int age) {
		boolean isDead = false;
		for(NeuralNode startNode: startNodes) {
			var value = directionStats.get(startNode.neuron);
			
		}
		directionStats.entrySet().stream().forEach(entry -> {
			Neuron neuron = entry.getKey();
			Double value = entry.getValue();
			// Todo, do something with the Neruon and value
		});
        // Todo: make a decision on where to move
        // Todo: update coordinates for individual
		return isDead;
    }
	
	public boolean isDeadAfterTurn(HashMap<Neuron, Double> directionStats, int age) {
		return takeAction(directionStats, age);
	}
	
	@Override public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!( o instanceof Individual that )) {
			return false;
		}
		return x == that.x && y == that.y;
	}
	
	@Override public int hashCode() {
		return Objects.hash(x, y);
	}
	
}

