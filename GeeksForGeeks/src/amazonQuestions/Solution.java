package amazonQuestions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static boolean[] prune(int[][][] adj, boolean[] isLett) {
        int n = adj.length;
        int[] degree = new int[n];
        for (int i = 0; i < n; ++i) degree[i] = adj[i].length;
        boolean[] rem = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (!isLett[i] && degree[i] == 1) q.add(i);
        }
        while (!q.isEmpty()) {
            int leaf = q.remove();
            rem[leaf] = true;
            for (int[] edge : adj[leaf]) {
                int node = edge[0];
                if (isLett[node]) break;
                else if (!rem[node]) {
                    if (--degree[node] == 1) {
                        q.add(node);
                        break;
                    }
                }
            }
        }
        return rem;
    }

    static int[] bfs(int[][][] adj, boolean[] rem, int source) {
        int n = adj.length, unvis = -1;
        int[] dist = new int[n];
        for (int i = 0; i < n; ++i) dist[i] = unvis;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        dist[source] = 0;
        int best = 0, total = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int[] edge : adj[x]) {
                int to = edge[0];
                if (!rem[to] && dist[to] == unvis) {
                    int weight = edge[1];
                    total += weight;
                    q.add(to);
                    dist[to] = dist[x] + weight;
                    if (dist[to] > dist[best]) best = to;
                }
            }
        }
        int[] result = {total, dist[best], best};
        return result;
    }

    static int solve(int[][][] adj, int[] lett) {
        boolean[] isLett = new boolean[adj.length];
        for (int i : lett) isLett[i] = true;
        boolean[] rem = prune(adj, isLett);
        int[] result = bfs(adj, rem, lett[0]);
        int totalWeight = result[0], sink = result[2];
        result = bfs(adj, rem, sink);
        int diameter = result[1];
        return 2 * totalWeight - diameter;
    }

    static int[][][] weightedAdjacency(int gNodes, int[] gFrom, int[] gTo, int[] gWeight) {
        int[] count = new int[gNodes];
        for (int f : gFrom) ++count[f];
        for (int t : gTo) ++count[t];
        int[][][] adj = new int[gNodes][][];
        for (int i = 0; i < gNodes; ++i)
            adj[i] = new int[count[i]][];
        for (int i = 0; i < gFrom.length; ++i) {
            adj[gFrom[i]][--count[gFrom[i]]] = new int[]{gTo[i], gWeight[i]};
            adj[gTo[i]][--count[gTo[i]]] = new int[]{gFrom[i], gWeight[i]};
        }
        return adj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] lett = new int[k];
        for (int i = 0; i < k; ++i) lett[i] = sc.nextInt() - 1;
        int[] from = new int[n - 1], to = new int[n - 1], d = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            from[i] = sc.nextInt() - 1;
            to[i] = sc.nextInt() - 1;
            d[i] = sc.nextInt();
        }
        sc.close();
        String[] strings = new String[from.length];

        Arrays.asList(strings);
        int[][][] adj = weightedAdjacency(n, from, to, d);
        System.out.println(solve(adj, lett));
    }
}
