package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XTotalShapes {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(
                System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] st = read.readLine().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);

            List<List<Character>> list = new ArrayList<>();

            for (int i = 0; i < N + 1; i++)
                list.add(i, new ArrayList<Character>(M));

            String[] strings = read.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                char[] k = strings[i].toCharArray();
                for (int j = 0; j < k.length; j++) {
                    list.get(i).add(k[j]);
                }
            }

            System.out.println(findX(list, N, M));
        }
    }

    private static int findX(List<List<Character>> list, int row, int col) {
        boolean[][] visited = new boolean[row + 1][col + 1];
        int count = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (!visited[i][j] && list.get(i).get(j) == 'X') {
                    dfs(visited, list, i, j, row, col);
                    count++;
                }
        return count;
    }

    private static void dfs(boolean[][] visited, List<List<Character>> list, int x, int y, int row, int col) {
        visited[x][y] = true;
        int[] rowNbr = new int[]{0, 0, 1, -1};
        int[] colNbr = new int[]{-1, 1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int x1 = x + rowNbr[k];
            int y1 = y + colNbr[k];
            if (isSafe(x1, y1, row, col, list, visited))
                dfs(visited, list, x1, y1, row, col);
        }
    }

    private static boolean isSafe(int x1, int y1, int row, int col, List<List<Character>> list, boolean[][] visited) {
        return ((x1 >= 0 && x1 < row) && (y1 >= 0 && y1 < col) && !visited[x1][y1] && (list.get(x1).get(y1) == 'X'));
    }
}
