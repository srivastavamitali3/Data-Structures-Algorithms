package airtel.prob2.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    protected List<List<Integer>> adjacencyList;
    protected int noOfVertices;
    protected boolean visitedNodes[];

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        visitedNodes = new boolean[noOfVertices];
        adjacencyList = new ArrayList<>(noOfVertices);
        for (int i = 0; i < noOfVertices; i++)
            adjacencyList.add(new ArrayList<>());
    }

    public void addDirectedEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).add(destinationVertex);
    }

    public void addUndirectedEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).add(destinationVertex);
        adjacencyList.get(destinationVertex).add(sourceVertex);
    }
}
