package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph {
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
                list.get(v).add(u);
            }
            if (isCyclic(list, nov))
                System.out.println("1");
            else System.out.println("0");
        }
    }

    private static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int vertices) {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            visited[i] = false;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && isCyclicConnected(list, i, vertices, visited))
                return true;
        }
        return false;
    }

    private static boolean isCyclicConnected(ArrayList<ArrayList<Integer>> list, int s, int vertices, boolean[] visited) {
        Queue<Integer> Q = new LinkedList<>();
        int[] parent = new int[vertices + 1];
        Arrays.fill(parent, -1);
        visited[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            for (int i = 0; i < list.get(temp).size(); i++) {
                int node = list.get(temp).get(i);
                if (!visited[node]) {
                    visited[node] = true;
                    Q.add(node);
                    parent[node] = temp;
                } else if (parent[temp] != node)
                    return true;
            }
        }
        return false;
    }
}
