package airtel;

import java.util.ArrayList;
import java.util.List;

class Graph {
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

    protected void addDirectedEdge(int sourceVertex, int destinationVertex) {
        adjacencyList.get(sourceVertex).add(destinationVertex);
    }
}

public class MachineState extends Graph {
    boolean pathFound = false;

    public MachineState(int noOfVertices) {
        super(noOfVertices);
    }

    public static void main(String[] args) {
        MachineState ms = new MachineState(11);
        ms.addDirectedEdge(1, 2);
        ms.addDirectedEdge(1, 3);
        ms.addDirectedEdge(2, 4);
        ms.addDirectedEdge(2, 5);
        ms.addDirectedEdge(2, 6);
        ms.addDirectedEdge(3, 7);
        ms.addDirectedEdge(3, 8);
        ms.addDirectedEdge(4, 9);
        ms.addDirectedEdge(5, 9);
        ms.addDirectedEdge(7, 10);
        ms.addDirectedEdge(8, 10);

        ms.findPaths(1, 4);
        ms.findPaths(2, 9);
        ms.findPaths(3, 4);
    }

    private void findPaths(int sourceVertex, int destination) {
        boolean[] isVisited = new boolean[noOfVertices];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathFound = false;
        //add source to path[]
        pathList.add(sourceVertex);

        //Call recursive utility
        System.out.println("Start State : " + sourceVertex + " to End State :" + destination);
        printAllPathsUtil(sourceVertex, destination, isVisited, pathList);
        if (!pathFound)
            System.out.println("NO");

    }

    private void printAllPathsUtil(Integer sourceVertex, Integer destination, boolean[] isVisited,
                                   ArrayList<Integer> pathList) {
        isVisited[sourceVertex] = true;
        if (sourceVertex.equals(destination)) {
            System.out.println("YES : " + pathList);
            pathFound = true;
            // if match found then no need to traverse more till depth
            isVisited[sourceVertex] = false;
            return;
        }
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjacencyList.get(sourceVertex)) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                pathList.add(i);
                printAllPathsUtil(i, destination, isVisited, pathList);
                // remove current node
                // in path[]
                pathList.remove(i);
            }
        }
        // Mark the current node
        isVisited[sourceVertex] = false;
    }
}
