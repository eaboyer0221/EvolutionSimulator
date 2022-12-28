package src.java.domain;


public class Gene<StartNode, EndNode> {
    private StartNode start;
    private EndNode end;

    public Gene(StartNode start, EndNode end) {
        this.start = start;
        this.end = end;
    }

}
