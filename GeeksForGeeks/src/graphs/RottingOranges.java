package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rOrg = new RottingOranges();
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(rOrg.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        class Pair {
            int x = 0;
            int y = 0;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        int unitTime = 0;
        Queue<Pair> Q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] == 2)
                    Q.add(new Pair(i, j));

        Q.add(new Pair(-1, -1));

        int[] rowNbr = new int[]{0, 0, 1, -1};
        int[] colNbr = new int[]{-1, 1, 0, 0};

        Pair temp;

        while (!Q.isEmpty() && Q.size() > 1) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                temp = Q.poll();
                if (temp.x != -1 && temp.y != -1) {
                    for (int k = 0; k < 4; k++) {
                        int x1 = temp.x + rowNbr[k];
                        int y1 = temp.y + colNbr[k];
                        if (isSafe(grid, x1, y1, row, col)) {
                            grid[x1][y1] = 2;
                            Q.add(new Pair(x1, y1));
                        }
                    }
                } else {
                    ++unitTime;
                    Q.add(new Pair(-1, -1));
                }
            }
        }
        return isRottenPossible(grid, row, col) ? -1 : unitTime > 1 ? unitTime - 1 : unitTime;
    }

    private boolean isRottenPossible(int[][] grid, int row, int col) {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid[i][j] == 1)
                    return true;
        return false;
    }

    private boolean isSafe(int[][] grid, int x1, int y1, int row, int col) {
        return (x1 >= 0 && x1 < row) && (y1 >= 0 && y1 < col) && grid[x1][y1] == 1;
    }
}
