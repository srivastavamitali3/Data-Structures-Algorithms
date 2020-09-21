package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Test cases {'O', 'O'}, {'O', 'O'}
 * {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions obj = new SurroundedRegions();
        char[][] board = new char[][]{{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
        obj.solve(board);
    }

    public void solve(char[][] board) {
        int row = board.length, col = board.length;

        boolean[][] visited = new boolean[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1 && board[i][j] == 'O' || board[i][j] == 'X') {
                    board[i][j] = board[i][j];
                } else if (!visited[i][j] && board[i][j] == 'O') {
                    dfs(i, j, board, row, col, visited);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(board[i][j] + ' ');
            System.out.println();
        }
    }

    private static void dfs(int x, int y, char[][] board, int row, int col, boolean[][] visited) {
        int[] rowNbr = new int[]{-1, 1, 0, 0};
        int[] colNbr = new int[]{0, 0, -1, 1};

        visited[x][y] = true;
        board[x][y] = 'X';
        for (int i = 0; i < 4; i++) {
            int x1 = x + rowNbr[i];
            int y1 = y + colNbr[i];
            if (isSafe(board, x1, y1, row, col, visited)) {
                board[x1][y1] = 'X';
                dfs(x1, y1, board, row, col, visited);
            }
        }
    }

    private static boolean isSafe(char[][] board, int x1, int y1, int row, int col, boolean[][] visited) {
        return ((x1 >= 0 && x1 < row) && (y1 >= 0 && y1 < col) && (board[x1][y1] == 'X') && !visited[x1][y1]);
    }
}
