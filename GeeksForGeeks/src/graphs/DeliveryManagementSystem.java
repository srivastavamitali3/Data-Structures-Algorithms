package graphs;

import java.util.*;

public class DeliveryManagementSystem {

    public static void main(String[] args) {
        int cityNodes = 5;
        List<Integer> cityFrom = new ArrayList<>();
        cityFrom.add(1);
        cityFrom.add(1);
        cityFrom.add(2);
        cityFrom.add(3);
        cityFrom.add(1);
        List<Integer> cityTo = new ArrayList<>();
        cityTo.add(2);
        cityTo.add(3);
        cityTo.add(4);
        cityTo.add(5);
        cityTo.add(5);
        int company = 1;
        System.out.println(order(cityNodes, cityFrom, cityTo, company));
    }

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        List<Integer> res = new ArrayList<>();
       /* ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= cityNodes; i++) {
            adj.add(i, new ArrayList<>(cityNodes));
        }

        int n = cityFrom.size();
        for (int i = 0; i < n; i++) {
            adj.get(cityFrom.get(i)).add(cityTo.get(i));
            adj.get(cityTo.get(i)).add(cityFrom.get(i));
        }

        boolean[] visited = new boolean[cityNodes + 1];*/

        // dfs(adj, visited, result, company);

        //  shortestPath(company, adj, cityNodes);
        List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
      //  List<Integer> res = new ArrayList<Integer>();
        /*if (company==1) {
            res.add(0);
            return res;
        }*/
        int[] degree = new int[cityNodes];
        for(int i=0; i<cityNodes; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<cityNodes; i++) {
            myGraph.get(cityFrom.get(i)).add(cityTo.get(i));
            myGraph.get(cityTo.get(i)).add(cityFrom.get(i));
            degree[cityFrom.get(i)]++;
            degree[cityTo.get(i)]++;
        }
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        for(int i=0; i<cityNodes; i++)
            if (degree[i]==0)
                return res;
            else if (degree[i]==1) {
                myQueue.offer(i);
            }

        while (!myQueue.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = myQueue.size();

            for(int i=0; i<count; i++){
                int curr = myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for(int k=0; k<myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next]==0) continue;
                    if (degree[next]==2) {
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }
        }
        return res;
      //  return result;
    }


}



    /*private static void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result, int company) {
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
    }*/

