package kg.askaromurkanov;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    List<Integer> edges;

    public Edge() {
        this.edges = new ArrayList<>();
    }

    public List<Integer> getEdges() {
        return edges;
    }

    public void setAdjacency(List<Integer> adjacency) {
        this.edges = edges;
    }
}
