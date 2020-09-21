package graphs;

import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class RottenOranges {

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

    private static int findRottenOrangesUnitTime(int[][] mat, int row, int col) {
        int unitTime = 0;
        Queue<Indexes> Q = new LinkedList<>();
        //System.out.print("Adding to Q :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 2) {
                    //System.out.print("(" + i + "," + j + "),");
                    Q.add(new Indexes(i, j));
                }

            }
        }
        Q.add(new Indexes(-1, -1));

        int[] rowNbr = new int[]{-1, 1, 0, 0};
        int[] colNbr = new int[]{0, 0, -1, 1};

        Indexes temp;
        //System.out.println("\nAdding Rotten indexes to Q :");
        while (!Q.isEmpty() && Q.size() > 1) {
            int size = Q.size();
            for (int l = 0; l < size; l++) {
                temp = Q.poll();
                //System.out.println("\nValue of temp :"+temp.x+","+temp.y);
                if (temp.x != -1 && temp.y != -1) {

                    for (int k = 0; k < 4; k++) {
                        int x1 = temp.x + rowNbr[k];
                        int y1 = temp.y + colNbr[k];
                        if (isSafe(mat, x1, y1, row, col)) {
                            //System.out.print("(" + x1 + "," + y1 + "),");
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                if (mat[i][j] == 1)
                    return true;
        }
        return false;
    }

    private static boolean isSafe(int[][] mat, int x, int y, int row, int col) {
        return ((x >= 0 && x < row) && (y >= 0 && y < col) && mat[x][y] == 1);
    }

    static class Indexes {
        int x = 0;
        int y = 0;

        Indexes(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}