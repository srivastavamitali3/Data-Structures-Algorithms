package amazonQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 Results is at most the number of edges we have O(E) i.e. every connection is critical,
 and then we have the visited section which is O(V) i.e. total number of possible verticies,
 and then we have the Adjacency list which is for every Vertex we have every single connection.
 Since this is undirected graph and we have the same connection twice its technically
  O(2E) + O(V) = O (V + E), and of course the DFS recursion space which is O (V)
  simply because the furthest we can go is the total number of edges given that we are using
  DFS and going as deep as we can go.
 */
public class CriticalRouters {
    public class Node {
        int val;
        boolean[] neighbours;

        public Node(int val, int size) {
            this.val = val;
            this.neighbours = new boolean[size];
        }
    }

    public class Graph {
        Node[] graph;

        public Graph(int n) {
            this.graph = new Node[n];
        }
    }

    public Graph makeGraph(int n) {
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            g.graph[i] = new Node(i, n);
        }
        return g;
    }

    public Graph fillNeighbours(int n, Graph g, List<List<Integer>> connections) {
        int start = 0;
        int end = 1;
        for (int i = 0; i < connections.size(); i++) {
            int x = connections.get(i).get(start);
            int y = connections.get(i).get(end);
            g.graph[x].neighbours[y] = true;
            g.graph[y].neighbours[x] = true;
        }
        return g;
    }

    public void dfs(Graph g, int currentNode, int n, boolean[] visited) {
        Node node = g.graph[currentNode];
        visited[currentNode] = true;
        for (int i = 0; i < n; i++) {
            if (node.neighbours[i] == true && visited[i] == false) {
                dfs(g, i, n, visited);
            }
        }
    }

    public boolean allVisited(boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public void fillResult(int u, int v, List<List<Integer>> res) {
        // to make u < v
        if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        int start = 0;
        int end = 1;
        for (int entry = 0; entry < res.size(); entry++) {
            if (res.get(entry).get(start) == u && res.get(entry).get(end) == v) {
                return;
            }
        }
        ArrayList<Integer> newResult = new ArrayList<Integer>();
        newResult.add(u);
        newResult.add(v);
        res.add(newResult);
    }

    public void skeletalDfs(int n, Graph g, List<List<Integer>> res) {
        for (int node = 0; node < n; node++) {
            Node current = g.graph[node];
            for (int i = 0; i < n; i++) {
                if (current.neighbours[i] == true && i != node) {
                    current.neighbours[i] = false;
                    g.graph[i].neighbours[node] = false;
                    //call dfs
                    boolean[] visited = new boolean[n];
                    dfs(g, node, n, visited);
                    if (!allVisited(visited, n)) {
                        // fill res
                        fillResult(node, i, res);
                    }
                    current.neighbours[i] = true;
                    g.graph[i].neighbours[node] = true;
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph g = makeGraph(n);
        g = fillNeighbours(n, g, connections);
        List<List<Integer>> result = new ArrayList<>();
        skeletalDfs(n, g, result);
        return result;
    }

    public static void main(String[] args) {
        CriticalRouters s = new CriticalRouters();
        List<List<Integer>> arg = new ArrayList<List<Integer>>();
        List<Integer> list = Arrays.asList(0, 1);
        arg.add(list);
        list = Arrays.asList(0, 2);
        arg.add(list);
        list = Arrays.asList(1, 2);
        arg.add(list);
        list = Arrays.asList(2, 3);
        arg.add(list);
        list = Arrays.asList(2, 5);
        arg.add(list);
        list = Arrays.asList(3, 4);
        arg.add(list);
        list = Arrays.asList(5, 6);
        arg.add(list);
        list = Arrays.asList(5, 8);
        arg.add(list);
        list = Arrays.asList(6, 7);
        arg.add(list);
        list = Arrays.asList(7, 8);
        arg.add(list);
        System.out.println(s.criticalConnections(9, arg));
    }
}
