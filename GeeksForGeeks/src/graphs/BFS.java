package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for (int i = 0; i < nov; i++)
                vis[i] = false;
            bfs(1, list, vis, nov);
            System.out.println();
        }
    }

    private static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean[] vis, int vertices) {
        Queue<Integer> Q = new LinkedList<>();
        vis[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            s = Q.poll();
            System.out.print(s + " ");
            for (int i = 0; i < list.get(s).size(); i++) {
                int node = list.get(s).get(i);
                if (vis[node] == false) {
                    vis[node] = true;
                    Q.add(node);
                }
            }
        }
    }
}
