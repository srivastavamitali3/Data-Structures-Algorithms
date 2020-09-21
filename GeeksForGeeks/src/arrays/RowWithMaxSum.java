package arrays;

import java.util.ArrayList;
import java.util.List;

public class RowWithMaxSum {
    public static int N;

    public static void main(String[] args) {
        N = 5;
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {5, 3, 1, 4, 2},
                {5, 6, 7, 8, 9},
                {0, 6, 3, 4, 12},
                {9, 7, 12, 4, 3},
        };
        List<Integer> ans = colMaxSum(mat);
        System.out.println("Row " + (ans.get(0) + 1) + " has max sum "
                + ans.get(1));
    }

    private static List<Integer> colMaxSum(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += mat[i][j];
                if (sum > maxSum) {
                    maxSum = sum;
                    index = i;
                }
            }
            sum = 0;
        }
        result.add(index);
        result.add(maxSum);
        return result;
    }
}
