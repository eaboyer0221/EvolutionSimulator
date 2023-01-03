package java.domain;


public class NeuralConnection<StartNode, EndNode> {
    public final StartNode start;
    public final  EndNode end;

    public NeuralConnection(StartNode start, EndNode end) {
        this.start = start;
        this.end = end;
    }
}
