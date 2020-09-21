package airtel.prob2.service;

import airtel.prob2.graph.Graph;

import java.util.ArrayList;
import java.util.List;

public class StateMachineService extends Graph {

    private boolean pathFound = false;

    public StateMachineService(int noOfVertices) {
        super(noOfVertices);
    }

    public void printAllPaths(int source, int destination) {
        pathFound = false;
        List<Integer> pathList = new ArrayList<>();

        pathList.add(source);

        printAllPathsUtil(source, destination, pathList);
        if (!pathFound)
            System.out.println("No path found");

        System.out.println();
    }

    private void printAllPathsUtil(Integer source, Integer destination, List<Integer> localPathList) {

        visitedNodes[source] = true;

        if (source.equals(destination)) {
            System.out.println(localPathList);
            pathFound = true;
            visitedNodes[source] = false;
            return;
        }

        for (Integer i : adjacencyList.get(source)) {
            if (!visitedNodes[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, destination, localPathList);

                localPathList.remove(i);
            }
        }

        visitedNodes[source] = false;
    }
}
