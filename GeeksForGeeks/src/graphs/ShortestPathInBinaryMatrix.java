package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 1},
                {1, 0}
        };

        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0 || grid[0][0] != 0)
            return -1;

        Pair source = new Pair(0, 0);
        Queue<Pair> Q = new LinkedList<>();
        Q.add(source);
        int len = 1;

        int[] dx = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        while (!Q.isEmpty()) {
            int qSize = Q.size();

            for (int i = 0; i < qSize; i++) {
                Pair curr = Q.poll();

                int x = curr.x;
                int y = curr.y;

                if (x == n - 1 && y == n - 1)
                    return len;
                for (int j = 0; j < 8; j++) {
                    int x1 = x + dx[j];
                    int y1 = y + dy[j];
                    if (isSafe(x1, y1, grid, n)) {
                        grid[x1][y1] = 1;
                        Q.add(new Pair(x1, y1));
                    }
                }
            }
            len++;
        }

        return -1;
    }

    private boolean isSafe(int x, int y, int[][] grid, int n) {
        return (x >= 0 && x < n) && (y >= 0 && y < n) && (grid[x][y] == 0);
    }
}
