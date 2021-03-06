package slidingwindow;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Sample Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaximumSlidingWindow {
    public static void main(String[] args) {
        int[] res = new MaximumSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : res)
            System.out.print(i + " ");
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int maxNumber = Integer.MIN_VALUE;
        int i = 0, index = 0;
        int j = 0;
        boolean addNumber = false;
        while (i < nums.length) {
            for (i = index; i < index + k; i++) {
                maxNumber = Math.max(maxNumber, nums[i]);
                addNumber = true;
            }
            index++;
            if (addNumber && maxNumber != Integer.MIN_VALUE)
                res[j++] = maxNumber;
            maxNumber = Integer.MIN_VALUE;
        }
        return nums.length == 1 ? nums : res;
    }

    public static int[] maxSlidingWindowI(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int x = 0;
        int maxInCurrentWindow = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= maxInCurrentWindow) {
                maxInCurrentWindow = nums[i];
            }
        }
        res[x++] = maxInCurrentWindow;
        int right = k;
        for (int left = 1; left < nums.length - k + 1; left++) {
            if (nums[left - 1] != maxInCurrentWindow) {
                if (nums[right] >= maxInCurrentWindow) {
                    maxInCurrentWindow = nums[right];
                }
            } else {
                maxInCurrentWindow = findMaxInCurrentWindow(nums, left, left + k);
            }
            right++;
            res[x++] = maxInCurrentWindow;
        }
        return res;
    }

    private static int findMaxInCurrentWindow(int[] nums, int left, int right) {
        int max = nums[left];

        for (int i = left + 1; i < right; i++)
            max = Math.max(max, nums[i]);

        return max;
    }
}
