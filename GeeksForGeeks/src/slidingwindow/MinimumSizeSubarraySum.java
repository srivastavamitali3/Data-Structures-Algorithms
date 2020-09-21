package slidingwindow;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of
 * which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println("Minimum Size of Sub Array With Sum Greater Than Given Sum : " +
                new MinimumSizeSubarraySum().minSubArrayLen(8, new int[]{4, 2, 2, 7, 8, 1, 2, 8, 10}));
        System.out.println("Minimum Size of Sub Array With Sum Greater Than Given Sum : " +
                new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int targetSum, int[] arr) {
        int n = arr.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > targetSum) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

}
