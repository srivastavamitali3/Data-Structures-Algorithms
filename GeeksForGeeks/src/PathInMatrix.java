import java.util.Scanner;

public class PathInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int order_of_matrix = sc.nextInt();
            int[][] arr = new int[order_of_matrix][order_of_matrix];
            for (int i = 0; i < order_of_matrix; i++)
                for (int j = 0; j < order_of_matrix; j++)
                    arr[i][j] = sc.nextInt();
            int n = maxCandies(arr, order_of_matrix);
            System.out.println(n);
        }
    }

    private static int maxCandies(int[][] arr, int n) {
        int res = -1;
        for (int i = 0; i < n; i++)
            res = Math.max(res, arr[0][i]);
        for (int i = 1; i < n; i++) {
            res = -1;
            for (int j = 0; j < n; j++) {
                //when all path is possible
                if (j > 0 && j < n - 1)
                    arr[i][j] += Math.max(arr[i - 1][j], Math.max(arr[i - 1][j - 1], arr[i - 1][j + 1]));
                    //when diagonal right is not possible
                else if (j > 0)
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                    //when diagonal left is not possible
                else if (j < n - 1)
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j + 1]);

                res = Math.max(arr[i][j], res);
            }
        }
        return res;
    }
}
