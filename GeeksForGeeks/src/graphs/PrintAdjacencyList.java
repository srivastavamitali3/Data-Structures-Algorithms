package graphs;

import java.util.ArrayList;
import java.util.Scanner;

/*Test Case
8 14
0 3
0 1
1 2
1 4
1 5
1 3
2 6
2 4
4 7
5 6
5 2
5 3
5 7
7 1
* */
public class PrintAdjacencyList {
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
            printAdjacencyList(list, nov);
        }
    }

    private static void printAdjacencyList(ArrayList<ArrayList<Integer>> list, int v) {
        for (int i = 0; i < v; i++) {
            System.out.print(i);
            for (int j = 0; j < list.get(i).size(); j++)
                System.out.print("->" + list.get(i).get(j));
            System.out.println();
        }

    }
}

