package arrays;

import java.util.Arrays;

public class MinDifferenceBetweenTwoElements {
    public static void main(String[] args) {
        int arr[] = new int[]/*{1, 5, 3, 19, 18, 25}*/{-1, -3, -2, -1};
        System.out.println("Minimum difference is " +
                findMinDiff(arr, arr.length));
    }

    private static int findMinDiff(int[] arr, int n) {
        int difference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] < difference)
                difference = arr[i + 1] - arr[i];
        return difference;
    }
}
