package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class TopologicalSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);
            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);

            }


            int res[] = new int[10001];
            res = new TopologicalSort().topoSort(list, nov);
            boolean valid = true;

            for (int i = 0; i < nov; i++) {
                int n = list.get(res[i]).size();
                for (int j = 0; j < list.get(res[i]).size(); j++) {
                    for (int k = i + 1; k < nov; k++) {
                        if (res[k] == list.get(res[i]).get(j))
                            n--;
                    }
                }
                if (n != 0) {
                    valid = false;
                    break;
                }
            }
            if (!valid)
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

class TopologicalSort {

    public int[] topoSort(ArrayList<ArrayList<Integer>> list, int noOfVertices) {
        int[] topologicalSortOrder = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];
        int index = 0;
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i])
                dfs(i, list, visited, index, topologicalSortOrder);
        }
        return topologicalSortOrder;
    }

    private void dfs(int sourceIndex, ArrayList<ArrayList<Integer>> list, boolean[] visited, int index, int[] topologicalSortOrder) {
        visited[sourceIndex] = true;
        topologicalSortOrder[index] = sourceIndex;

        Iterator itr = list.get(sourceIndex).iterator();
        while (itr.hasNext()) {
            int currentIndex = (int) itr.next();
            if (!visited[currentIndex])
                dfs(currentIndex, list, visited, ++index, topologicalSortOrder);
        }
    }
}
