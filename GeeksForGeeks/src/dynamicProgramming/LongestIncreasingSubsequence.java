package dynamicProgramming;

import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n + 1];
        Arrays.fill(LIS, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);

            ans = Math.max(LIS[i], ans);
        }
        return ans;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
