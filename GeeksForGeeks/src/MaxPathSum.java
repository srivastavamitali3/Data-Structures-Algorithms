public class MaxPathSum {
    public static void main(String[] args) {
        int tri[][] = {{3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}};
        System.out.println(maxPathSum(tri, 3, 3));
    }

    private static int maxPathSum(int[][] tri, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (tri[i + 1][j] > tri[i + 1][j + 1])
                    tri[i][j] += tri[i + 1][j];
                else
                    tri[i][j] += tri[i + 1][j + 1];
            }
        }
        return tri[0][0];
    }
}
