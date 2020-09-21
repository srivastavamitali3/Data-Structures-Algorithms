package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int mat[][] = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    mat[i][j] = sc.nextInt();
            }

            System.out.println(findRottenOrangesUnitTime(mat, N, M));
        }
    }

    static class Indexes {
        int x = 0;
        int y = 0;

        Indexes(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int findRottenOrangesUnitTime(int[][] mat, int row, int col) {
        int unitTime = 0;
        Queue<Indexes> Q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                if (mat[i][j] == 2)
                    Q.add(new Indexes(i, j));
        }

        Q.add(new Indexes(-1, -1));

        int[] rowNbr = new int[]{-1, 1, 0, 0};
        int[] colNbr = new int[]{0, 0, -1, 1};
        Indexes temp;
        while (!Q.isEmpty() && Q.size() > 1) {
            int size = Q.size();
            for (int l = 0; l < size; l++) {
                temp = Q.poll();
                if (temp.x != -1 && temp.y != -1) {
                    for (int k = 0; k < 4; k++) {
                        int x1 = temp.x + rowNbr[k];
                        int y1 = temp.y + colNbr[k];
                        if (isSafe(mat, x1, y1, row, col)) {
                            mat[x1][y1] = 2;
                            Q.add(new Indexes(x1, y1));
                        }
                    }
                } else {
                    ++unitTime;
                    Q.add(new Indexes(-1, -1));
                }
            }

        }

        return isRottenPossible(mat, row, col) ? -1 : unitTime - 1;
    }

    private static boolean isRottenPossible(int[][] mat, int row, int col) {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (mat[i][j] == 1)
                    return true;
        return false;
    }

    private static boolean isSafe(int[][] mat, int x1, int y1, int row, int col) {
        return ((x1 >= 0 && x1 < row) && (y1 >= col && y1 < col) && (mat[x1][y1] == 1));
    }
}
