package slidingwindow;

/*
Given a binary array, find the maximum number of consecutive 1s in this array.
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(arr));
        System.out.println(findMaxConsecutiveOnesII(arr));
        System.out.println(findMaxConsecutiveOnesIII(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(findMaxConsecutiveOnesIII(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        /*int flip_zero = 0, flip_one = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flip_zero += 1;
                flip_one += 1;
            } else {
                flip_one = flip_zero + 1;
                flip_zero = 0;
            }
            max = Math.max(max, flip_one);
        }
        return max;*/

        int max_ones = Integer.MIN_VALUE;
        int ones = 0, zeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
                zeroes = 0;
            } else {
                ones = 0;
                zeroes++;
            }
            max_ones = Math.max(max_ones, ones);
        }
        return max_ones;
    }

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     * Input: [1,0,1,1,0]
     * Output: 4
     * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     */
    public static int findMaxConsecutiveOnesII(int[] nums) {
        int flip_zero = 0, flip_one = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flip_zero += 1;
                flip_one += 1;
            } else {
                flip_one = flip_zero + 1;
                flip_zero = 0;
            }
            max = Math.max(max, flip_one);
        }
        return max;
    }

    /**
     * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
     *
     * Return the length of the longest (contiguous) subarray that contains only 1s.
     * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * Output: 6
     * Explanation:
     * [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
     *
     * @param nums
     * @param K
     * @return
     */
    public static int findMaxConsecutiveOnesIII(int[] nums, int K) {
        int zeroCount = 0, j = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;

            while (zeroCount > K) {
                if (nums[j++] == 0)
                    zeroCount--;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
