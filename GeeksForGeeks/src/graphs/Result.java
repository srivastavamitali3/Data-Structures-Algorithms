package graphs;

import java.util.*;

class Result {

    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH city
     *  2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        List<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//
        for (int i = 0; i <= cityNodes; i++) {
            adj.add(i, new ArrayList<>(cityNodes));
        }
//
        int n = cityFrom.size();
        for (int i = 0; i < n; i++) {
            adj.get(cityFrom.get(i)).add(cityTo.get(i));
            adj.get(cityTo.get(i)).add(cityFrom.get(i));
        }
        int[] source = new int[cityNodes + 1];
        for (int i = 1; i < cityNodes; i++)
            source[i] = 0;
        for (int i = 0; i <= company; i++)
            source[cityFrom.get(i)] = 1;

        // loop through all the vertices and run
        // a BFS from each vertex to find the distance
        // to nearest town from it
        boolean[] visited = new boolean[cityNodes + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                visited[j] = false;
            bfs(adj, visited, result, company);
        }
        return result;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result, int company) {
        Queue<Integer> queue = new LinkedList<>();

        visited[company] = true;

        queue.add(company);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr != company)
                result.add(curr);

            ArrayList<Integer> list = adj.get(curr);
            Collections.sort(list);
            Iterator<Integer> itr = list.listIterator();

            while (itr.hasNext()) {
                int currentVertex = itr.next();
                if (!visited[currentVertex]) {
                    visited[currentVertex] = true;
                    queue.add(currentVertex);
                }
            }
        }
    }

}
