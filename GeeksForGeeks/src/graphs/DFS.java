package graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
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
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for (int i = 0; i < nov; i++)
                vis[i] = false;
            dfs(0, list, vis);
            System.out.println();
        }
    }

    private static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
        Stack<Integer> st = new Stack<>();
        st.push(src);
        while (!st.isEmpty()) {
            int temp = st.pop();
            if (!vis[temp]) {
                System.out.print(temp + " ");
                vis[temp] = true;
            }
            ArrayList<Integer> al = list.get(temp);
            for (int i = al.size() - 1; i >= 0; i--) {
                int edge = al.get(i);
                if (!vis[edge])
                    st.push(edge);
            }

        }
    }
}
