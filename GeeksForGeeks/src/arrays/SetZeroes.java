package arrays;

public class SetZeroes {
    public static void main(String[] args) {
        int mat[][] = {{1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}};

        System.out.println("Input Matrix :");
        printMatrix(mat);

        modifyMatrix(mat);

        System.out.println("Matrix After Modification :");
        printMatrix(mat);

    }

    private static void modifyMatrix(int[][] matrix) {
        boolean row_flag = false;
        boolean col_flag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && matrix[i][j] == 0)
                    row_flag = true;
                if (j == 0 && matrix[i][j] == 0)
                    col_flag = true;

                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
        }

        if (row_flag) {
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }

        if (col_flag) {
            for (int j = 0; j < matrix.length; j++)
                matrix[j][0] = 0;
        }
    }

    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }

}
