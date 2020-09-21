package slidingwindow;

public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(findMaximumSumSubArrayOfSizeK(new int[]{100, 200, 300, 400}, 2));
        System.out.println(findMaximumSumSubArrayOfSizeK(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
    }

    private static int findMaximumSumSubArrayOfSizeK(int[] arr, int k) {
        int maxSum = 0, currSum = 0;
        for (int i = 0; i < k; i++)
            currSum += arr[i];
        maxSum = currSum;
        for (int j = k; j < arr.length; j++) {
            currSum -= arr[j - k];
            currSum += arr[j];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
