import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CheckYourRoute {
    private static final int INF = 1_000_000;

    public boolean[] classifyEdges(int size, int[][] edges) {
        List<Integer>[] graph = buildGraph(size, edges);
        Set<Integer>[] cameFrom = shortestPath(size, graph, edges); // set of edge indecies
        boolean[] result = new boolean[edges.length];
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(size));
        while (!q.isEmpty()) {
            for (int i : cameFrom[q.poll()]) {
                result[i] = true;
                q.add(edges[i][0]);
            }
        }
        return result;
    }

    private Set<Integer>[] shortestPath(int n, List<Integer>[] graph, int[][] edges) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        Set<Integer>[] cameFrom = new Set[n + 1]; // nodes are 1 based
        Arrays.setAll(cameFrom, (i) -> new HashSet<>());

        int[] costSoFar = new int[n + 1];
        Arrays.fill(costSoFar, 2, n + 1, INF);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int from = curr.id;
            for (int idx : graph[from]) {
                int[] edge = edges[idx];
                int to = edge[1];
                int newCost = costSoFar[from] + edge[2];
                if (newCost <= costSoFar[to]) {
                    costSoFar[to] = newCost;
                    cameFrom[to].add(idx);
                    if (!visited[to]) {
                        visited[to] = true;
                        pq.add(new Node(to, newCost));
                    }
                }
            }
        }
        return cameFrom;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, (i) -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(i);
        }
        return graph;
    }

    private static class Node implements Comparable<Node> {
        int id, cost;

        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        public int compareTo(Node that) {
            return Integer.compare(this.cost, that.cost);
        }
    }

    public static void main(String[] args) {
        test(4,
                new int[][]{{1, 2, 1}, {2, 4, 1}, {1, 3, 1}, {3, 4, 2}, {1, 4, 2}},
                new boolean[]{true, true, false, false, true});
        test(5,
                new int[][]{{1, 2, 1}, {2, 3, 1}, {3, 5, 1}, {1, 4, 1}, {4, 5, 2}, {3, 4, 2}, {2, 4, 4}},
                new boolean[]{true, true, true, true, true, false, false});
        test(4,
                new int[][]{{1, 2, 1}, {1, 3, 1}, {1, 4, 1}, {2, 3, 1}, {2, 4, 1}},
                new boolean[]{false, false, true, false, false});
    }


    private static void test(int n, int[][] edges, boolean[] expected) {
        CheckYourRoute m = new CheckYourRoute();
        boolean[] actual = m.classifyEdges(n, edges);
        if (Arrays.equals(actual, expected)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("Failed! Expected: " + Arrays.toString(expected) + ", but actual: " + Arrays.toString(actual));
        }
    }
}