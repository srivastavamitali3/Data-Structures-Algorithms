package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class FindIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }


            System.out.println(findIslands(list, N, M));

        }
    }

    private static int findIslands(ArrayList<ArrayList<Integer>> list, int row, int col) {
        boolean[][] visited = new boolean[row + 1][col + 1];
        int count = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (!visited[i][j] && list.get(i).get(j) == 1) {
                    dfs(i, j, list, row, col, visited);
                    count++;
                }
        return count;
    }

    private static void dfs(int x, int y, ArrayList<ArrayList<Integer>> list, int row, int col, boolean[][] visited) {
        int[] rowNbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int x1 = x + rowNbr[i];
            int y1 = y + colNbr[i];
            if (isSafe(x1, y1, row, col, list, visited))
                dfs(x1, y1, list, row, col, visited);
        }
    }

    private static boolean isSafe(int x1, int y1, int row, int col, ArrayList<ArrayList<Integer>> list, boolean[][] visited) {
        return ((x1 >= 0 && x1 < row) && (y1 >= 0 && y1 < col) && (list.get(x1).get(y1) == 1) && !visited[x1][y1]);
    }
}
