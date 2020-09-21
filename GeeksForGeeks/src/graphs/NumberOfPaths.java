package graphs;

public class NumberOfPaths {

    public static void main(String[] args) {
        System.out.println(findPaths(4));
        System.out.println(numOfPathsToDestMemo(4));
    }

    public static int findPaths(int n) {
        return numOfPathsToDest(0, 0, n);
    }

    private static int numOfPathsToDest(int startX, int startY, int n) {
        int destX = n - 1;
        int destY = n - 1;
        int posNum = 0;
        if ((startX == destX) && (startY == destY))
            posNum++;
        else {
            if ((startX >= startY) && (startX < n) && (startY < n)) {
                posNum += numOfPathsToDest(startX + 1, startY, n);
                posNum += numOfPathsToDest(startX, startY + 1, n);
            }
        }
        return posNum;
    }

    private static int numOfPathsToDestMemo(int n) {
        int destX = n - 1;
        int destY = n - 1;
        int[][] mat = new int[n + 1][n + 1];

        for (int i = 1; i <= destX; i++)
            mat[i][0] = 1;

        for (int j = 1; j <= destY; j++)
            mat[0][j] = 1;

        for (int i = 1; i <= destX; i++)
            for (int j = 1; j <= destY; j++)
                mat[i][j] = mat[i + 1][j] + mat[i][j + 1];

        return mat[destX][destY];

    }

}
