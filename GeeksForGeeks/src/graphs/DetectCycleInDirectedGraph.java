package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

class DetectCycle {

    public boolean isCyclic(ArrayList<ArrayList<Integer>> list, int nov) {
        boolean[] visited = new boolean[nov + 1];
        boolean[] explored = new boolean[nov + 1];
        for (int i = 0; i < nov; i++) {
            if (!visited[i])
                if (isCyclicUtil(i, list, visited, explored))
                    return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int sourceIndex, ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] explored) {
        visited[sourceIndex] = true;
        explored[sourceIndex] = true;
        for (int i = 0; i < list.get(sourceIndex).size(); i++) {
            int currentNode = list.get(sourceIndex).get(i);
            if (!visited[currentNode])
                if (isCyclicUtil(currentNode, list, visited, explored))
                    return true;
                else if (explored[currentNode])
                    return true;
        }
        explored[sourceIndex] = false;
        return false;
    }
}
