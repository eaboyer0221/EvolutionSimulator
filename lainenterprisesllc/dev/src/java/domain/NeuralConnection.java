package src.java.domain;


public class NeuralConnection<StartNode, EndNode> {
    private StartNode start;
    private EndNode end;

    public NeuralConnection(StartNode start, EndNode end) {
        this.start = start;
        this.end = end;
    }

}
